import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import io.Display;
import io.KeyManager;

import gamestates.State;
import gamestates.MenuState;
import gamestates.GameState;

import time.*;

/* O método game estende Runnable porque o jogo deverá ser executado numa thread
 * Esta classe é responsável por:
 *   *Iniciar a thread (método start)
 *     -Inicializar variáveis e classes básicas (método init, chamado pelo start)
 *   *Rodar o loop principal, até que decida-se fechar o programa (método run)
 *     -O método run é responsável por de tempos em tempos:
 *       -fazer um update de todos os objetos no jogo (método update)
 *       -renderizar a tela (método draw)
 *   *Finalizar a thread (método stop)
 */


public class Game implements Runnable {
	//Frame
	private Display display;
	private int width, height;
	public String title;
	
	//Threads
	private boolean running = false;
	private Thread thread;
	
	//Renderização
	private BufferStrategy bs;
	private Graphics g;
	
	//Estados (escolha da dificuldade e jogo)
	public State gameState;
	public State menuState;
	
	//Input
	private KeyManager keyManager;
	
	public Game(String title) {
		this.title = title;
		keyManager = new KeyManager();
	}
	
	
	private void init() {
		width = 300;
		height = 700;
		display = new Display(title, width, height);//Título, altura, largura da janela
		display.getFrame().addKeyListener(keyManager);
			
		//gameState = new GameState();
		menuState = new MenuState();
		
		State.setState(menuState);
		State.setKeyManager(this.keyManager);
	}
	
	private void update() {
		try {
			State.getState().update();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//Limpar o que já está renderizado
		g.clearRect(0, 0, width, height);
		
		//Pintar um fundo preto
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		
		//Renderizar o estado atual
		State.getState().render(g);
		
		//Mostrar os pixels
		bs.show();
		g.dispose();
	}

  //Iniciar a thread -- Este método deve ser chamado por uma classe de fora (Tetris, no main) para iniciar o jogo
	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	
	@Override
	public void run() {
		try{
			init();
		
			while(running) {
				
				Time.update();
				if(Time.getDelta() >= 1) {
					update();
					render();
					Time.updateTicksDelta();
				}
				Time.updateTimer();
			}
			
			stop();
	
		}
		catch (Exception e) {
			e.printStackTrace();;
		}

	}
	
	//Finalizar o jogo e encerrar as threads
	public synchronized void stop() {
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public Display getDisplay() {
		return this.display;
	}
	
}

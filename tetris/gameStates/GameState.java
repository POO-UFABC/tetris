package gamestates;

import java.awt.Graphics;
import java.awt.Color;

import gamestates.MenuState;

import base.*;

public class GameState extends State{			
	private FixedStructure fixedStructure;
	private PlayableStructure playableStructure;
	
	private final int initialPosX = 5;
	private final int initialPosY = 23;

	private final int borderSizeX = 15;
	private final int borderSizeY = 25;

	private Thread timerThread;
	private Timer timer;

	private boolean gameOver = false;
	
	private Randomizer randomizer;

	public GameState() {
		this.randomizer = new Randomizer();

		this.fixedStructure = new FixedStructure(0, 0, borderSizeX, borderSizeY);
		this.playableStructure = this.randomizer.getRandomPiece(initialPosX, initialPosY);

		this.timer = new Timer(500 - this.getGameMode()*200);
		this.timerThread = new Thread(timer);
		this.timerThread.start();
	}
	
	@Override
	public void update() {
		if (!this.gameOver){
			boolean[] keys = this.updateKeys();

			if (playableStructure.getBlocks() == null) {
				this.playableStructure = this.randomizer.getRandomPiece(initialPosX, initialPosY);
			}

			if (keys[0]) {
				this.playableStructure.rotate(this.fixedStructure);
			}
			if (keys[1]) {
				this.gameOver = this.playableStructure.moveY(1, this.fixedStructure);
			}
			if (keys[2]) {
				this.playableStructure.moveX(-1, this.fixedStructure);
			}
			if (keys[3]) {
				this.playableStructure.moveX(+1, this.fixedStructure);
			}

			if (this.timer.isTriggered() && this.playableStructure.getBlocks() != null) {
				this.gameOver = this.playableStructure.moveY(1, this.fixedStructure);
				this.timer.reset();
			}
		}
		else {
			boolean[] keys = this.updateKeys();
			if (keys[0]) {
				State.setState(new MenuState());
			}
		}
	}


	private boolean[] updateKeys() {
		boolean output[] = new boolean[4];
		if (State.getKeyManager().getZero()) {
		  output[0] = true;
		}
		if (State.getKeyManager().getDown()) {
	    output[1] = true;
		}
		if (State.getKeyManager().getLeft()) {
		  output[2] = true;
		}
		if (State.getKeyManager().getRight()) {
			output[3] = true;
		}
		return output;
	} 
/*
	private boolean mobileIsInside(int x, int y) {
		if ((x >= this.playableStructure.getPosX())
			  && (x < this.playableStructure.getPosX() + 5)
			  && (y >= this.playableStructure.getPosY())
			  && (y < this.playableStructure.getPosY() + 5)
			  && (this.playableStructure.blockExists(x - this.playableStructure.getPosX(), y - this.playableStructure.getPosY()))) {
			return true;
		}
		return false;
	}*/

	@Override
	public void render(Graphics g) {
		this.playableStructure.render(700, g);
		this.fixedStructure.render(700, g);

		if (this.gameOver) {
			g.setColor(Color.red);
			g.drawString("Fim de Jogo :(", 120, 40);
			g.drawString("Aperte 0 para voltar ao Menu Principal", 120, 60);
		}
	}
}

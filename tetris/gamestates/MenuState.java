package gamestates;

import java.awt.Graphics;
import java.awt.Color;

import io.KeyManager;

import gamestates.GameState;

public class MenuState extends State{ 

	@Override
	public void update() {
	  //Zero escolhe a dificuldade selecionada e muda o estado
	  if (State.getKeyManager().getZero()) {
	    State.setState(new GameState());
	  }
	  
	  //Apertar a tecla seta esquerda decrementa a dificuldade
	  if (State.getKeyManager().getLeft()) {
	    this.incrementGameMode(-1);
	  }

    //Apertar a tecla seta direita incrementa a dificuldade
	  if (State.getKeyManager().getRight() == true) {
		this.incrementGameMode(+1);
	  }
	}
	
	private void incrementGameMode(int increment) {
		State.setGameMode(State.getGameMode() + increment);
		if (State.getGameMode() > 2) {
		  State.setGameMode(0);
		}
		else if (State.getGameMode() < 0) {
		  State.setGameMode(2);
		}
	}

	@Override
	public void render(Graphics g) {	  
		g.setColor(Color.white);
		g.drawString("=TETRIS=", 110, 200);
		
		if (State.getGameMode() == 0){
		  g.drawString(">Facil<", 50, 260);
		  g.drawString("Medio", 120, 260);
		  g.drawString("Dificil", 190, 260);
		
		} else if (State.getGameMode() == 1){
		  g.drawString("Facil", 50, 260);
		  g.drawString(">Medio<", 120, 260);
		  g.drawString("Dificil", 190, 260);
		
		} else if (State.getGameMode() == 2) {
		
		  g.drawString("Facil", 50, 260);
		  g.drawString("Medio", 120, 260);
		  g.drawString(">Dificil<", 190, 260);
		}
	}

}

package gameStates;

import java.awt.Graphics;
import java.awt.Color;

import io.KeyManager;

import gameStates.GameState;

public class MenuState extends State{ 
  private boolean justPressedRight = false;
  private boolean justPressedLeft = false;

	public void update() {
	  if (State.getKeyManager().getZero()) {
	    System.out.println("(MENU) ZERO");
	    GameState gameState = new GameState();
	    State.setState(gameState);
	  }
	  if (State.getKeyManager().getDown()) {
	    System.out.println("(MENU) DOWN");
	  }
	  
	  //Apertar a tecla seta esquerda decrementa a dificuldade
	  if (State.getKeyManager().getLeft() == true) {
	    if (this.justPressedLeft == false) {
	      this.incrementGameMode(-1);
	      this.justPressedLeft = true;
	    }
	  }
	  if (State.getKeyManager().getLeft() == false) {
	    this.justPressedLeft = false;
	  }  

    //Apertar a tecla seta direita incremenra a dificuldade
	  if (State.getKeyManager().getRight() == true) {
	    if (this.justPressedRight == false) {
	      this.incrementGameMode(+1);
	      this.justPressedRight = true;
	    }
	  }
	  if (State.getKeyManager().getRight() == false) {
	    this.justPressedRight = false;
	  }
	}
	
	private void incrementGameMode(int increment) {
    this.setGameMode(this.getGameMode() + increment);
    if (this.getGameMode() > 2) {
      this.setGameMode(0);
    }
    else if (this.getGameMode() < 0) {
      this.setGameMode(2);
    }
	}

	public void render(Graphics g) {	  
    g.setColor(Color.white);
    g.drawString("=TETRIS=", 210, 200);
    
    if (this.getGameMode() == 0){
      g.drawString(">Facil<", 120, 260);
      g.drawString("Medio", 200, 260);
      g.drawString("Dificil", 290, 260);
	  }
	  
	  else if (this.getGameMode() == 1){
      g.drawString("Facil", 120, 260);
      g.drawString(">Medio<", 200, 260);
      g.drawString("Dificil", 290, 260);
	  }
	  
	  else if (this.getGameMode() == 2){
      g.drawString("Facil", 120, 260);
      g.drawString("Medio", 200, 260);
      g.drawString(">Dificil<", 290, 260);
	  }
	}

}

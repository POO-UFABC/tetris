package gameStates;

import java.awt.Graphics;
import java.awt.Color;

import gameStates.MenuState;

public class GameState extends State{	
	public void update() {
	  if (State.getKeyManager().getZero()) {
		  System.out.println("(GAME S) ZERO");
		}
		if (State.getKeyManager().getDown()) {
		  System.out.println("(GAME S) DOWN");
		  MenuState menuState = new MenuState();
	    State.setState(menuState);
		}
		if (State.getKeyManager().getLeft()) {
		  System.out.println("(GAME S) LEFT");
		}
		if (State.getKeyManager().getRight()) {
		  System.out.println("(GAME S) RIGHT");
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(20, 50, 50, 70);
		g.setColor(Color.blue);
    g.fillRect(0, 120, 10, 10);
    g.fillRect(400, 120, 10, 10);
    g.fillRect(0, 180, 10, 10);
    g.fillRect(120, 120, 10, 10);
	}

}

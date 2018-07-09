package gameStates;

import java.awt.Graphics;
import java.awt.Color;

import io.KeyManager;

import gameStates.GameState;

public class MenuState extends State{
	public void update() {
		if (State.getKeyManager().getZero()) {
		  System.out.println("(MENU S) ZERO");
		  GameState gameState = new GameState();
		  State.setState(gameState);
		}
		if (State.getKeyManager().getDown()) {
		  System.out.println("(MENU S) DOWN");
		}
		if (State.getKeyManager().getLeft()) {
		  System.out.println("(MENU S) LEFT");
		}
		if (State.getKeyManager().getRight()) {
		  System.out.println("(MENU S) RIGHT");
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(10, 50, 50, 70);
		g.setColor(Color.green);
    g.fillRect(0, 0, 10, 10);
	}

}

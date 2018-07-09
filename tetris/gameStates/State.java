package gameStates;

import java.awt.Graphics;

import io.KeyManager;

public abstract class State {

	private static State currentState = null;
	
	private static KeyManager keyManager = null;
	
	public static void setState(State state) {
		currentState = state;
	}
	
	public static void setKeyManager(KeyManager manager) {
	  keyManager = manager;
	}
	
	public static State getState() {
		return currentState;
	}
	
	public static KeyManager getKeyManager() {
	  return keyManager;
	}
	
	public abstract void update();
	
	public abstract void render(Graphics g);
	
}

package gamestates;

import java.awt.Graphics;

import io.KeyManager;

public abstract class State {

	private static State currentState = null;
	
	private static KeyManager keyManager = null;
	
	private static int gameMode = 0;
	
	public static void setState(State state) {
		currentState = state;
	}
	
	public static void setKeyManager(KeyManager keyManager) {
	  State.keyManager = keyManager;
	}
	
	public static State getState() {
		return currentState;
	}
	
	public static KeyManager getKeyManager() {
	  return keyManager;
	}
	
	public static int getGameMode() {
	  return gameMode;
	}
	
	public static void setGameMode(int gameMode) {
	  Static.gameMode = gameMode;
	}
	
	public abstract void update();
	
	public abstract void render(Graphics g);
	
}

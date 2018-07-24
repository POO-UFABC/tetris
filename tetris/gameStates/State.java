package gamestates;

import java.awt.Graphics;

import io.KeyManager;

public abstract class State {

	private static State CURRENT_STATE = null;
	
	private static KeyManager KEY_MANAGER = null;
	
	private static int GAME_MODE = 0;
	
	public static void setState(State state) {
		CURRENT_STATE = state;
	}
	
	public static void setKeyManager(KeyManager keyManager) {
	  State.KEY_MANAGER = keyManager;
	}
	
	public static State getState() {
		return CURRENT_STATE;
	}
	
	public static KeyManager getKeyManager() {
	  return KEY_MANAGER;
	}
	
	public static int getGameMode() {
	  return GAME_MODE;
	}
	
	public static void setGameMode(int gameMode) {
	  Static.GAME_MODE = gameMode;
	}
	
	public abstract void update();
	
	public abstract void render(Graphics g);
	
}

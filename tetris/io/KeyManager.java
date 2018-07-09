package io;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{

  private boolean down, left, right, zero;

  public KeyManager() {
    //teclas consideradas
	  this.down  = false;
	  this.left  = false;
	  this.right = false;
	  this.zero  = false;
	}
	
	//Método para setar os valores de cada comando em verdadeiro ou falso
	private void setKey(KeyEvent event, boolean state) {
		if (event.getKeyCode() == KeyEvent.VK_DOWN) {
		  this.down = state;
		}
		if (event.getKeyCode() == KeyEvent.VK_LEFT) {
		  this.left = state;
		}
		if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
		  this.right = state;
		}
		if (event.getKeyCode() == KeyEvent.VK_NUMPAD0) {
		  this.zero = state;
		}
	}
	
	@Override
	public void keyPressed(KeyEvent event) {
		this.setKey(event, true);
	}

  @Override
	public void keyReleased(KeyEvent event) {
	  this.setKey(event, false);
	}

  @Override
	public void keyTyped(KeyEvent event) {
	}
	
	//GETTERS & SETTERS
	
	public boolean getDown() {
	  return this.down;
	}
	
	public boolean getLeft() {
	  return this.left;
	}
	
	public boolean getRight() {
	  return this.right;
	}
	
	public boolean getZero() {
	  return this.zero;
	}

}

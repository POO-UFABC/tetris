package io;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import time.*;

public class KeyManager implements KeyListener{

  private boolean down, left, right, zero;
  
  private boolean justPressedLeft  = false;
  private boolean justPressedRight = false;
  private boolean justPressedDown  = false;
  private boolean justPressedZero  = false;
  
  private double last; 
  private double interval; 

  public KeyManager() {
    //teclas consideradas
	  this.down  = false;
	  this.left  = false;
	  this.right = false;
		this.zero  = false;
		this.interval = Time.timePerTick*20;
		this.last  = this.interval;
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
		this.last = Time.now;
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
	  if (this.down && !this.justPressedDown) {
	    this.justPressedDown = true;
	    return true;
	  }
	  if (!this.down) {
	    this.justPressedDown = false;
	  }
	  /*return false;*/
	  if((Time.now-last)>=interval) return this.down;
	  else return false;
	}

	public boolean getLeft() {
	  if (this.left && !this.justPressedLeft) {
	    this.justPressedLeft = true;
	    return true;
	  }
	  if (!this.left) {
	    this.justPressedLeft = false;
	  }
	  /*return false;*/
	  if((Time.now-last)>=interval) return this.left;
	  else return false;
	}
	
	public boolean getRight() {
	  if (this.right && !this.justPressedRight) {
	    this.justPressedRight = true;
	    return true;
	  }
	  if (!this.right) {
	    this.justPressedRight = false;
	  }
	  /*return false;*/
	  if((Time.now-last)>=interval) 
		return this.right;
	  else 
		return false;
	}
	
	public boolean getZero() {
	  if (this.zero && !this.justPressedZero) {
	    this.justPressedZero = true;
	    return true;
	  }
	  if (!this.zero) {
	    this.justPressedZero = false;
	  }
	  return false;
	}

}

package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
	
	private boolean[] keys;
	private boolean up, down, left, right;
	
	public boolean[] getKeys() {
		return keys;
	}


	public void setKeys(boolean[] keys) {
		this.keys = keys;
	}


	public boolean isUp() {
		return up;
	}


	public void setUp(boolean up) {
		this.up = up;
	}


	public boolean isDown() {
		return down;
	}


	public void setDown(boolean down) {
		this.down = down;
	}


	public boolean isLeft() {
		return left;
	}


	public void setLeft(boolean left) {
		this.left = left;
	}


	public boolean isRight() {
		return right;
	}


	public void setRight(boolean right) {
		this.right = right;
	}


	public Keyboard() {
		keys = new boolean[256];
	}

	
	public void update() {
		up = keys [KeyEvent.VK_Z];
		down = keys [KeyEvent.VK_S];
		left = keys [KeyEvent.VK_Q];
		right = keys [KeyEvent.VK_D];
	}
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		System.out.println("Pressed");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}

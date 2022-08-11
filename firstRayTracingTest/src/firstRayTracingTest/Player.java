package firstRayTracingTest;

import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;

public class Player  {
	
	double x, y, velX, velY;
	double speed = 1.4;
	boolean movingLeft, movingRight, movingUp, movingDown;
	Rectangle2D rect;
	
	public Player(double x, double y) {
		this.x = x;
		this.y = y;
		rect = new Rectangle2D.Double(x, y, 20, 20);
	}
	
	public void setMovement(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) {
			movingUp = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			movingDown = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			movingLeft = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			movingRight = true;
		}
	}
	public void stopMovement(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) {
			movingUp = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			movingDown = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			movingLeft = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			movingRight = false;
		}
	}
	
	public void addVelocity() {
		
	}
	
	public void move() {
		if (movingLeft) {
			x -= speed;
		}
		if (movingRight) {
			x += speed;
		}
		if (movingUp) {
			y -= speed;
		}
		if (movingDown) {
			y += speed;
		}
	}
	
	public void update() {
		move();
		rect.setRect(x, y, 20, 20);
	}

}

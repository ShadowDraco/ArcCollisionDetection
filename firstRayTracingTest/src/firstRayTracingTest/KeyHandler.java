package firstRayTracingTest;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

	Player player;
	
	public KeyHandler(Player player) {
		this.player = player;
	}
	
	
	public void keyTyped(KeyEvent e) {	}


	public void keyPressed(KeyEvent e) {
		player.setMovement(e);
	}

	public void keyReleased(KeyEvent e) {
		player.stopMovement(e);
	}

}

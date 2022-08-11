package firstRayTracingTest;

import java.util.ArrayList;

public class GameManager {
	
	GraphicsHandler graphics;
	Window window;
	
	ArrayList<Level> levels = new ArrayList<Level>();
	
	public GameManager() {
		
		levels.add(new Level());
		
		// A JPanel that has paint competent
		graphics = new GraphicsHandler(levels.get(0));
		
		// game window, and give it the keyListener
		window = new Window(this, graphics);
		window.addKeyListener(levels.get(0).playerKeys);
		window.setVisible(true);
	}


	public void update() {
		levels.get(0).update();
		graphics.repaint();
	}
}

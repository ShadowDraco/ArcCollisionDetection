package firstRayTracingTest;

import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

public class CollisionHandler {

	Level level;
	Rectangle2D playerRect;

	public CollisionHandler(Level level) {
		this.level = level;
	}

	public void checkNinjas(Level level) {
		for (int i = 0; i < level.ninjas.size(); i++) {
			Ninja ninja = level.ninjas.get(i);
			playerRect = level.player.rect;

			// Check collision
			if (playerRect.getBounds2D().intersects(ninja.visionArc.getBounds2D())) {
				// Create an area of the object for greater precision
				Area area = new Area(playerRect);
				area.intersect(new Area(ninja.visionArc));
				// After checking if the area intersects a second time make the NPC "See" the player
				if (!area.isEmpty()) {
					ninja.seesPlayer = true;
				}
				else {
					ninja.seesPlayer = false;
				}
			}
		}
	}
	
	public void checkSnipers(Level level) {
		for (int i = 0; i < level.snipers.size(); i++) {
			Sniper sniper = level.snipers.get(i);
			playerRect = level.player.rect;

			// Check collision
			if (playerRect.getBounds2D().intersects(sniper.visionArc.getBounds2D())) {
				
				Area area = new Area(playerRect);
				area.intersect(new Area(sniper.visionArc));
				
				if (!area.isEmpty()) {
					sniper.seesPlayer = true;
				
				}
				else {
					sniper.seesPlayer = false;
				}
			} 
		}
	}

	public void checkShotgunners(Level level) {
		for (int i = 0; i < level.snipers.size(); i++) {
			Sniper sniper = level.snipers.get(i);
			playerRect = level.player.rect;

			// Check collision
			if (playerRect.getBounds2D().intersects(sniper.visionArc.getBounds2D())) {
				
				Area area = new Area(playerRect);
				area.intersect(new Area(sniper.visionArc));
				
				if (!area.isEmpty()) {
					sniper.seesPlayer = true;
				}
				else {
					sniper.seesPlayer = false;
				}
			}
		}
	}

	// check for collisions
	public void check(Level level) {

		checkNinjas(level);
		checkSnipers(level);
		checkShotgunners(level);
	}
}

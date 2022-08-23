package firstRayTracingTest;

import java.awt.geom.Line2D;
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
			ninja.seesPlayer = false;
			playerRect = level.player.rect;

			// Check collision
			for (Line2D ray : ninja.rays) {
				if (playerRect.getBounds2D().intersectsLine(ray)) {
					ninja.seesPlayer = true;
				}
			}
		}
	}

	public void checkSnipers(Level level) {
		for (int i = 0; i < level.snipers.size(); i++) {
			Sniper sniper = level.snipers.get(i);
			sniper.seesPlayer = false;
			playerRect = level.player.rect;

			// Check collision
			for (Line2D ray : sniper.rays) {
				if (playerRect.getBounds2D().intersectsLine(ray)) {
					sniper.seesPlayer = true;
				}
			}
		}
	}

	public void checkShotgunners(Level level) {
		for (int i = 0; i < level.shotgunners.size(); i++) {
			Shotgunner shotgunner = level.shotgunners.get(i);
			playerRect = level.player.rect;
			shotgunner.seesPlayer = false;
			// Check collision
			for (Line2D ray : shotgunner.rays) {
				if (playerRect.getBounds2D().intersectsLine(ray)) {
					shotgunner.seesPlayer = true;
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

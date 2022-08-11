package firstRayTracingTest;

import java.util.ArrayList;

public class Level {
	
	Player player;
	KeyHandler playerKeys;
	
	ArrayList<Ninja> ninjas = new ArrayList<Ninja>();
	ArrayList<Sniper> snipers = new ArrayList<Sniper>();
	ArrayList<Shotgunner> shotgunners = new ArrayList<Shotgunner>();
	
	CollisionHandler collisions;
	
	public Level() {
		
		player = new Player(100, 100);
		playerKeys = new KeyHandler(player);
		
		ninjas.add(new Ninja(180, 180, 0));
		snipers.add(new Sniper(250, 200, 50));
		shotgunners.add(new Shotgunner(300, 80, 100));
		
		collisions = new CollisionHandler(this);
		
	}
	
	public void updateNpcList() {
		for (int i = 0; i < ninjas.size(); i++) {
			ninjas.get(i).update();
		}
		for (int i = 0; i < snipers.size(); i++) {
			snipers.get(i).update();
		}
		for (int i = 0; i < shotgunners.size(); i++) {
			shotgunners.get(i).update();
		}
	}
	
	public void update() {
		player.update();
		
		updateNpcList();
		
		collisions.check(this);
	}
}

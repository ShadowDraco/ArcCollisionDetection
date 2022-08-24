package firstRayTracingTest;

public class Shotgunner extends NPC {
	
	static double rotateSpeed = 0.2; 
	static int visionDistance = 200;
	static int visionMultiplier = 5;
	static double speed = 0.56;
	
	public Shotgunner(double x, double y, double startAngle) {
		
		super(x, y, startAngle, rotateSpeed, visionDistance, visionMultiplier, speed);
		
	}
	
	
}

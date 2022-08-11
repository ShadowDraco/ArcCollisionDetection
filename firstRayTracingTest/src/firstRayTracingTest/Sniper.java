package firstRayTracingTest;

public class Sniper extends NPC {
	
	static double rotateSpeed = 0.3; 
	static int visionDistance = 300;
	static int visionMultiplier = 1;
	
	public Sniper(double x, double y, double startAngle) {
		
		super(x, y, startAngle, rotateSpeed, visionDistance, visionMultiplier);
		
	}
	
	
}

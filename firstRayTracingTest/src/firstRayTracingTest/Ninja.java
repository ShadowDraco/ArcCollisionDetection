package firstRayTracingTest;

public class Ninja extends NPC {
	
	static double rotateSpeed = 0.7; 
	static int visionDistance = 100;
	static int visionMultiplier = 10;
	
	public Ninja(double x, double y, double startAngle) {
		
		super(x, y, startAngle, rotateSpeed, visionDistance, visionMultiplier);
		
	}
	
	
}

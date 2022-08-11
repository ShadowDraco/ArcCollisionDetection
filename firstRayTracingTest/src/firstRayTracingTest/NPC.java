package firstRayTracingTest;

import java.awt.Color;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;

import java.awt.geom.Rectangle2D;

public class NPC {

	double startAngle, angle, rotateSpeed;
	int rotateDirection = 1;

	double x, y, cx, cy, w, h;
	double halfWidth, halfHeight;
	Ellipse2D ellipse;
	Rectangle2D rect;
	Arc2D visionArc;
	
	boolean seesPlayer = false;
	Color outlineColor;

	// Vision Distance is the range, Multiplier is the width
	int visionDistance;
	int visionMultiplier;
	double visionAngle; // A simple formula calculating from the distance and the multiplier

	public NPC(double x, double y, double startAngle) {
		this.x = x;
		this.y = y;
		w = 20;
		h = 20;

		this.startAngle = startAngle;
		angle = startAngle;

		rect = new Rectangle2D.Double(x, y, w, h);
		ellipse = new Ellipse2D.Double();
		visionArc = new Arc2D.Double();

		visionAngle = visionDistance / 60 + visionMultiplier * 10;

	}

	public NPC(double x, double y, double startAngle, double rotateSpeed, int visionDistance, int visionMultiplier) {
		this.x = x;
		this.y = y;
		w = 20;
		h = 20;

		this.rotateSpeed = rotateSpeed;
		this.startAngle = startAngle;
		angle = startAngle;

		rect = new Rectangle2D.Double(x, y, w, h);
		ellipse = new Ellipse2D.Double();
		visionArc = new Arc2D.Double();

		this.visionDistance = visionDistance;
		this.visionMultiplier = visionMultiplier;
		visionAngle = visionDistance / 60 + visionMultiplier * 10;
	}

	public void rotate() {
		// If the angle is more or less than the start position change directions
		if (angle > startAngle + 90 || angle < startAngle - 90) {
			rotateDirection = -rotateDirection;
		}

		// Add and subtract from the angle
		if (rotateDirection == 1) {
			angle += rotateSpeed;
		} else {
			angle -= rotateSpeed;
		}
	}

	public void setPosition() {

		rotate();

		// Set values used in collisions, math, and drawing
		x = rect.getX();
		y = rect.getY();
		cx = rect.getCenterX();
		cy = rect.getCenterY();
		halfWidth = rect.getWidth() / 2;
		halfHeight = rect.getHeight() / 2;

		// Update the shapes used in the npc
		rect.setRect(x, y, w, h);
		ellipse.setFrame(rect);
		visionArc.setArcByCenter(cx, cy, visionDistance, visionAngle, visionAngle * 2, Arc2D.PIE);
	}

	public void update() {
		setPosition();
		
		if (seesPlayer) {
			outlineColor = Color.red;
		} else {
			outlineColor = Color.DARK_GRAY;
		}
	}

}

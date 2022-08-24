package firstRayTracingTest;

import java.awt.Color;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class NPC {

	double startAngle, angle, rotateSpeed, angleX, angleY, speed;
	int rotateDirection = 1;

	double x, y, cx, cy, w, h;
	double halfWidth, halfHeight;
	Ellipse2D ellipse;
	Rectangle2D rect;
	Line2D[] rays;
	
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

		visionAngle = (visionDistance / 60 + visionMultiplier * 10);

	}

	public NPC(double x, double y, double startAngle, double rotateSpeed, int visionDistance, int visionMultiplier, double speed) {
		this.x = x;
		this.y = y;
		w = 20;
		h = 20;

		this.speed = speed;
		this.rotateSpeed = rotateSpeed;
		this.startAngle = startAngle;
		angle = startAngle;

		rect = new Rectangle2D.Double(x, y, w, h);
		ellipse = new Ellipse2D.Double();

		this.visionDistance = visionDistance;
		this.visionMultiplier = visionMultiplier;
		visionAngle = visionDistance / 60 + visionMultiplier * 10;
		rays = new Line2D[(int) (visionAngle * 2)];
		for (int i = 0; i < rays.length; i++) {
			rays[i] = new Line2D.Double();
		}
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
	
	public void setRays() {
		for (int i = 0; i < rays.length; i++) {
			double rayStartAngleX = Math.sin(Math.toRadians((startAngle - angle) + i));
			double rayStartAngleY = Math.cos(Math.toRadians((startAngle - angle) + i));
			rays[i].setLine(cx, cy, cx + visionDistance * rayStartAngleX, cy + visionDistance * rayStartAngleY);
		}
	}

	public void rotateToPlayer(Player player) {
		double theta = Math.atan2(player.y - y, player.x - x);
		angle = startAngle + theta;
	}

	public void followPlayer(Player player) {
		if (x < player.x) {
			x+=speed;
		}
		else {
			x-=speed;	
		}
		if (y < player.y) {
			y+=speed;
		}
		else {
			y-=speed;	
		}
	}

	public void setPosition() {	
		angleX = Math.sin(Math.toRadians(angle));
		angleY = Math.cos(Math.toRadians(angle));

		// Set values used in collisions, math, and drawing
		cx = rect.getCenterX();
		cy = rect.getCenterY();
		halfWidth = rect.getWidth() / 2;
		halfHeight = rect.getHeight() / 2;

		// Update the shapes used in the npc
		rect.setRect(x, y, w, h);
		ellipse.setFrame(rect);
		setRays();
	}

	public void update(Player player) {
		setPosition();
		
		if (seesPlayer) {
			outlineColor = Color.red;
			followPlayer(player);
			//rotateToPlayer(player);
		} else {
			outlineColor = Color.DARK_GRAY;
			rotate();
		}
		
	}

}

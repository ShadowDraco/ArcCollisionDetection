package firstRayTracingTest;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;

public class GraphicsHandler extends JPanel {

	private static final long serialVersionUID = 1L;

	Level level;

	public GraphicsHandler(Level level) {
		this.level = level;
	}

	public void drawPlayer(Graphics2D g2, AffineTransform old) {
		g2.setColor(Color.GREEN);
		g2.fill(level.player.rect);

		g2.setTransform(old);
	}

	public void drawNPC(NPC npc, Graphics2D g2, AffineTransform old) {

		// translate to the position of the npc and rotate
		AffineTransform npcTransform = AffineTransform.getRotateInstance(Math.toRadians(npc.angle), npc.x, npc.y);
		// Translate back a few units to keep the npc rotating about its own center
		// point
		npcTransform.translate(-npc.halfWidth, -npc.halfHeight);
		g2.setTransform(npcTransform);
		
		// g2.draw(npc.rect); //<-- show bounding box if you want
		g2.setColor(npc.outlineColor);
		g2.draw(npc.visionArc);
		
		g2.setColor(Color.BLACK);
		g2.draw(npc.ellipse);

		g2.setTransform(old);
	}
	
	public void drawNpcList(Graphics2D g2, AffineTransform old) {
		for (int i = 0; i < level.ninjas.size(); i++) {

			drawNPC(level.ninjas.get(i), g2, old);
		}
		for (int i = 0; i < level.snipers.size(); i++) {

			drawNPC(level.snipers.get(i), g2, old);
		}
		for (int i = 0; i < level.shotgunners.size(); i++) {

			drawNPC(level.shotgunners.get(i), g2, old);
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHints(rh);
		// The reset point for all transforms
		AffineTransform old = new AffineTransform(g2.getTransform());

		drawPlayer(g2, old);
		// Loops through all Npc's and draws them
		drawNpcList(g2, old);
		

	}
}

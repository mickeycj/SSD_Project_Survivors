package game;

import java.util.ArrayList;

import base.AbstractUnit;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Enemy extends AbstractUnit {

	// TODO Additional attributes (if any)
	private PVector destination;
	
	public Enemy(float x, float y, PApplet display, int level, PImage image) {
		super(x, y, level*3.5f, display, image);
		super.level = level;
		setDestination();
	}
	
	public void setDestination() {
		destination = new PVector((int)(Math.random()*display.width), (int)(Math.random()*display.height));
	}
	
	@Override
	public void update() {
		// TODO Implement random A.I. for movements
		PVector newVelocity = new PVector(destination.x - position.x, destination.y - position.y);
		newVelocity.setMag(level);
		velocity.lerp(newVelocity, .2f);
		super.update();
	}	
}
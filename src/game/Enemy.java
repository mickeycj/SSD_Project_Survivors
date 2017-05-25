package game;

import java.util.ArrayList;

import base.AbstractUnit;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Enemy extends AbstractUnit {

	// TODO Additional attributes (if any)
	private PVector destination;
	private PImage image;
	
	public Enemy(float x, float y, PApplet display, int level, PImage image) {
		super(x, y, level*3.5f, display);
		super.level = level;
		this.image = image;
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
	
	@Override
	public void render() {
		// TODO Render desired image
		display.image(image, position.x, position.y);
		
		// Temporary rendering implementation for testing purposes
		display.fill(255, 0, 0);
		super.render();
	}
	
	
}
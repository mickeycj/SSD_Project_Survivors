package game;

import base.AbstractUnit;
import processing.core.PApplet;
import processing.core.PVector;

public class Enemy extends AbstractUnit {

	// TODO Additional attributes (if any)
	private PVector destination;
	
	public Enemy(float x, float y, float r, PApplet display) {
		super(x, y, r, display);
	}
	
	public void setDestination() {
		destination = new PVector((int)(Math.random()*300), (int)(Math.random()*300));
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
		
		// Temporary rendering implementation for testing purposes
		display.fill(255, 0, 0);
		super.render();
	}
}

package game;

import base.AbstractUnit;
import processing.core.PApplet;
import processing.core.PVector;

public class Enemy extends AbstractUnit {

	// TODO Additional attributes (if any)
	
	
	public Enemy(float x, float y, float r, PApplet display) {
		super(x, y, r, display);
	}
	
	@Override
	public void update() {
		// TODO Implement random A.I. for movements
		PVector newVelocity = new PVector((int)(Math.random()*300) - position.x, (int)(Math.random()*300) - position.y);
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

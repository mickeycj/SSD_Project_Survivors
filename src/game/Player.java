package game;

import base.AbstractUnit;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Player extends AbstractUnit {

	// TODO Additional attributes (if any)
	
	public Player(int level, float r, PApplet display) {
		super(1, display.width / 2, display.height / 2, r, display);
	}
	
	@Override
	public void update() {
		// TODO Implement player movement according to mouse input
		PVector newVector = new PVector();
		newVector.setMag(1);
		velocity.lerp(newVector, .5f);
		super.update();
	}
	
	@Override
	public void render() {
		// TODO Render desired image
		
		// Temporary rendering implementation for testing purposes
		display.fill(255);
		super.render();
	}
}

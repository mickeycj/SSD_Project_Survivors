package game;

import base.AbstractUnit;
import processing.core.PApplet;

public class Player extends AbstractUnit {

	// TODO Additional attributes (if any)
	
	
	public Player(float r, PApplet display) {
		super(/* TODO Starting x-position */ 0, /* TODO Starting y-position */ 0, r, display);
	}
	
	@Override
	public void update() {
		// TODO Implement player movement according to mouse input
		
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

package game;

import base.AbstractUnit;
import processing.core.PApplet;

public class Enemy extends AbstractUnit {

	// TODO Additional attributes (if any)
	
	
	public Enemy(float x, float y, float r, PApplet display) {
		super(x, y, r, display);
	}
	
	@Override
	public void update() {
		// TODO Implement random A.I. for movements
		
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

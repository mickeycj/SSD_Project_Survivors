package game;

import base.AbstractUnit;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Enemy extends AbstractUnit {

	private PVector destination;
	
	public Enemy(PApplet pApplet, PImage image) {
		super(0, 0, 0, 0, pApplet, image);
		this.setDestination();
	}

	public void setDestination() {
		destination = new PVector((int)(Math.random() * pApplet.width), (int)(Math.random() * pApplet.height));
	}
	
	public void setRadiusAndSize(int lvl) {
		radius = 15 + (lvl - 1) * 7.5f;
		level = lvl;
		switch (level) {
			case 1 :
				color = 0xFFE5E19C;
				break;
			case 2 :
				color = 0xFF9BB37E;
				break;
			case 3 :
				color = 0xFF85ADAF;
				break;
			case 4 :
				color = 0xFFB28077;
				break;
			case 5 :
				color = 0xFF9B87AA;
				break;
			default :
		}
	}
	
	@Override
	public void reset() {
		super.reset();
		setDestination();
	}

	@Override
	public void update() {
		if (Math.abs(destination.x - position.x) < 1 && Math.abs(destination.y - position.y) < 1) {
			setDestination();
		}
		PVector newVector = new PVector(destination.x - position.x, destination.y - position.y);
		newVector.setMag(level);
		velocity.lerp(newVector, .2f);
		super.update();
	}
	
	@Override
	public void render() {
		pApplet.noFill();
		super.render();
	}
}
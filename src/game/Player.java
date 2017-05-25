package game;

import base.AbstractUnit;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Player extends AbstractUnit {

	private boolean alive;
	
	public Player(PApplet pApplet, PImage image) {
		super(pApplet.width / 2, pApplet.height / 2 + 61.5f, 16, 1, pApplet, image);
		this.alive = true;
	}
	
	public void levelUp() {
		if (level < 3) {
			level++;
			if (level == 1) {
				color = 0xFFE5E19C;
			} else if (level == 2) {
				color = 0xFF9BB37E;
			} else if (level == 3) {
				color = 0xFF85ADAF;
			}
		}
	}
	
	public void die() {
		alive = false;
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	@Override
	public void reset() {
		super.reset();
		alive = true;
	}
	
	@Override
	public void update() {
		PVector newVector = new PVector(pApplet.mouseX - position.x, pApplet.mouseY - position.y);
		newVector.setMag(3);
		velocity.lerp(newVector, .5f);
		super.update();
	}
	@Override
	public void render() {
		pApplet.fill(color);
		super.render();
	}
}
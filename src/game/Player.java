package game;

import java.awt.Color;

import base.AbstractUnit;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Player extends AbstractUnit {

	// TODO Additional attributes (if any)
	private boolean alive;

	public Player(PApplet display, PImage image) {
		super(display.width / 2, display.height / 2, 16, 1, display, image);
		alive = true;
	}

	@Override
	public void update() {
		// TODO Implement player movement according to mouse input
		PVector newVector = new PVector(display.mouseX - position.x, display.mouseY - position.y);
		newVector.setMag(3);
		velocity.lerp(newVector, .5f);
		super.update();
	}

	public void levelUp() {
		level++;
		if (this.level == 1) {
			this.color = 0xFFE5E19C;
		} else if (this.level == 2) {
			this.color = 0xFF9BB37E;
		} else if (this.level == 3) {
			this.color = 0xFF85ADAF;
		}
	}

	public void die() {
		alive = false;
	}

	public boolean isAlive() {
		return alive;
	}

	public void reset() {
		alive = true;
		level = 1;
		radius = 16;
		velocity = new PVector();
		position = new PVector(display.width / 2, display.height / 2);
	}
	
	@Override
	public void render() {
		display.stroke(color);
		display.fill(color);
		display.ellipse(position.x, position.y, radius * 2.5f, radius * 2.5f);
		super.render();
	}
}
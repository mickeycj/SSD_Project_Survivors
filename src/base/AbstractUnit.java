package base;

import java.awt.Color;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public abstract class AbstractUnit implements Unit {

	protected PApplet display;

	protected PVector position;
	protected PVector velocity;
	protected PImage image;

	protected float radius;
	protected int level;
	protected int color;

	protected AbstractUnit(float x, float y, float r, int l, PApplet display, PImage image) {
		this.display = display;
		this.position = new PVector(x, y);
		this.velocity = new PVector();
		this.radius = r;
		this.level = l;
		if (this.level == 1) {
			this.color = 0xFFE5E19C;
		} else if (this.level == 2) {
			this.color = 0xFF9BB37E;
		} else if (this.level == 3) {
			this.color = 0xFF85ADAF;
		} else if (this.level == 4) {
			this.color = 0xFFB28077;
		} else if (this.level == 5) {
			this.color = 0xFF9B87AA;
		}
		this.image = image;
	}

	@Override
	public PVector getPosition() {
		return position;
	}

	@Override
	public float getRadius() {
		return radius;
	}

	@Override
	public int getLevel() {
		return level;
	}

	@Override
	public boolean eat(Unit other) {
		float dist = PVector.dist(position, other.getPosition());
		if (dist < radius * .8f + other.getRadius() && radius > other.getRadius()) {
			radius += .05f * other.getRadius();
			return true;
		}
		return false;
	}

	@Override
	public void update() {
		position.add(velocity);
		if (position.y <= 123 + radius) {
			position.y = 123 + radius;
		} else if (position.y > display.height - radius) {
			position.y = display.height - radius;
		} else if (position.x < 0 + radius) {
			position.x = radius;
		} else if (position.x > display.width - radius) {
			position.x = display.width - radius;
		}
	}

	@Override
	public void render() {
		display.strokeWeight(1.5f);
		display.image(image, position.x, position.y, radius * 2, radius * 2);
	}
}
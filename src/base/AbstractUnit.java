package base;

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
	
	protected AbstractUnit(float x, float y, float r, int l, PApplet display, PImage image) {
        this.display = display;
        this.position = new PVector(x, y);
        this.velocity = new PVector();
        this.radius = r;
        this.level = l;
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
	}
	
	@Override
	public void render() {
		display.image(image, position.x, position.y, radius * 2, radius * 2);
	}
}
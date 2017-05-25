package base;

import processing.core.PApplet;
import processing.core.PVector;

public abstract class AbstractUnit implements Unit {

	protected PApplet display;
	
	protected PVector position;
	protected PVector velocity;
	
	protected float radius;
	protected int level;
	
	protected AbstractUnit(float x, float y, float r, PApplet display) {
		this.display = display;
		this.position = new PVector(x, y);
		this.velocity = new PVector();
		this.radius = r;
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
			radius += .15f * other.getRadius();
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
		display.ellipse(position.x, position.y, radius * 2, radius * 2);
	}
}
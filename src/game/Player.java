package game;

import base.AbstractUnit;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Player extends AbstractUnit {

	// TODO Additional attributes (if any)
	private boolean alivePlayer;
	private int eatCount;
	
	public Player(PApplet display, PImage image) {
		super(display.width/2, display.height/2, 16, display, image);
		level = 1;
		alivePlayer = true;
		eatCount = 0;
	}
	
	@Override
	public void update() {
		// TODO Implement player movement according to mouse input
		PVector newVector = new PVector(display.mouseX - position.x, display.mouseY - position.y);
		newVector.setMag(3);
		velocity.lerp(newVector, .5f);
		super.update();
	}
	
	public void setAlivePlayer(boolean b) {
		alivePlayer = b;
	}
	
	public boolean getAlivePlayer() {
		return alivePlayer;
	}
  
	public void setEatCount() {
		eatCount++;
		if(eatCount >= 10 && level < 3) {
			level++;
			eatCount = 0;
			System.out.println(level);
		}
	}
	
	public void reset() {
		alivePlayer = true;
		eatCount = 0;
		level = 1;
		radius = 16;
		velocity = new PVector();
		position = new PVector(display.width/2, display.height/2);
	}
}
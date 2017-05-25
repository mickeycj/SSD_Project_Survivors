package game;

import base.AbstractUnit;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Player extends AbstractUnit {

	// TODO Additional attributes (if any)
	private boolean alivePlayer;
	
	public Player(PApplet display, PImage image) {
        super(display.width/2, display.height/2, 16, 1, display, image);
        alivePlayer = true;
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
    }
	
	public void setAlivePlayer(boolean b) {
		alivePlayer = b;
	}
	
	public boolean getAlivePlayer() {
		return alivePlayer;
	}
	
	public void reset() {
		alivePlayer = true;
		level = 1;
		radius = 16;
		velocity = new PVector();
		position = new PVector(display.width/2, display.height/2);
	}
}
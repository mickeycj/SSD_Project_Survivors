package game;

import java.awt.Color;

import base.AbstractUnit;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Player extends AbstractUnit {

	// TODO Additional attributes (if any)
	private boolean alivePlayer;
	private PImage image;
	private int eatCount;
	
	public Player(PApplet display, PImage image) {
		super(display.width/2, display.height/2, 16, 1, display, image);
		level = 1;
		alivePlayer = true;
		this.image = image;
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
	
	public void levelUp() {
        level++;
        if (level == 1) {
            color = Color.YELLOW.getRGB();
        } else if (level == 2) {
            color = Color.CYAN.getRGB();
        } else if (level == 3) {
            color = Color.PINK.getRGB();
        }
    }
	
	public void setAlivePlayer(boolean b) {
		alivePlayer = b;
	}
	
	public boolean getAlivePlayer() {
		return alivePlayer;
	}
  
	public void setEatCount() {
		eatCount++;
		if(eatCount >= 10) {
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
	
	@Override
	public void render() {
		// TODO Render desired image
		display.image(image, position.x, position.y);

		// Temporary rendering implementation for testing purposes
		display.fill(255);
		super.render();
	}
}
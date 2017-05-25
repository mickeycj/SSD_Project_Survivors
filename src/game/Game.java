package game;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Game {

	private final PApplet pApplet;
	
	private final World world;
	
	private boolean started;
	
	public Game(PApplet pApplet, ArrayList<PImage> images) {
		this.pApplet = pApplet;
		this.world = new World(pApplet, images);
	}
	
	public boolean isStarted() {
		return started;
	}
	
	public boolean isEnded() {
		return !world.isPlayerAlive();
	}
	
	public void showStats() {
		if (!isEnded()) {
			pApplet.fill(0xFFFFFFFF);
			pApplet.textSize(27);
			pApplet.text(world.getPlayerLevel(), 275, 44);
			pApplet.textSize(23);
			pApplet.text(world.getPlayerScore(), 251, 74);
			pApplet.text(world.getHighScore(), 313, 102);
		} else {
			pApplet.fill(0xFF666666);
			pApplet.textSize(35);
			pApplet.text(world.getPlayerScore(), 805, 378);
			pApplet.text(world.getHighScore(), 896, 415);
		}
	}
	
	public void start() {
		started = true;
	}
	
    public void restart() {
        world.reset();
    }
    
	public void update() {
		world.update();
		world.render();
		if (world.isNumEnemiesTooLow() && pApplet.frameCount % 300 == 0) {
	         world.addRandomEnemy();
        }
    }
}

package game;

import java.util.ArrayList;

import processing.core.*;

public class Game {

	private final PApplet pApplet;
	
	private World world;
	
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

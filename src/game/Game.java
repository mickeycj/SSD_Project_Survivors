package game;

import java.util.ArrayList;

import processing.core.*;

public class Game {

	// TODO Game's attributes
	private PApplet pApplet;
	private World world;
	
	// TODO Create an appropriate Game constructor
	public Game(PApplet pApplet, ArrayList<PImage> images) {
		this.pApplet = pApplet;;
		world = new World(pApplet, images);
	}
	
	// TODO Update Game's state(s)
	public boolean isEnd() {
		return !world.isPlayerAlive();
	}
	
	public void update() {
		world.update();
		world.render();
		if(pApplet.frameCount % 600 == 0) {
			world.addEnemy();
		}
	}
	
	public void restart() {
		world.restart();
	}
}

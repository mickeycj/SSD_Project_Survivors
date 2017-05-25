package game;

import processing.core.PApplet;

public class Game {

	// TODO Game's attributes
	private PApplet pApplet;
	private World world;
	
	// TODO Create an appropriate Game constructor
	public Game(PApplet pApplet) {
		this. pApplet = pApplet;
		world = new World(pApplet);
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

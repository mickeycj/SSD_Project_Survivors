package game;

import java.util.ArrayList;

import processing.core.*;

public class Game {

	// TODO Game's attributes
	private PApplet pApplet;
	private ArrayList<PImage> images;
	private World world;
	
	// TODO Create an appropriate Game constructor
	public Game(PApplet pApplet) {
		this.pApplet = pApplet;
		images = new ArrayList<PImage>();
		world = new World(pApplet, images);
	}
	
	// TODO Update Game's state(s)
	public boolean isEnd() {
		return world.isPlayerAlive();
	}
	
	public void restart() {
		world.restart();
	}
}
package game;

import java.util.ArrayList;

import base.Component;
import processing.core.PApplet;

public class World implements Component {

	// TODO World's attributes
	private PApplet pApplet;
	
	private Player player;
	private ArrayList<Enemy> enemies;
	
	// TODO Create an appropriate World constructor
	public World(PApplet pApplet) {
		this.pApplet = pApplet;
		this.player = player;
		this.enemies = new ArrayList<>();
		for (int i = 0; i < player.getLevel()*10; i++) {
			this.enemies.add( new Enemy( (float)Math.random()*pApplet.width, (float)Math.random()*pApplet.height, (float)Math.random()*(player.getLevel()+2), pApplet ) );
		}
	}
	
	// TODO Methods for controlling each 'components/units' within the world
	public boolean isPlayerWon() {
		return false;
	}
	
	public boolean tooLowNumEnemies() {
		return enemies.size() < player.getLevel()*10; 
	}
	
	public void addEnemy() {
		enemies.add( new Enemy( (float)Math.random()*pApplet.width, (float)Math.random()*pApplet.height, (float)Math.random()*(player.getLevel()+2), pApplet ));
	}
	
	@Override
	public void render() {
		// TODO Render everything on this world
		
	}
}
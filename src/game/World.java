package game;

import java.util.ArrayList;

import base.Component;
import processing.core.PApplet;

public class World implements Component {

	// TODO World's attributes
	private PApplet pApplet;
	
	private Player player;
	private ArrayList<Enemy> enemies;
	private ArrayList<Enemy> eatenEnemies;
	
	// TODO Create an appropriate World constructor
	public World(PApplet pApplet) {
		this.pApplet = pApplet;
		this.player = new Player(pApplet);
		this.enemies = new ArrayList<>();
		for (int i = 0; i < player.getLevel()*10; i++) {
			this.enemies.add( new Enemy( (float)Math.random()*pApplet.width, (float)Math.random()*pApplet.height, (float)Math.random()*(player.getLevel()+2), pApplet ) );
		}
	}
	
	// TODO Methods for controlling each 'components/units' within the world
	public boolean isPlayerAlive() {
		return player.getAlivePlayer();
	}
	
	public boolean tooLowNumEnemies() {
		return enemies.size() < player.getLevel()*10; 
	}
	
	public void addEnemy() {
		enemies.add( new Enemy( (float)Math.random()*pApplet.width, (float)Math.random()*pApplet.height, (float)Math.random()*(player.getLevel()+2), pApplet ));
	}
	
	public void update() {
		for(int i=0; i<enemies.size(); i++) {
			Enemy enemy = enemies.get(i);
			if(player.eat(enemy)) {
				eatenEnemies.add(enemy);
			}
			else {
				if(enemy.eat(player)) {
					player.setAlivePlayer(false);
				}
				enemy.setDestination();
				enemy.update();
			}
		}
		enemies.removeAll(eatenEnemies);
		eatenEnemies.clear();
		player.update();
	}
	
	public void restart() {
		player.reset();
		this.enemies.clear();
		for (int i = 0; i < player.getLevel()*10; i++) {
			this.enemies.add( new Enemy( (float)Math.random()*pApplet.width, (float)Math.random()*pApplet.height, (float)Math.random()*(player.getLevel()+2), pApplet ) );
		}
	}
	
	@Override
	public void render() {
		// TODO Render everything on this world
		player.render();
		for (Enemy e : enemies) {
			e.render();
		}
	}
}
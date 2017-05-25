package game;

import java.util.ArrayList;

import base.Component;
import processing.core.PApplet;

public class World implements Component {

	// TODO World's attributes
	private PApplet pApplet;
	
	private Player player;
	private ArrayList<Enemy> enemies;
	private final int[] enemiesLimit = { 5, 4, 3, 2, 1};
	private final int[] enemiesCount;
	private ArrayList<Enemy> eatenEnemies;
	
	// TODO Create an appropriate World constructor
	public World(PApplet pApplet) {
		this.pApplet = pApplet;
		this.player = new Player(pApplet);
		this.enemies = new ArrayList<>();
		this.enemiesCount = new int[5];
		this.eatenEnemies = new ArrayList<>();
		
		int level = 1;
		for (int i = 0; i < player.getLevel()*12; i++) {
			if(enemiesCount[level - 1] == enemiesLimit[level - 1]) {
				level++;
			}
			this.enemies.add( new Enemy( (float)Math.random()*pApplet.width, (float)Math.random()*pApplet.height, pApplet , level) );
			enemiesCount[level-1]++;
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
		if(enemies.size() < player.getLevel()*10) {
			for (int i = 1; i <= player.getLevel()+2; i++) {
				if(enemiesCount[i - 1] != enemiesLimit[i - 1]) {
					this.enemies.add( new Enemy( (float)Math.random()*pApplet.width, (float)Math.random()*pApplet.height, pApplet , i) );
					enemiesCount[i-1]++;
				}
				
			}
		}
	}
	
	public void update() {
		for(int i=0; i<enemies.size(); i++) {
			Enemy enemy = enemies.get(i);
			if(player.eat(enemy)) {
				eatenEnemies.add(enemy);
				player.setEatCount();
				enemiesCount[enemy.getLevel()-1]--;
			}
			else {
				if(enemy.eat(player)) {
					player.setAlivePlayer(false);
				}
				if((pApplet.frameCount + i*100) %120 == 0) {
					enemy.setDestination();
				}
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
			this.enemies.add( new Enemy( (float)Math.random()*pApplet.width, (float)Math.random()*pApplet.height, pApplet , 1) );
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

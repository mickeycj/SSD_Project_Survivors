package game;

import java.util.ArrayList;

import base.Component;
import processing.core.*;

public class World implements Component {

	// TODO World's attributes
	private PApplet pApplet;

	private Player player;
	private ArrayList<Enemy> enemies;
	private ArrayList<Enemy> eatenEnemies;
	private ArrayList<PImage> images;
	
	private final float[] enemiesSize = {15f, 22.5f, 30f, 37.5f, 45};
	private final int[][] enemiesLimit = {{8, 5, 2, 0, 0}, {3, 5, 5, 3, 0}, {2, 3, 5, 7, 5}};
	private int[] enemiesCount;

	// TODO Create an appropriate World constructor
	public World(PApplet pApplet, ArrayList<PImage> images) {
		this.pApplet = pApplet;
		this.player = new Player(pApplet, images.get(0));
		this.images = images;
		this.enemies = new ArrayList<>();
		this.enemiesCount = new int[5];
		this.eatenEnemies = new ArrayList<>();
		int level = 1;
		for (int i = 0; i < sumLevel(1); i++) {
			if (this.enemiesCount[level - 1] == this.enemiesLimit[0][level - 1]) {
				level++;
			}
			this.enemies.add(new Enemy((float)(Math.random() * pApplet.width), (float)(Math.random() * pApplet.height), level, pApplet, images.get(randomEnemyImage(1, 19))));
			this.enemiesCount[level - 1]++;
		}
	}

	// TODO Methods for controlling each 'components/units' within the world
	public boolean isPlayerAlive() {
		return player.isAlive();
	}

	public boolean tooLowNumEnemies() {
		return enemies.size() < sumLevel(player.getLevel());
	}

	public void addEnemy() {
		for (int i = 1; i <= player.getLevel() + 2; i++) {
			if (enemiesCount[i - 1] != enemiesLimit[player.getLevel() - 1][i - 1]) {
				this.enemies.add(new Enemy((float)(Math.random() * pApplet.width), (float)(Math.random() * pApplet.height), i, pApplet, images.get(randomEnemyImage(1, 19))));
				enemiesCount[i - 1]++;
			}

		}
	}

	public void update() {
		for (int i = 0; i < enemies.size(); i++) {
			Enemy enemy = enemies.get(i);
			if (player.eat(enemy)) {
				eatenEnemies.add(enemy);
				if (player.getLevel() < 3 && player.getRadius() >= enemiesSize[player.getLevel()]) {
					player.levelUp();
				}
				enemiesCount[enemy.getLevel() - 1]--;
			} else {
				if (enemy.eat(player)) {
					player.die();
				}
				if ((pApplet.frameCount + i * 100) % 120 == 0) {
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
		enemies.clear();
		enemiesCount = new int[5];
		int level = 1;
		for (int i = 0; i < sumLevel(player.getLevel()); i++) {
			if (enemiesCount[level - 1] == enemiesLimit[0][level - 1]) {
				level++;
			}
			enemies.add(new Enemy((float)(Math.random() * pApplet.width), (float)(Math.random() * pApplet.height), level, pApplet, images.get(randomEnemyImage(1, 19))));
			enemiesCount[level - 1]++;
		}
	}

	@Override
	public void render() {
		// TODO Render everything on this world
		for (Enemy e : enemies) {
			e.render();
		}
		player.render();
	}

	private int randomEnemyImage(int max, int min) {
		int number = min + (int) (Math.random() * ((max - min) + 1));
		return number;
	}

	private int sumLevel(int level) {
		int sum = 0;
		for (int i = 0; i < enemiesLimit[level - 1].length; i++) {
			sum += enemiesLimit[level - 1][i];
		}
		return sum;
	}
}

package game;

import java.util.ArrayList;
import java.util.Random;

import base.Component;
import processing.core.PApplet;

public class World implements Component {

	// TODO World's attributes
	private PApplet display;
	private Player player;
	private ArrayList<Enemy> units;
	private ArrayList<Enemy> eaten;
	
	public static final Random random = new Random(System.currentTimeMillis());
	
	// TODO Create an appropriate World constructor
	public World (PApplet display){
		this.display = display;
		this.player = new Player(1, 16, this.display);
		this.eaten = new ArrayList<>();
		this.units = new ArrayList<>();
		for (int i = 0 ; i < 5 ; i++){
			this.units.add(randomEnemy(8, 32));
		}

	}
	
	// TODO Methods for controlling each 'components/units' within the world
	private Enemy randomEnemy(int min, int max) {
		return new Enemy(this.display.random((int)Math.random()*100), this.display.random(this.display),this.display.random(this.display.width), this.display.random(this.display.height), this.display.random(min, max), this.display);
	}
	
	@Override
	public void render() {
		// TODO Render everything on this world
		
	}
}

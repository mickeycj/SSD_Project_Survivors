import java.io.File;
import java.util.ArrayList;

import game.*;
import processing.core.PApplet;
import processing.core.PImage;

public class SurvivorsGame extends PApplet {

	private ArrayList<PImage> images;
	private PImage startScreen;
	private PImage background;
	private PImage gameOverScreen;
	
	private Game game;
	
	@Override
	public void settings() {
		size(1080, 640);
		startScreen = loadImage("images/backgrounds/start.png");
		background = loadImage("images/backgrounds/background.png");
		gameOverScreen = loadImage("images/backgrounds/over.png");
		images = new ArrayList<>();
		File directory = new File("images/faces");
		for (File file : directory.listFiles()) {
			if (file.getName().endsWith(".png")) {
				if (file.getName().equals("0.png")) {
					images.add(0, loadImage(file.getPath()));
				} else {
					images.add(loadImage(file.getPath()));
				}
			}
		}
	}
	
	@Override
	public void setup() {
		imageMode(CENTER);
		image(startScreen, width / 2, height / 2);
		game = new Game(this, images);
	}
	
	@Override
	public void draw() {
		if (game.isStarted()) {
			image(background, width / 2, height / 2);
			if (!game.isEnded()) {
				game.update();
			} else {
				image(gameOverScreen, width/2, height/2);
			}
		}
	}
	
	@Override
	public void keyPressed() {
		if (!game.isStarted()) {
			game.start();
		} else if (game.isEnded()) {
			game.restart();
		}
	}
	
	/* Main method */
	public static void main(String[] args) {
		PApplet.main("SurvivorsGame");
	}
}
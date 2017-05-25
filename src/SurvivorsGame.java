import java.io.File;
import java.util.ArrayList;

import game.*;
import processing.core.PApplet;
import processing.core.PImage;

public class SurvivorsGame extends PApplet {

	private ArrayList<PImage> images;
	private PImage loadingScreen;
	private PImage gameBackground;
	private PImage gameOverScreen;
	private Game g;

	@Override
	public void settings() {
		size(1080, 640);
		loadingScreen = loadImage("images/backgrounds/loading.png");
		gameBackground = loadImage("images/backgrounds/SurvivorBG.png");
		 gameOverScreen = loadImage("images/backgrounds/gameOver.png");
		images = new ArrayList<>();
		File file = new File("images/faces");
		for (File f : file.listFiles()) {
			if (f.getName().endsWith(".png"))
				images.add(loadImage(f.getPath()));
		}
	}

	@Override
	public void setup() {
		// TODO Initialize a new Game
		imageMode(CENTER);
		image(loadingScreen, width / 2, height / 2);
		g = new Game(this, images);
	}

	@Override
	public void draw() {
		// TODO Update the Game's state(s)
		if (g.isStarted()) {
			image(gameBackground, width / 2, height / 2);
			if (!g.isEnd()) {
				g.update();
			} else {
				// TODO restart
				image(gameOverScreen, width/2, height/2);
			}
		}
	}
	
	@Override
	public void keyPressed() {
		if (key == ' ') {
			if (!g.isStarted()) {
				g.start();
			} else if (g.isEnd()) {
				g.restart();
			}
		}
	}

	/* Main method */
	public static void main(String[] args) {
		PApplet.main("SurvivorsGame");
	}
}
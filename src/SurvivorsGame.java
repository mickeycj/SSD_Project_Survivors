import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import game.*;
import processing.core.PApplet;
import processing.core.PFont;
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
		startScreen = loadImage("res/images/backgrounds/start.png");
		background = loadImage("res/images/backgrounds/background.png");
		gameOverScreen = loadImage("res/images/backgrounds/over.png");
		images = new ArrayList<>();
		File directory = new File("res/images/faces");
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
		try {
			textFont(new PFont(Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("res/fonts/OCR")), true));
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
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
				image(gameOverScreen, width / 2, height / 2);
			}
			game.showStats();
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
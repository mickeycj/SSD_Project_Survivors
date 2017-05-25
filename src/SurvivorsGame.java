import java.io.File;
import java.util.ArrayList;

import game.*;
import processing.core.PApplet;
import processing.core.PImage;

public class SurvivorsGame extends PApplet {

	private ArrayList<PImage> images;
	private Game g;

	@Override
	public void settings() {
		size(1080, 640);
	}

	@Override
	public void setup() {
		// TODO Initialize a new Game
		imageMode(CENTER);
		images = new ArrayList<>();
		File file = new File("images");
		for (File f : file.listFiles()) {
			if (f.getName().endsWith(".png"))
				images.add(loadImage(f.getPath()));
		}
		g = new Game(this, images);
	}

	@Override
	public void draw() {
		background(128);
		// TODO Update the Game's state(s)
		if (!g.isEnd()) {
			g.update();
		} else {
			// TODO restart
		}
	}

	/* Main method */
	public static void main(String[] args) {
		PApplet.main("SurvivorsGame");
	}
}
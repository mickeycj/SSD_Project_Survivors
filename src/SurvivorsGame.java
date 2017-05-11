import game.Game;
import game.World;
import processing.core.PApplet;
import processing.core.PImage;

public class SurvivorsGame extends PApplet {

	// TODO Game object
	Game game;
	
	@Override
	public void settings() {
		size(600, 600);
	}
	
	@Override
	public void setup() {
		// TODO Initialize a new Game
	}
	
	@Override
	public void draw() {
		background(128);
		// TODO Update the Game's state(s)
		
	}
	
	/* Main method */
	public static void main(String[] args) {
		PApplet.main("SurvivorsGame");
	}
}

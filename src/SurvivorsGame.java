import game.Game;
import processing.core.PApplet;

public class SurvivorsGame extends PApplet {

	// TODO Game object
	private Game g;
	
	@Override
	public void settings() {
		size(600, 600);
	}
	
	@Override
	public void setup() {
		// TODO Initialize a new Game
		g = new Game(this);
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

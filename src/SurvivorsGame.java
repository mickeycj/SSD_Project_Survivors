import game.Game;
import game.World;
import processing.core.PApplet;
import processing.core.PImage;

public class SurvivorsGame extends PApplet {

	private Game g;
	
	@Override
	public void settings() {
		size(600, 600);
	}
	
	@Override
	public void setup() {
		g = new Game(this);
	}
	
	@Override
	public void draw() {
		background(128);
		if(!g.isEnd()) {
			g.update();
		}
		else {
			// TODO restart
		}
	}
	
	/* Main method */
	public static void main(String[] args) {
		PApplet.main("SurvivorsGame");
	}
}

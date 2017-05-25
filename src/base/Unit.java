package base;

import processing.core.PVector;

public interface Unit extends Component {

	PVector getPosition();
	
	float getRadius();
	
	int getLevel();
	
	void setPosition(float x, float y);
	
	boolean eat(Unit other);
	
	void reset();
}

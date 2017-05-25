package game;
 
import base.AbstractUnit;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;
 
public class Enemy extends AbstractUnit {
 
    // TODO Additional attributes (if any)
    private PVector destination;
   
    public Enemy(float x, float y, int level, PApplet display, PImage image) {
        super(x, y, 15 + (level - 1) * 7.5f, level, display, image);
        setDestination();
    }
   
    public void setDestination() {
        destination = new PVector((int)(Math.random()*display.width), (int)(Math.random()*display.height));
    }
   
    @Override
    public void update() {
        // TODO Implement random A.I. for movements
        if (Math.abs(destination.x - position.x) < 1 && Math.abs(destination.y - position.y) < 1) {
            setDestination();
        }
        PVector newVelocity = new PVector(destination.x - position.x, destination.y - position.y);
        newVelocity.setMag(level);
        velocity.lerp(newVelocity, .2f);
        super.update();
    }  
}
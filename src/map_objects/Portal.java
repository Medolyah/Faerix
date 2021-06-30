package map_objects;

import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Rectangle;

import de.faerix.base.GameObject;

public class Portal extends GameObject{
	private static final int gameWidth = 1500;
	private static final int  gameHeight = 900;
	
	public Ellipse shape;
	public Image outerRing, innerRing; 
	public int xPos;
	public int yPos;
	public boolean isAlive = false;
	
	private int size; 
	public Portal() throws SlickException {
		this.size = 400;
		this.innerRing = new Image("assets/map_objects/portal_inner_ring.png").getScaledCopy(size, size);
		this.outerRing = new Image("assets/map_objects/portal_outer_ring.png").getScaledCopy(size, size);
		Random random = new Random();
		this.xPos = random.nextInt(gameWidth-size); 
		this.yPos =  random.nextInt(gameHeight-200-size); 
		this.shape = new Ellipse(this.xPos, this.yPos, size/4, size/4);
	}
	
	public void render(Graphics g) {
		if(this.isAlive) {
			g.setColor(Color.black);
			g.fill(this.shape);
			g.drawImage(this.innerRing, this.xPos-size/2, this.yPos-size/2);
			g.drawImage(this.outerRing, this.xPos-size/2, this.yPos-size/2);
			this.outerRing.rotate(0.04f);
			this.innerRing.rotate(-0.05f);
		}
	}
	
	
	public void update(int delta) {
	}

}

package de.faerix.base;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Portal extends Spielobjekt{
	
	public Image img;
	public Rectangle shape; 
	public int xPos;
	public int yPos;
	public boolean isAlive;
	
	
	public Portal(int xPos, int yPos) throws SlickException {
		this.img = new Image("assets/portal.png").getScaledCopy(200,100);
		this.shape = new Rectangle(xPos, yPos, 150, 50);
	}
	
	public void render(Graphics g) {
		if(this.isAlive) {
			g.draw(this.shape);
			g.drawImage(this.img, this.xPos, this.yPos);
		}
	}

}

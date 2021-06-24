package de.faerix.base;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Shape;

import de.faerix.base.enums.StoneEnum;

public class Stone extends Spielobjekt{
	float xPos;
	float yPos;
	public StoneEnum type;
	public Shape shape; 
	
	
	public Stone(StoneEnum type, float xPos, float yPos) {
		this.type = type; 
		this.xPos = xPos;
		this.yPos = yPos;
		this.shape = new Ellipse(this.xPos, this.yPos, 10, 10);
	}
	
	public void render(Graphics g) {
		g.fill(this.shape);
	}
	
	public void update() {
		
	}

}

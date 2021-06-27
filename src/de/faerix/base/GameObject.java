package de.faerix.base;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;

public abstract class GameObject
{
	Shape shape;
	// Variablen/Methoden werden ausgelagert sobald notwendig. 
	public void update( int delta) {
		
	}
	
	public void render(Graphics g) {
		g.fill(shape);
	}

}

package de.faerix.base;

import java.util.ArrayDeque;
import java.util.Deque;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Shape;

import de.faerix.base.enums.StoneEnum;
import de.faerix.base.faerie.Faerie;

public class Interface extends Spielobjekt{
	
	public Interface() {

	}
	
	


	public void checkInput(Input input, GameContainer container, Faerie faerie,  Deque<Stone> interactableObjs) {
		if (input.isKeyPressed(Input.KEY_ESCAPE)) {
			container.exit();
		} else if (input.isKeyDown(Input.KEY_UP)) {
			faerie.moveY(-1);
		} else if (input.isKeyDown(Input.KEY_DOWN)) {
			faerie.moveY(1);
		} else if (input.isKeyDown(Input.KEY_RIGHT)) {
			faerie.moveX(+1);
		} else if (input.isKeyDown(Input.KEY_LEFT)) {
			faerie.moveX(-1);
		}
		if(input.isKeyPressed(Input.KEY_Q)) {
			faerie.autoattack();
		}
		if(input.isKeyPressed(Input.KEY_SPACE)) {
			this.checkIntersection(faerie, interactableObjs);
		}
	}
	
	public void checkCollision(Faerie faerie, Deque<Shape> enemies){
		for(Shape enemy : enemies) {
			if(faerie.ellipse.intersects(enemy)) {
				faerie.takeDamage(); 
			}
		}
	}
	
	public void checkIntersection(Faerie faerie, Deque<Stone> interactableObjs){
		System.out.print(interactableObjs.peek().shape);
		for(Stone shape : interactableObjs) {
			if(faerie.ellipse.intersects(shape.shape)){
				if( shape instanceof  Stone) {
					Stone stone = (Stone)shape; 
					faerie.collectSphere(stone.type);
				}
//				else if (shape instanceof Portal) {
					// to do
//				}
			}
		}
	}
	
	
	
	public void update( int delta) {
		
	}
	
	public void render(Graphics g) {

	}

	
	
}

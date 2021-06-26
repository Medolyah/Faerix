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
import de.faerix.base.stages.StagesHandler;

public class GameHub extends Spielobjekt{
	
	private static GameHub gamehub = null;
	public Faerie faerie; 
	public static GameHub getInstance() {
		if(gamehub == null) gamehub = new GameHub();
		return gamehub;
	}
	
	public GameHub() {
		this.faerie = new Faerie();
	}
	
	


	public void checkInput(Input input, GameContainer container, Deque<Stone> interactableObjs) {
		if (input.isKeyPressed(Input.KEY_ESCAPE)) {
			container.exit();
		} else if (input.isKeyDown(Input.KEY_UP)) {
			if(faerie.yPosition > 0) {
				faerie.moveY(-1);				
			}
			
		} else if (input.isKeyDown(Input.KEY_DOWN)) {
			if(faerie.yPosition < container.getHeight()) {				
				faerie.moveY(1);
			}
		} else if (input.isKeyDown(Input.KEY_RIGHT)) {
			if(faerie.xPosition < container.getWidth()) {
				faerie.moveX(+1);
			}
		} else if (input.isKeyDown(Input.KEY_LEFT)) {
			if(faerie.xPosition > 0) {
				faerie.moveX(-1);				
			}
		}
		if(input.isKeyPressed(Input.KEY_Q)) {
			faerie.autoattack();
		}
		if(input.isKeyPressed(Input.KEY_SPACE)) {
			this.checkIntersection(faerie, interactableObjs);
		}

	}
	
	public void checkCollision( Deque<Shape> enemies){
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
		this.faerie.update(delta);

		
	}
	
	public void render(Graphics g) {
		this.faerie.render(g);

	}

	
	
}

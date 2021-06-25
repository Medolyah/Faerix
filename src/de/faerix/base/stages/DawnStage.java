package de.faerix.base.stages;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.*;

import de.faerix.base.Interface;
import de.faerix.base.Stone;
import de.faerix.base.enums.StoneEnum;
import de.faerix.base.faerie.Faerie;


public class DawnStage extends BasicGameState {

	Image image, startBild, Ellipse;	
	Faerie faerie; 
	public Deque<Stone> interactableShapes = new ArrayDeque<Stone>();
	public Deque<Shape> enemies = new ArrayDeque<Shape>();
	Interface gamehub; 

	public DawnStage(int state) {

	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		image = new Image("assets/faerie.png");
		startBild = new Image("assets/dawnstage_bg.png").getScaledCopy(gc.getWidth(), gc.getHeight());
		this.faerie = new Faerie();
		this.gamehub = new Interface(); 
		int field = 1 + (int) (Math.random() * ((800-1)));
		
		//to be replaced by actual stuff
		this.interactableShapes.push(new Stone(StoneEnum.BLUE, field, field));
		this.enemies.push(new Ellipse(field+30, field-90, 20, 50));
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		startBild.draw();
		this.faerie.render(g);
		this.interactableShapes.peek().render(g);
		g.draw(this.enemies.peek());
	}



	public int getID() {
		return 2;
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		Input input = container.getInput();
		this.faerie.update(delta);
		this.interactableShapes.peek().update(delta);
		this.gamehub.checkInput(input, container, faerie, this.interactableShapes);
		this.gamehub.checkCollision(faerie, this.enemies);
		if(this.faerie.currentHp == 0) {
			game.enterState(14);
		}
	}

}

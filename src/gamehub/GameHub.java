package gamehub;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.StateBasedGame;

import de.faerix.base.GameObject;
import de.faerix.base.enums.StoneEnum;
import de.faerix.base.faerie.AttackSparkle;
import de.faerix.base.faerie.Faerie;
import de.faerix.base.stages.GameStage;
import de.faerix.base.stages.StagesHandler;
import map_objects.Enemy;
import map_objects.Portal;
import map_objects.Stone;

public class GameHub extends GameObject{
	
	
	public HpDisplay display; 
	private QButton qButton;
	private Faerie faerie;
	
	
	private static GameHub gamehub = null;
	
	
	public static GameHub getInstance(Faerie faerie) throws SlickException {
		if(gamehub == null) gamehub = new GameHub(faerie);
		return gamehub;
	}
	
	public GameHub(Faerie faerie) throws SlickException {
		this.faerie = faerie;
		this.display = new HpDisplay();
		this.qButton = new QButton();
		this.updateDisplayWithFaerie();
	}


	private void updateDisplayWithFaerie() {
		this.display.setManaDivider(this.faerie.maxAmunition);
		this.display.setHpDivider(this.faerie.maxHp);
	}

	public void checkInput(int delta, Input input, GameContainer container, List<Stone> interactableObjs,
			Faerie faerie, Portal portal, GameStage stage, StateBasedGame game, List<Enemy> enemies) {
		if (input.isKeyPressed(Input.KEY_ESCAPE)) {
			container.exit();
		} else if (input.isKeyDown(Input.KEY_UP)) {
			if(faerie.yPosition > 0) {
				faerie.moveY(-delta);				
			}
		} else if (input.isKeyDown(Input.KEY_DOWN)) {
			if(faerie.yPosition < container.getHeight()) {				
				faerie.moveY(delta);
			}
		} else if (input.isKeyDown(Input.KEY_RIGHT)) {
			if(faerie.xPosition < container.getWidth()) {
				faerie.moveX(+delta);
			}
		} else if (input.isKeyDown(Input.KEY_LEFT)) {
			if(faerie.xPosition > 0) {
				faerie.moveX(-delta);				
			}
		}
		if(input.isKeyPressed(Input.KEY_Q)) {
			qButton.pressQ(true);
			faerie.autoattack();
			this.display.setMana(faerie.amunition);
		}
		if(input.isKeyPressed(Input.KEY_SPACE)) {
			this.checkIntersection(faerie, interactableObjs);
			this.intersectionPortal(portal, stage, game);
		}		if(input.isKeyPressed(Input.KEY_Z)) {
			stage.goToNextLevel(game);
		}
	}
	
	private void intersectionPortal(Portal portal, GameStage stage, StateBasedGame  game) {
		if(portal.isAlive) {
			if(portal.shape.intersects(faerie.ellipse) || portal.shape.contains(faerie.ellipse)) {
				stage.goToNextLevel(game); 
			}			
		}
		
	}
	
	
	public void checkIntersection(Faerie faerie, List<Stone> stones){
		for(int i=stones.size()-1;i>=0;i--) {
			if(faerie.ellipse.intersects(stones.get(i).shape) || faerie.ellipse.contains(stones.get(i).shape)){
					Stone stone = stones.get(i); 
					faerie.collectSphere(stone.type);
					this.updateDisplayWithFaerie();
					stones.remove(stone);
			}
		}
	}
	
	
	public void update( int delta) {
		this.display.update(delta);
		this.qButton.update(delta);

	}
	
	public void render(Graphics g) {
		this.display.render(g);
		this.qButton.render(g);
	}
}

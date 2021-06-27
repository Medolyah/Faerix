package de.faerix.base.stages;

import java.util.ArrayDeque;
import java.util.Deque;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import de.faerix.base.enums.ContainerSize;
import de.faerix.base.enums.StageEnum;
import de.faerix.base.enums.StoneEnum;
import de.faerix.base.faerie.Faerie;
import gamehub.GameHub;
import map_objects.Portal;
import map_objects.Stone;

public abstract class BasicGameStage extends BasicGameState implements GameStage{
	
	
	Image image, startBild, Ellipse;	

	public Deque<Stone> interactableShapes = new ArrayDeque<Stone>();
	public Deque<Shape> enemies = new ArrayDeque<Shape>();
	GameHub gamehub; 
	public Portal portal;
	public Faerie faerie; 
	public StagesHandler handler; 
	public int level;
	public float xPos; 
	public StageEnum state; 
	public String imageString;
	

	public BasicGameStage(StageEnum state) {
		this.state = state; 
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		this.portal =  new Portal();
		this.startBild= new Image(this.imageString).getScaledCopy(ContainerSize.width.getNumVal(), ContainerSize.height.getNumVal());
		this.gamehub = GameHub.getInstance(faerie);
		this.handler = StagesHandler.getInstance();
		this.level = this.handler.getLevel(this.state);
		
		int field = 1 + (int) (Math.random() * ((800-1)));
		
		//to be replaced by actual stuff
		this.interactableShapes.push(new Stone(StoneEnum.RED, field, field));
		this.interactableShapes.push(new Stone(StoneEnum.BLUE, field+100, field));
		this.enemies.push(new Ellipse(field+30, field-90, 20, 50));

	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(this.startBild, this.xPos, 0);
		if(this.enemies.size() == 0) {
			portal.render(g);			
		}else {
			g.fill(this.enemies.peek());			 
		}
		this.faerie.render(g);
		this.gamehub.render(g);
		for( Stone shape : this.interactableShapes) {
			shape.render(g);
		}

	}

	public abstract int getID();

	
	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
			Input input = container.getInput();
			this.gamehub.update(delta);
			this.faerie.update(delta);
			for( Stone shape : this.interactableShapes) {
				shape.update(delta);
			}
			this.gamehub.checkInput(input, container, this.interactableShapes, faerie, this.portal, this, game, this.enemies);
			this.gamehub.checkCollision(this.enemies, faerie);
			this.gamehub.checkIfEnemyGotHit(this.enemies, faerie.shotAutoattacks);
			if (this.faerie.currentHp <= 0) {
				game.enterState(StageEnum.Gameover.getNumVal());
			}
	}

	@Override
	public void giveFaerie(Faerie faerie) {
		this.faerie = faerie;
	}
	
	public void goToNextLevel(StateBasedGame game) {
		int nextLevel = this.handler.getNextLevelByInt(this.level);
		GameStage nextStage = (GameStage)game.getState(nextLevel);
		nextStage.giveFaerie(this.faerie);
		game.enterState(this.handler.nextStage(this.level));
	}

}

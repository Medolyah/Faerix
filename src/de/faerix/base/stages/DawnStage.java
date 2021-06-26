package de.faerix.base.stages;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.*;

import de.faerix.base.GameHub;
import de.faerix.base.Portal;
import de.faerix.base.Stone;
import de.faerix.base.enums.StageEnum;
import de.faerix.base.enums.StoneEnum;
import de.faerix.base.faerie.Faerie;

public class DawnStage extends BasicGameState implements GameStage{

	Image image, startBild, Ellipse;
	Faerie faerie;
	public Deque<Stone> interactableShapes = new ArrayDeque<Stone>();
	public Deque<Shape> enemies = new ArrayDeque<Shape>();
	GameHub gamehub;
	public Portal portal;
	public StagesHandler handler;
	public int level;
	public float xPos = 0;
	public int yPos;

	public DawnStage(StageEnum state) {

	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		this.portal = new Portal(500, 300);
		startBild = new Image("assets/dawnstage_bg.png").getScaledCopy(gc.getWidth(), gc.getHeight());
		this.gamehub = new GameHub();
		this.handler = StagesHandler.getInstance();
		this.level = this.handler.getLevel(StageEnum.DawnStage);
		int field = 1 + (int) (Math.random() * ((800 - 1)));

		// to be replaced by actual stuff
		this.interactableShapes.push(new Stone(StoneEnum.BLUE, field, field));
		this.enemies.push(new Ellipse(field + 30, field - 90, 20, 50));
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(this.startBild, this.xPos, 0);
		this.faerie.render(g);
		this.gamehub.render(g);
		this.interactableShapes.peek().render(g);
		g.draw(this.enemies.peek());
		portal.render(g);
	}

	public int getID() {
		return StageEnum.DawnStage.getNumVal();
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
			Input input = container.getInput();
			this.gamehub.update(delta);
			this.faerie.update(delta);
			this.interactableShapes.peek().update(delta);
			this.gamehub.checkInput(input, container, this.interactableShapes, faerie);
			this.gamehub.checkCollision(this.enemies, faerie);
			if (this.faerie.currentHp == 0) {
				game.enterState(StageEnum.Gameover.getNumVal());
			}
			if (input.isKeyPressed(Input.KEY_Z)) {
				this.goToNextLevel(game);
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

package de.faerix.base.stages;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import de.faerix.base.enums.ContainerSize;
import de.faerix.base.enums.StageEnum;
import de.faerix.base.enums.StoneEnum;
import de.faerix.base.faerie.AttackSparkle;
import de.faerix.base.faerie.Faerie;
import gamehub.GameHub;
import map_objects.Enemy;
import map_objects.Portal;
import map_objects.Stone;

public abstract class BasicGameStage extends BasicGameState implements GameStage {

	Image image, startBild, Ellipse;
	public List<Stone> interactableShapes = new ArrayList<Stone>();
	public List<Enemy> enemies = new ArrayList<Enemy>();
	GameHub gamehub;
	public Portal portal;
	public Faerie faerie;
	public StagesHandler handler;
	public int level;
	public float xPos;
	public StageEnum state;
	public String imageString;
	private int amtEnemies = 5;
	private int timer;
	private Music music; 

	public BasicGameStage(StageEnum state) {
		this.state = state;
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		this.portal = new Portal();
		this.startBild = new Image(this.imageString).getScaledCopy(ContainerSize.width.getNumVal(),
				ContainerSize.height.getNumVal());
		this.gamehub = GameHub.getInstance(faerie);
		this.handler = StagesHandler.getInstance();
		this.level = this.handler.getLevel(this.state);
		this.amtEnemies = this.handler.getEnemies(this.level);
		this.addEnemies(10);
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(this.startBild, this.xPos, 0);
		this.spawnEnemies(g);
		if (this.amtEnemies <= 0) {
			portal.render(g);
		} 
		this.faerie.render(g);
		this.gamehub.render(g);
		for (Stone shape : this.interactableShapes) {
			shape.render(g);
		}
	}


	public void spawnEnemies(Graphics g) {
		for (Enemy enemy : this.enemies) {
			enemy.render(g);
		}
	}

	public abstract int getID();

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		Input input = container.getInput();
		
		this.gamehub.update(delta);
		
		this.faerie.update(delta);
		
		for (Stone shape : this.interactableShapes) {
			shape.update(delta);
		}
		
		this.gamehub.checkInput(input, container, this.interactableShapes, faerie, this.portal, this, game,
				this.enemies);
		
		this.checkIfEnemyGotHit(this.enemies, faerie.shotAutoattacks);
		
		this.timer ++;
		if(this.timer % 1000 == 1 && this.enemies.size() < 10) {
			this.timer = 0;
			this.addEnemies(1);
		}
		this.moveEnemy(delta);
		if (this.faerie.currentHp <= 0) {
			GameOver gameover = (GameOver) game.getState(StageEnum.Gameover.getNumVal());
			gameover.startMusic();
			game.enterState(StageEnum.Gameover.getNumVal());
		}

		if(this.amtEnemies == 0 && this.enemies.size() == 0) {
			this.portal.isAlive = true;			
		}

	}

	private void moveEnemy(int delta) {
		for (Enemy enemy : this.enemies) {
			enemy.move(this.faerie.xPosition, this.faerie.yPosition);
			enemy.update(delta);
			if(faerie.ellipse.intersects(enemy.shape) || enemy.shape.contains(faerie.ellipse)) {
				faerie.takeDamage(5); 
				this.gamehub.display.setHp(faerie.currentHp);
			}
		}
	}
	
	public void startMusic() {
		try {
			this.music = new Music("assets/sound/stages.wav");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.music.loop();
	}
	
	public void checkIfEnemyGotHit( List<Enemy> enemies, Deque<AttackSparkle> aas){
		for(AttackSparkle aa : aas) {
			for(int i=enemies.size()-1;i>=0;i--) {
				if(aa.shape.intersects(enemies.get(i).shape)){
					aa.hasHitEnemy = true; 
					enemies.get(i).takeDamage(aa.damage);
					if(enemies.get(i).isDead) {
						if(enemies.get(i).hasStone) {
							this.interactableShapes.add(new Stone(enemies.get(i).xPos, enemies.get(i).yPos));
						}
						enemies.remove(enemies.get(i));
					}
					}
				}
			}
	}

	@Override
	public void giveFaerie(Faerie faerie) {
		this.faerie = faerie;
	}
	
	public void addEnemies(int amt) {
		int actualAmt; 
		if(amt < this.amtEnemies) actualAmt = amt;
		else actualAmt = this.amtEnemies;
		for(int i = 0; i < actualAmt; i++) {
			this.enemies.add(new Enemy());			
		}
		
		this.amtEnemies -= actualAmt;

		
	}

	public void goToNextLevel(StateBasedGame game) {
		int nextLevel = this.handler.getNextLevelByInt(this.level);
		GameStage nextStage = (GameStage) game.getState(nextLevel);
		nextStage.giveFaerie(this.faerie);
		game.enterState(this.handler.nextStage(this.level));
	}

}

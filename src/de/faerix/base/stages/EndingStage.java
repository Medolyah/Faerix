package de.faerix.base.stages;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import de.faerix.base.enums.ContainerSize;
import de.faerix.base.enums.StageEnum;
import de.faerix.base.faerie.Faerie;

public class EndingStage extends BasicGameState implements GameStage{

	
	private Image image;
	private Image character; 
	private StagesHandler handler; 
	public Faerie faerie; 
	private Rectangle shape; 
	private float xPos;
	private float  yPos; 
	public StageEnum state;
	private Music music;
	
	public EndingStage(StageEnum ending) {
		this.state = state;
	}

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		// TODO Auto-generated method stub
		this.xPos = ContainerSize.width.getNumVal()/2 +150;
		this.yPos =  ContainerSize.height.getNumVal()-300;
		this.image =new Image  ("assets/sakura_bg.png").getScaledCopy(ContainerSize.width.getNumVal(), ContainerSize.height.getNumVal());
		this.character = new Image ("assets/goddessoflife_sprite.png").getScaledCopy(0.6f);
		this.shape = new Rectangle(this.xPos, this.yPos, this.character.getWidth(), this.character.getHeight());
		this.handler = StagesHandler.getInstance(); 
		this.music = new Music("assets/sound/ending.wav"); 
		
	}
	

	public void giveFaerie(Faerie faerie) {
		this.faerie = faerie;
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		g.fill(this.shape);
		g.drawImage(this.image, 0,0);
		this.faerie.render(g);			
		g.drawImage(this.character, this.xPos, this.yPos);
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		// TODO Auto-generated method stub
			this.faerie.update(delta);		
			
			Input input = container.getInput();
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
				if(faerie.xPosition > delta) {
					faerie.moveX(-1);				
				}
			}
			
			if(input.isKeyPressed(Input.KEY_SPACE)) {
				if(this.shape.contains(faerie.ellipse) || this.shape.intersects(faerie.ellipse)) {
					this.goToNextLevel(game);
				}				
			}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return StageEnum.Ending.getNumVal();
	}
	
	public void goToNextLevel(StateBasedGame game) {
		game.enterState(StageEnum.Epilogue.getNumVal());
	}

	@Override
	public void startMusic() {
		this.music.loop();
	}
	
	

}

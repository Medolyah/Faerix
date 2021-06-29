package de.faerix.base.stages;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import de.faerix.base.enums.StageEnum;
import de.faerix.base.faerie.Faerie;

public class Epilogue extends BasicGameState{
	Epilogue play;
	Music bgMusic;
	Sound click;
	int time = 0;
	String string = "";
	private Image princess;
	
	public Epilogue(StageEnum epilogue) {
		
	}
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
//		bgMusic = new Music("testdata/sound/Death_Note_achtig.ogg");
//		bgMusic.loop();
		click = new Sound("assets/sound/click.wav");
		this.play = new Epilogue(StageEnum.Epilogue);
		this.princess = new Image("assets/goddessoflife.png").getScaledCopy(0.5f);
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		g.setColor(Color.white);
		g.drawString(this.string, 240, 450);
		g.drawImage(this.princess, container.getWidth()-this.princess.getWidth(), container.getHeight()-this.princess.getHeight());

		// in update():

		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		// TODO Auto-generated method stub
		String string = "Thank you for everything! \n"
				+ "You truly are a hero... \n"
				+ "What was your name again, faerie?  \n"
				+ "We will forever be grateful for the service you've given this kingdom. \n"
				+ "As the Queen of these lands I thank you from the bottom of my heart.";
		time++;
		if(time % 100 == 0 && this.string.length() < string.length()) {
			click.play(3, (float) 0.5);
				this.string = string.substring(0, time/100);				
			}
		
		if(container.getInput().isKeyPressed(Input.KEY_SPACE)) {
			this.goToNextLevel(game); 
		}
	}



	public void goToNextLevel(StateBasedGame game) {
		game.enterState(StageEnum.Credits.getNumVal());
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return StageEnum.Epilogue.getNumVal();
	}
}

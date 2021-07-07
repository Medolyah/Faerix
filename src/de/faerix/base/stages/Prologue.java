package de.faerix.base.stages;
import java.util.Timer;

import de.faerix.base.stages.GameStage;
import org.lwjgl.input.Mouse;
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

public class Prologue extends BasicGameState{

	Prologue play;
	Music bgMusic;
	Sound click;
	int time = 0;
	String string = "";
	StagesHandler handler;

	
	public Prologue(StageEnum prologue) {
		
	}
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
//		bgMusic = new Music("testdata/sound/Death_Note_achtig.ogg");
//		bgMusic.loop();
		click = new Sound("assets/sound/click.wav");
		this.play = new Prologue(StageEnum.Prologue);
		this.handler = StagesHandler.getInstance(); 
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {

		g.drawString(this.string, 240, 450);

		// in update():

		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		// TODO Auto-generated method stub
		String string = "To whomever this reaches... \n"
				+ "This letter comes from a place of deep urgency... We need your help!  \n"
				+ "Our kingdom Eryluh has been attacked by some utmost horrible creatures! \n"
				+ "If we do nothing, they will destroy our beautiful lands... \n"
				+ "You have to help us... ";
		time++;
		if(time % 50 == 0 && this.string.length() < string.length()) {
			click.play(3, (float) 0.5);
				this.string = string.substring(0, time/50);				
			}
		
		Input input  = container.getInput();
		if(input.isKeyPressed(Input.KEY_SPACE)) {
			GameStage nextStage = (GameStage)game.getState(this.handler.nextStage(0));
			nextStage.startMusic();
			game.enterState(this.handler.nextStage(0));
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return StageEnum.Prologue.getNumVal();
	}

}

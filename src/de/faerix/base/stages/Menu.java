package de.faerix.base.stages;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import de.faerix.base.enums.StageEnum;

import org.lwjgl.input.Mouse;

public class Menu extends BasicGameState{
	
	DawnStage play;
	
	Image playNow;
	Image exitGame;
	Image startBild;
	Music bgMusic;
	Sound click;
	
	
	
	
	public Menu(StageEnum menu) {
		
	}
	public void init(GameContainer container, StateBasedGame sbg) throws SlickException{
		startBild = new Image("assets/startBild.png");
		//exitGame = new Image("testdata/Exit.png");
		playNow = new Image("assets/playNow.png");
		bgMusic = new Music("assets/sound/deathnotelike.wav");
		bgMusic.loop();
		click = new Sound("assets/sound/click.wav");
		this.play = new DawnStage(StageEnum.DawnStage);
		
		
		
	}
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException{
		startBild.draw();
		g.drawString("Welcome to Faerix",680,450);
		playNow.draw(0,50);
		//exitGame.draw(100,200);
		
		
		
	}
	public void update(GameContainer container, StateBasedGame sbg, int  delta) throws SlickException{
		
		int posX =  Mouse.getX();
		int posY = Mouse.getY();
		if ((posX > 500 && posX < 1100)&& (posY > 450 && posY < 1000) ) {
			if(Mouse.isButtonDown(0)) {
				click.play();
				sbg.enterState(1);
			}
			}
		}

	public int getID() {
		return 0;
	}
	
}

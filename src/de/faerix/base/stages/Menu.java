package de.faerix.base.stages;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import de.faerix.base.enums.StageEnum;
import map_objects.Cloud;

import org.lwjgl.input.Mouse;

public class Menu extends BasicGameState{
	
	DawnStage play;
	
	Image playNow;
	Cloud cloud1, cloud2, cloud3;
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
		this.cloud1 = new Cloud(0.1f, 600, 150f, new Image("assets/map_objects/cloud_1.png").getScaledCopy(400, 200), 1, container.getWidth(), container.getHeight());
		this.cloud2 = new Cloud(0.1f, 300, 389f, new Image("assets/map_objects/cloud_3.png").getScaledCopy(300, 150), -1, container.getWidth(), container.getHeight());
		this.cloud3 = new Cloud(0.09f, 0f, 700f, new Image("assets/map_objects/cloud_2.png").getScaledCopy(300, 200), 1, container.getWidth(), container.getHeight()); 
		
		
		this.play = new DawnStage(StageEnum.DawnStage);
		
		
		
	}
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException{
		startBild.draw();
		this.cloud1.render(g);
		this.cloud2.render(g);
		this.cloud3.render(g);
		g.drawString("Welcome to Faerix",680,450);
		playNow.draw(0,50);
		//exitGame.draw(100,200);
	}
	
	public void update(GameContainer container, StateBasedGame sbg, int  delta) throws SlickException{
		
		int posX =  Mouse.getX();
		int posY = Mouse.getY();
		this.cloud1.update(delta);
		this.cloud2.update(delta);
		this.cloud3.update(delta);
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

package de.faerix.base;

import java.util.Random;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import de.faerix.base.stages.DawnStage;
import de.faerix.base.stages.GameOver;
import de.faerix.base.stages.Menu;
import de.faerix.base.stages.Prologue;

import org.lwjgl.input.Mouse;


public class Main extends StateBasedGame {
	
	public static final String gamename = "Faerix";
	public static final int menu = 0;
	public static final int prologue = 1;
	public static final int dawnstage = 2;
	public static final int epilogue = 14;
	public static final int gameover = 14;
	public static Music bgMusic;
	

	public Main(String gamename) {
		super(gamename);
		this.addState(new Menu(menu));
		this.addState(new Prologue(prologue));
		this.addState(new DawnStage(dawnstage));
		this.addState(new GameOver(epilogue));
		this.addState(new GameOver(gameover));
	}

	public void initStatesList(GameContainer container) throws SlickException {
		this.getState(menu).init(container, this);
		//this.getState(play).init(container, this);
		this.enterState(menu);
		
	}
		
	public static void main(String[] args) {
		AppGameContainer appcontainer;
		try {
			appcontainer = new AppGameContainer(new Main(gamename));
			appcontainer.setDisplayMode(1500, 900, false);
			appcontainer.start();
			
		}catch(SlickException e) {
			e.printStackTrace();
		}
	}
		
}
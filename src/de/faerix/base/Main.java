package de.faerix.base;

import java.util.Random;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import de.faerix.base.enums.StageEnum;
import de.faerix.base.faerie.Faerie;
import de.faerix.base.stages.DawnStage;
import de.faerix.base.stages.Epilogue;
import de.faerix.base.stages.GameOver;
import de.faerix.base.stages.Menu;
import de.faerix.base.stages.NightskyStage;
import de.faerix.base.stages.Prologue;
import de.faerix.base.stages.StagesHandler;

import org.lwjgl.input.Mouse;


public class Main extends StateBasedGame{
	
	public static final String gamename = "Faerix";
	public static Music bgMusic;
	public Faerie faerie;
	public GameHub gamehub;
	public de.faerix.base.stages.StagesHandler stageFactory;


	public Main(String gamename) {
		super(gamename);
		this.addState(new Menu(StageEnum.Menu));
		this.addState(new Prologue(StageEnum.Prologue));
		this.addState(new DawnStage(StageEnum.DawnStage));
		this.addState(new NightskyStage(StageEnum.NightskyStage));
		this.addState(new Epilogue(StageEnum.Epilogue));
		this.addState(new GameOver(StageEnum.Gameover));
	}
	

	public void initStatesList(GameContainer container) throws SlickException {
		//this.getState(StageEnum.Menu.getNumVal()).init(container, this);
		this.enterState(StageEnum.Menu.getNumVal());
		this.faerie = new Faerie();

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
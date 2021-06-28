package de.faerix.base;

import java.util.Random;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import de.faerix.base.enums.StageEnum;
import de.faerix.base.faerie.Faerie;
import de.faerix.base.stages.DawnStage;
import de.faerix.base.stages.DesertStage;
import de.faerix.base.stages.Epilogue;
import de.faerix.base.stages.GameOver;
import de.faerix.base.stages.GameStage;
import de.faerix.base.stages.Menu;
import de.faerix.base.stages.MoonStage;
import de.faerix.base.stages.NightskyStage;
import de.faerix.base.stages.Prologue;
import de.faerix.base.stages.SakuraStage;
import de.faerix.base.stages.StagesHandler;
import de.faerix.base.stages.UnderwaterStage;
import gamehub.GameHub;

import org.lwjgl.input.Mouse;


public class Main extends StateBasedGame{
	
	public static final int CNTWIDTH = 1500;
	public static final int CNTHEIGHT = 900;
	public static final String gamename = "Faerix";
	public static Music bgMusic;
	public Faerie faerie;
	private GameHub gamehub; 
	public de.faerix.base.stages.StagesHandler stageHandler;


	public Main(String gamename) {
		super(gamename);
		this.addState(new Menu(StageEnum.Menu));
		this.addState(new Prologue(StageEnum.Prologue));
		this.addState(new DawnStage(StageEnum.DawnStage));
		this.addState(new NightskyStage(StageEnum.NightskyStage));
		this.addState(new MoonStage(StageEnum.MoonStage));
		this.addState(new DesertStage(StageEnum.Desert));
		this.addState(new SakuraStage(StageEnum.Sakura));
		this.addState(new UnderwaterStage(StageEnum.Underwater));
		this.addState(new Epilogue(StageEnum.Epilogue));
		this.addState(new GameOver(StageEnum.Gameover));
	}
	

	public void initStatesList(GameContainer container) throws SlickException {
		//this.getState(StageEnum.Menu.getNumVal()).init(container, this);
		this.faerie = new Faerie();
		this.stageHandler = StagesHandler.getInstance();
		this.gamehub = GameHub.getInstance(faerie);
		GameStage firstStage = (GameStage)this.getState(this.stageHandler.getNextLevelByInt(0));
		firstStage.giveFaerie(this.faerie);
		this.enterState(StageEnum.Menu.getNumVal());
	}
	
		
	public static void main(String[] args) {
		AppGameContainer appcontainer;
		try {
			appcontainer = new AppGameContainer(new Main(gamename));
			appcontainer.setDisplayMode(CNTWIDTH, CNTHEIGHT, false);
			appcontainer.start();
			
		}catch(SlickException e) {
			e.printStackTrace();
		}
	}





		
}
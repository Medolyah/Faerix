package de.faerix.base.stages;

import java.util.Arrays;
import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.StateBasedGame;

import de.faerix.base.GameHub;
import de.faerix.base.enums.StageEnum;
import de.faerix.base.faerie.Faerie;

public class StagesHandler{
	
	private static StagesHandler handler = null;
	public static StagesHandler getInstance() {
		if(handler == null) handler = new StagesHandler();
		return handler;
	}
	
	public StagesHandler() {
		this.createRandomStageOrder();
	}
	
	
	StageEnum[] stageTypes = {StageEnum.NightskyStage, StageEnum.DawnStage};
	int levels = this.stageTypes.length;
	StageEnum[] stages = new StageEnum[levels];
	
	int currentLevel = 0; 
	
	public void createRandomStageOrder() {
		for(int i = 0; i < levels; i ++) {
			StageEnum randomStage = this.getRandomStage(levels-1-i);
			System.out.println(randomStage);
			this.stages[i] = randomStage;
		}
	}
	
	public StageEnum getRandomStage(int i) {
		Random random = new Random();
		int randomStage; 
		if(i > 0 ) {randomStage = random.nextInt(i);}
		else {randomStage = 0;};
		StageEnum nextStage = stageTypes[randomStage];
		if(Arrays.asList(this.stages).contains(nextStage)) return this.getRandomStage(this.levels-i);
		else return nextStage;
	}

	
	public int nextStage(int currentLevel) {
		if(currentLevel < this.levels ) {
			return this.stages[currentLevel].getNumVal(); 			
		}else
			return StageEnum.Epilogue.getNumVal();
	}
	
	public Shape[] getEnemies(int level) {
		Shape[] shapes = new Shape[level*5];
		for(int i = 0; i < level*5; i++) {
			Shape shape = new Ellipse(0,0,0,0);
			shapes[i]=shape;	
		}
		return shapes;
	}

	public int getLevel(StageEnum state) {
		Arrays.asList(this.stages).indexOf(state);
		return Arrays.asList(this.stages).indexOf(state)+1;
	}

}

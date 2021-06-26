package de.faerix.base.stages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Shape;
import de.faerix.base.enums.StageEnum;


public class StagesHandler{
	
	private static StagesHandler handler = null;
	public static StagesHandler getInstance() {
		if(handler == null) handler = new StagesHandler();
		return handler;
	}
	
	public StagesHandler() {
		System.out.print("a new one has been created"); 
		for(StageEnum stage : arrayStageTypes) {
			this.stageTypes.add(stage); 
		}
		this.createRandomStageOrder();
		for(StageEnum stage : arrayStageTypes) {
			System.out.print(stage); 
		}
	}
	
	
	private StageEnum[] arrayStageTypes = {StageEnum.DawnStage, StageEnum.MoonStage, StageEnum.NightskyStage};
	List<StageEnum> stageTypes = new ArrayList<StageEnum>();
	int levels = arrayStageTypes.length; 
	StageEnum[] stages = new StageEnum[levels];
	
	int currentLevel = 0; 
	
	public void createRandomStageOrder() {
		for(int i = 0; i < levels; i ++) {
			StageEnum randomStage = this.getRandomStage(levels-1-i);
			this.stages[i] = randomStage;
		}

	}
	
	public StageEnum getRandomStage(int i) {
		Random random = new Random();
		StageEnum nextStage;
		if(i > 0 ) {
			int randomNb = random.nextInt(i);
			nextStage = stageTypes.get(randomNb);
			stageTypes.remove(nextStage);
		}
		else {
			nextStage = stageTypes.get(0);
			};
		return nextStage;
	}

	
	public int nextStage(int currentLevel) {
		System.out.println("NEXTSTAGE:" + this.levels);
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
	
	public int getNextLevelByInt(int level) {
		if(level < this.levels) {
			Arrays.asList(this.stages).get(level);			
			return Arrays.asList(this.stages).get(level).getNumVal();}
			else return Arrays.asList(this.stages).get(level-1).getNumVal();  // to give faerie back to the own stage ffs im so done i dont want to anymore
	}
	


}

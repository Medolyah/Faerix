package de.faerix.base.stages;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Random;
import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Shape;
import de.faerix.base.enums.StageEnum;
import map_objects.Enemy;


public class StagesHandler{
	
	private static StagesHandler handler = null;
	public static StagesHandler getInstance() {
		if(handler == null) handler = new StagesHandler();
		return handler;
	}
	
	public StagesHandler() {
		for(StageEnum stage : arrayStageTypes) {
			this.stageTypes.add(stage); 
		}
		this.createRandomStageOrder();
	}
	
	
	private StageEnum[] arrayStageTypes = {StageEnum.DawnStage, StageEnum.NightskyStage, StageEnum.MoonStage, StageEnum.Sakura, StageEnum.Underwater, StageEnum.Desert};
	List<StageEnum> stageTypes = new ArrayList<StageEnum>();
	int levels = arrayStageTypes.length; 
	StageEnum[] stages = new StageEnum[levels+1];
	
	int currentLevel = 0; 
	
	public void createRandomStageOrder() {
		for(int i = 0; i < levels; i ++) {
			StageEnum randomStage = this.getRandomStage(levels-1-i); 
			this.stages[i] = randomStage;
		}
		this.stages[stages.length-1] = StageEnum.Ending;
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
		if(currentLevel < this.levels ) {
			return this.stages[currentLevel].getNumVal(); 			
		}else
			return StageEnum.Ending.getNumVal();
	}
	
	public int getEnemies(int level) {
		return (level+1) * 5;
	}

	public int getLevel(StageEnum state) {
		return Arrays.asList(this.stages).indexOf(state)+1;
	}
	
	public int getNextLevelByInt(int level) {
		if(level < this.levels+1) {		
			return Arrays.asList(this.stages).get(level).getNumVal();
		}
		else return Arrays.asList(this.stages).get(level-1).getNumVal();
	}
	


}

package de.faerix.base.stages;


import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import de.faerix.base.enums.ContainerSize;
import de.faerix.base.enums.StageEnum;



public class NightskyStage extends  BasicGameStage implements GameStage{


	public NightskyStage(StageEnum state){
		super(state);
		this.imageString = "assets/nightsky_bg.png";
	}

	public int getID() {
		return StageEnum.NightskyStage.getNumVal();
	}	

}

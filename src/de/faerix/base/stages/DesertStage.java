package de.faerix.base.stages;

import de.faerix.base.enums.StageEnum;

public class DesertStage extends BasicGameStage{

	public DesertStage(StageEnum state) {
		super(state);
		this.imageString = "assets/dessert_bg.png";
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return StageEnum.Desert.getNumVal();
	}

}

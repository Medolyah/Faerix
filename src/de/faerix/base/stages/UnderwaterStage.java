package de.faerix.base.stages;

import de.faerix.base.enums.StageEnum;

public class UnderwaterStage extends BasicGameStage {

	public UnderwaterStage(StageEnum state) {
		super(state);
		this.imageString = "assets/underwater_bg.png";
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return StageEnum.Underwater.getNumVal();
	}

}

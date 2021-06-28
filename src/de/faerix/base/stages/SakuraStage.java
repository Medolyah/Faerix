package de.faerix.base.stages;

import de.faerix.base.enums.StageEnum;

public class SakuraStage extends BasicGameStage {

	public SakuraStage(StageEnum state) {
		super(state);
		this.imageString = "assets/sakura_bg.png";
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return StageEnum.Sakura.getNumVal();
	}

}

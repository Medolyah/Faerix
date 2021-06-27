package de.faerix.base.stages;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.*;

import de.faerix.base.enums.ContainerSize;
import de.faerix.base.enums.StageEnum;
import de.faerix.base.enums.StoneEnum;
import de.faerix.base.faerie.Faerie;
import gamehub.GameHub;
import map_objects.Portal;
import map_objects.Stone;

public class DawnStage extends BasicGameStage implements GameStage {

	public DawnStage(StageEnum state) {
		super(state);
		this.imageString = "assets/dawnstage_bg.png";

	}

	public int getID() {
		return StageEnum.DawnStage.getNumVal();
	}
}

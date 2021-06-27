package de.faerix.base.stages;

import java.util.ArrayDeque;
import java.util.Deque;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import de.faerix.base.enums.ContainerSize;
import de.faerix.base.enums.StageEnum;
import de.faerix.base.enums.StoneEnum;
import de.faerix.base.faerie.Faerie;
import gamehub.GameHub;
import map_objects.Portal;
import map_objects.Stone;

public class MoonStage extends  BasicGameStage implements GameStage{
	
	
	public MoonStage(StageEnum state) {
		super(state);

			this.imageString ="assets/moonstage.png";
	}
	
	public int getID() {
		return StageEnum.MoonStage.getNumVal();
	}
}

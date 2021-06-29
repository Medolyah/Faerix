package de.faerix.base.stages;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import de.faerix.base.enums.StageEnum;
import de.faerix.base.faerie.Faerie;

public class Credits extends BasicGameState{


	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {		

	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		float x = container.getWidth()/2-120;
		float y = container.getHeight()/2-100;
		g.setColor(Color.white);
		g.drawString("Idea and Concept \n"
				+ "Layla Kröber \n"
				+ "Michael Nunes Jacobs", x, y-75);
		
		g.drawString("Programming \n"
				+ "Michael Nunes Jacobs \n"
				+ "Layla Kröber\n"
				+ "Rami Masri", x, y);
		
		g.drawString("Graphics and Drawings \n"
				+ "Layla Kröber", x, y+95);
		
		g.drawString("Music \n"
				+ "Sven Westerbeek", x, y+145);
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		if(container.getInput().isKeyPressed(Input.KEY_SPACE)) {
			container.exit();
		}
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return StageEnum.Credits.getNumVal();
	}

	

}

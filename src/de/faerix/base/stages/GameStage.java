package de.faerix.base.stages;

import org.newdawn.slick.state.StateBasedGame;

import de.faerix.base.faerie.Faerie;

public interface GameStage {
	
	public void giveFaerie(Faerie faerie);
	void goToNextLevel(StateBasedGame game);

}

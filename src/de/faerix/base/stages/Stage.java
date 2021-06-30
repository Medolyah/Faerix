package de.faerix.base.stages;

import org.newdawn.slick.geom.Shape;

import de.faerix.base.faerie.Faerie;
import gamehub.GameHub;

public interface Stage {
	
	
	public void initObjects(Faerie faerie, Shape[] enemies, GameHub gamehub);
	
}

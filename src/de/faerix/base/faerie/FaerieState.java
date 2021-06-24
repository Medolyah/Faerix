package de.faerix.base.faerie;

import org.newdawn.slick.Graphics;

public interface FaerieState {

	public void autoattack(Faerie faeire);
	public void ultattack(Faerie faeire); 
	public void upgradeFaerie(Faerie faeire);
	public void collectFireStone(Faerie faerie);
	public void collectWaterStone(Faerie faerie);
	public void collectStarStone(Faerie faerie);
	public void setSparkleColor(Faerie faerie, Graphics g);
	public void setStats(Faerie faerie);
}

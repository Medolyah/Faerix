package de.faerix.base.faerie;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class StarFaerie implements FaerieState {
	

	public StarFaerie(Faerie faerie) {
		try {
			faerie.image = new Image("assets/starfaerie.png").getScaledCopy(68, 65);
			faerie.leftWings = new Image("assets/left_wing_star.png").getScaledCopy(150, 150);
			faerie.rightWings = new Image("assets/right_wing_star.png").getScaledCopy(150, 150);
			faerie.sparkleImage = new Image("assets/faerie/star_sparkle.png", new Color(255,255,255,0.5f));
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void autoattack(Faerie faeire) {
		// TODO Auto-generated method stub

	}

	@Override
	public void ultattack(Faerie faeire) {
		// TODO Auto-generated method stub

	}

	@Override
	public void upgradeFaerie(Faerie faeire) {
		// TODO Auto-generated method stub

	}

	@Override
	public void collectFireStone(Faerie faerie) {
		// TODO Auto-generated method stub

	}

	@Override
	public void collectWaterStone(Faerie faerie) {
		// TODO Auto-generated method stub

	}

	@Override
	public void collectStarStone(Faerie faerie) {
		// TODO Auto-generated method stub

	}


	@Override
	public void setSparkleColor(Faerie faerie, Graphics g) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setStats(Faerie faerie) {
		// TODO Auto-generated method stub
		
	}

}

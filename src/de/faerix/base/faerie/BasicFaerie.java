package de.faerix.base.faerie;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class BasicFaerie implements FaerieState {
	
	public BasicFaerie(Faerie faerie) {
		try {
			faerie.image = new Image("testdata/faerie.png");
			faerie.leftWings = new Image("testdata/left_wing_fire.png").getScaledCopy(150, 150);
			faerie.rightWings = new Image("testdata/right_wing_fire.png").getScaledCopy(150, 150);
			faerie.sparkleImage = new Image("testdata/faerie.png", new Color(255,255,255,0.2f));
			
			
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
		faerie.form = new FireFaerie(faerie);
		
	}

	@Override
	public void collectWaterStone(Faerie faerie) {
		faerie.form = new WaterFaerie(faerie);
		
	}

	@Override
	public void collectStarStone(Faerie faerie) {
		// TODO Auto-generated method stub
		faerie.form = new StarFaerie(faerie);
	}

	@Override
	public void setSparkleColor(Faerie faerie, Graphics g) {
		g.setColor(new Color(204,204,255, 0.2f));
	}

	@Override
	public void setStats(Faerie faerie) {
		faerie.maxHp = 10;
		faerie.currentHp = faerie.maxHp;
	}

}

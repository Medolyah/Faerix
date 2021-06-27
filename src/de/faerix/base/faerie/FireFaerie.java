package de.faerix.base.faerie;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.ShapeFill;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Ellipse;

public class FireFaerie implements FaerieState {

	public FireFaerie(Faerie faerie) {
		try {
			faerie.image = new Image("assets/firefaerie.png").getScaledCopy(68, 65);
			faerie.leftWings = new Image("assets/left_wing_fire.png").getScaledCopy(150, 150);
			faerie.rightWings = new Image("assets/right_wing_fire.png").getScaledCopy(150, 150);
			faerie.sparkleImage = new Image("assets/faerie/fire_sparkle.png", new Color(255,255,255,0.5f));
			System.out.print("firefaerie");
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

	}

	@Override
	public void collectWaterStone(Faerie faerie) {
		faerie.form = new WitchFaerie(faerie);

	}

	@Override
	public void collectStarStone(Faerie faerie) {
		faerie.form = new SunFaerie(faerie);

	}


	@Override
	public void setSparkleColor(Faerie faerie, Graphics g) {
		///faerie.SparkleImage = new Image("firesparkle.png")
	}


	@Override
	public void setStats(int maxAmunition, float velocity, int maxHp, int invinvibleDuration, Faerie faerie) {
		// TODO Auto-generated method stub
		
	}

}

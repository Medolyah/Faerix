package de.faerix.base.faerie;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.ShapeFill;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.geom.Ellipse;

public class FireFaerie implements FaerieState {

	private Sound sound; 
	public FireFaerie(Faerie faerie) {
		try {
			faerie.image = new Image("assets/faerie/firefaerie.png").getScaledCopy(68, 65);
			faerie.leftWings = new Image("assets/faerie/left_wing_fire.png").getScaledCopy(150, 150);
			faerie.rightWings = new Image("assets/faerie/right_wing_fire.png").getScaledCopy(150, 150);
			faerie.sparkleImage = new Image("assets/faerie/fire_sparkle.png", new Color(255, 255, 255, 0.5f));
			this.sound = new Sound("assets/sound/faerie/fire");
			faerie.color = new Color(252, 0.2f, 0.2f, 0.2f);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void autoattack(Faerie faerie) {

		if (faerie.amunition > 0) {
			AttackSparkle aa = new AttackSparkle(new Ellipse(faerie.xPosition, faerie.yPosition, 5, 5), (float) 1.5,
					(float) 600, faerie.sparkleImage, faerie.direction, sound, 5);
			faerie.shotAutoattacks.add(aa);
			aa.shoot(faerie.xPosition, faerie.yPosition);
			System.out.println(faerie.amunition);
			faerie.amunition--;
		}

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
		/// faerie.SparkleImage = new Image("firesparkle.png")
	}

	@Override
	public void setStats(int maxAmunition, float velocity, int maxHp, int invinvibleDuration, Faerie faerie) {
		// TODO Auto-generated method stub

	}

}

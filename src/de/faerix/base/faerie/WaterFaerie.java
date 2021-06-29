package de.faerix.base.faerie;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.geom.Ellipse;

import de.faerix.base.enums.Direction;

public class WaterFaerie implements FaerieState {
	

	private Sound sound; 
	public WaterFaerie(Faerie faerie) {
		try {
			faerie.image = new Image("assets/faerie/waterfaerie.png").getScaledCopy(68, 65);
			faerie.leftWings = new Image("assets/faerie/left_wing_water.png").getScaledCopy(150, 150);
			faerie.rightWings = new Image("assets/faerie/right_wing_water.png").getScaledCopy(150, 150);
			faerie.sparkleImage = new Image("assets/faerie/water_sparkle.png", new Color(255,255,255,0.5f));
			//this.setStats(faerie);
			this.sound = new Sound("assets/sound/faerie/water.mp3");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void autoattack(Faerie faerie) {
		if(faerie.amunition> 0) {
			AttackSparkle aa = new AttackSparkle(new Ellipse(faerie.xPosition, faerie.yPosition, 15, 15),
					(float)0.2, (float)800, faerie.sparkleImage, faerie.direction, sound, 5);
			faerie.shotAutoattacks.add(aa);
			aa.shoot(faerie.xPosition, faerie.yPosition);
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
		faerie.form = new WitchFaerie(faerie);

	}

	@Override
	public void collectWaterStone(Faerie faerie) {
		

	}

	@Override
	public void collectStarStone(Faerie faerie) {
		faerie.form = new NatureFaerie(faerie);
	}


	@Override
	public void setSparkleColor(Faerie faerie, Graphics g) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setStats(int maxAmunition, float velocity, int maxHp, int invinvibleDuration, Faerie faerie) {
		faerie.velocity = 0.4f;
		faerie.setMaxHp(150);
		faerie.setMaxamunition(15); 

	}

}

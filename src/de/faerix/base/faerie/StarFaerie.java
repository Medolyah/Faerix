package de.faerix.base.faerie;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Ellipse;

import de.faerix.base.stages.GameStage;

public class StarFaerie implements FaerieState {
	

	public StarFaerie(Faerie faerie) {
		try {
			faerie.image = new Image("assets/faerie/starfaerie.png").getScaledCopy(68, 65);
			faerie.leftWings = new Image("assets/faerie/left_wing_star.png").getScaledCopy(150, 150);
			faerie.rightWings = new Image("assets/faerie/right_wing_star.png").getScaledCopy(150, 150);
			faerie.sparkleImage = new Image("assets/faerie/star_sparkle.png", new Color(255,255,255,0.5f));
			this.setStats(10, 0.5f, 100, 1, faerie);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void autoattack(Faerie faerie) {
		if(faerie.amunition > 0 ) {
			AttackSparkle aa = new AttackSparkle(new Ellipse(faerie.xPosition, faerie.yPosition, 5, 5),
					(float)0.6, (float)600, faerie.sparkleImage, faerie.direction);
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
		faerie.form = new SunFaerie(faerie);

	}

	@Override
	public void collectWaterStone(Faerie faerie) {
		faerie.form = new NatureFaerie(faerie);

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
	public void setStats(int maxAmunition, float velocity, int maxHp, int invinvibleDuration, Faerie faerie){
		faerie.velocity = 0.4f;
		faerie.setMaxHp(150);
		faerie.setMaxamunition(15); 
	}

}

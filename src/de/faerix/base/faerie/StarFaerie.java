package de.faerix.base.faerie;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.geom.Ellipse;

import de.faerix.base.enums.Direction;
import de.faerix.base.stages.GameStage;

public class StarFaerie implements FaerieState {
	

	private Sound sound;
	public StarFaerie(Faerie faerie) {
		try {
			faerie.image = new Image("assets/faerie/starfaerie.png").getScaledCopy(68, 65);
			faerie.leftWings = new Image("assets/faerie/left_wing_star.png").getScaledCopy(150, 150);
			faerie.rightWings = new Image("assets/faerie/right_wing_star.png").getScaledCopy(150, 150);
			faerie.sparkleImage = new Image("assets/faerie/star_sparkle.png", new Color(255,255,255,0.5f));
			this.setStats(10, 0.5f, 30, 3000, faerie);
			this.sound = new Sound("assets/sound/faerie/star_.wav");
			faerie.color = new Color(255f, 0.9f, 176f, 0.2f);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void autoattack(Faerie faerie) {
		if(faerie.amunition > 0 ) {
			AttackSparkle aa = new AttackSparkle(new Ellipse(faerie.xPosition, faerie.yPosition, 5, 5),
					(float)0.9, (float)600, faerie.sparkleImage, Direction.North, sound, 15);
			AttackSparkle aa2 = new AttackSparkle(new Ellipse(faerie.xPosition, faerie.yPosition, 5, 5),
					(float)0.9, (float)600, faerie.sparkleImage, Direction.South, sound, 15);
			faerie.shotAutoattacks.add(aa);
			faerie.shotAutoattacks.add(aa2);
			aa.shoot(faerie.xPosition, faerie.yPosition);
			aa2.shoot(faerie.xPosition, faerie.yPosition);
			faerie.amunition-=2;
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
		if(faerie.maxHp > 10) faerie.currentHp = -1*(10 - faerie.maxHp); 
		else faerie.currentHp += 10;
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

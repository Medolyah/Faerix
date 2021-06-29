package de.faerix.base.faerie;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.geom.Ellipse;

import de.faerix.base.enums.Direction;

public class SunFaerie implements FaerieState {

	
	private Sound sound; 
	public SunFaerie(Faerie faerie) {
		try {
			faerie.image = new Image("assets/faerie/sunfaerie.png").getScaledCopy(68, 65);
			faerie.leftWings = new Image("assets/faerie/left_wing_sun.png").getScaledCopy(150, 150);
			faerie.rightWings = new Image("assets/faerie/right_wing_sun.png").getScaledCopy(150, 150);
			faerie.sparkleImage = new Image("assets/faerie/sun_sparkle.png", new Color(255, 255, 255, 0.5f));
			this.setStats(10, 0.5f, 100, 1, faerie);
			 this.sound = new Sound("assets/sound/faerie/sun-2.wav");
				faerie.color = new Color(255f, 188f, 0.2f, 0.2f); 
			this.setStats(50, 0.2f, 30, 500, faerie);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void autoattack(Faerie faerie) {
		// TODO Auto-generated method stub
		Direction[] direction = {Direction.West, Direction.East, Direction.North, Direction.SouthEast, Direction.SouthWest};
		if (faerie.amunition > 0) {
			for(int i = 0; i <5 ; i++) {
				AttackSparkle aa = new AttackSparkle(new Ellipse(faerie.xPosition, faerie.yPosition, 4, 5), (float) 0.6,
						(float) 600, faerie.sparkleImage, direction[i], sound, 15);
				faerie.shotAutoattacks.add(aa);
				aa.shoot(faerie.xPosition, faerie.yPosition);				
				faerie.amunition--;
			}
		}

	}

	@Override
	public void ultattack(Faerie faeire) {
		if(faeire.maxHp > 10) faeire.currentHp = -1*(10 - faeire.maxHp); 
		else faeire.currentHp += 10;
	}

	@Override
	public void upgradeFaerie(Faerie faeire) {


	}

	@Override
	public void collectFireStone(Faerie faerie) {
		if(faerie.maxHp > 10) faerie.currentHp = -1*(10 - faerie.maxHp); 
		else faerie.currentHp += 10;

	}

	@Override
	public void collectWaterStone(Faerie faerie) {
		if(faerie.maxHp > 10) faerie.currentHp = -1*(10 - faerie.maxHp); 
		else faerie.currentHp += 10;


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
	public void setStats(int maxAmunition, float velocity, int maxHp, int invinvibleDuration, Faerie faerie) {
		faerie.velocity = 0.4f;
		faerie.setMaxHp(150);
		faerie.setMaxamunition(15);

	}

}

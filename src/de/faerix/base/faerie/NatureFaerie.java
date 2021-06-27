package de.faerix.base.faerie;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Ellipse;

public class NatureFaerie implements FaerieState {
	
	public NatureFaerie(Faerie faerie) {
		try {
			faerie.image = new Image("assets/naturefaerie.png").getScaledCopy(68, 65);
			faerie.leftWings = new Image("assets/left_wing_nature.png").getScaledCopy(150, 150);
			faerie.rightWings = new Image("assets/right_wing_nature.png").getScaledCopy(150, 150);
			faerie.sparkleImage = new Image("assets/faerie/basic_sparkle.png", new Color(255,255,255,0.5f));
			this.setStats(10, 0.5f, 100, 1, faerie);
			//this.setStats(faerie);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void autoattack(Faerie faerie) {
		// TODO Auto-generated method stub
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
	public void setStats(int maxAmunition, float velocity, int maxHp, int invinvibleDuration, Faerie faerie) {
		faerie.velocity = 0.4f;
		faerie.setMaxHp(150);
		faerie.setMaxamunition(15); 
		
	}

}

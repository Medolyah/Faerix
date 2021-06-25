package de.faerix.base.faerie;

import org.newdawn.slick.AppletGameContainer.Container;
import org.newdawn.slick.geom.Ellipse;

import de.faerix.base.enums.Direction;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class BasicFaerie implements FaerieState {
	
	public BasicFaerie(Faerie faerie) {
		try {
			faerie.image = new Image("assets/faerie.png").getScaledCopy(68, 65);;
			faerie.leftWings = new Image("assets/left_wing_water.png").getScaledCopy(150, 150);
			faerie.rightWings = new Image("assets/right_wing_water.png").getScaledCopy(150, 150);
			faerie.sparkleImage = new Image("assets/faerie/basic_sparkle.png");

			
			this.setStats(faerie);
			
			
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	Image aaImg;
	@Override
	public void autoattack(Faerie faerie) {
		if(faerie.amunition > 0 ) {
			System.out.print(faerie.direction);
			AttackSparkle aa = new AttackSparkle(new Ellipse(faerie.xPosition, faerie.yPosition, 5, 5),
					(float)0.6, (float)600, faerie.sparkleImage, faerie.direction);
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
		faerie.setMaxamunition(10); 
	}

}

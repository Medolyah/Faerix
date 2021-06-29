package de.faerix.base.faerie;

import org.newdawn.slick.AppletGameContainer.Container;
import org.newdawn.slick.geom.Ellipse;

import de.faerix.base.enums.Direction;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class BasicFaerie implements FaerieState {
	
	public BasicFaerie(Faerie faerie) {
		try {
			faerie.image = new Image("assets/faerie/faerie.png").getScaledCopy(68, 65);;
			faerie.leftWings = new Image("assets/faerie/left_wing_water.png").getScaledCopy(150, 150);
			faerie.rightWings = new Image("assets/faerie/right_wing_water.png").getScaledCopy(150, 150);
			faerie.sparkleImage = new Image("assets/faerie/basic_sparkle.png");
			faerie.color = new Color(255f, 255f, 255f, 0.2f);
			
			this.setStats(10, 0.5f, 50, 1, faerie);
			
			
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	Image aaImg;
	@Override
	public void autoattack(Faerie faerie) {
		if(faerie.amunition > 0 ) {
			AttackSparkle aa;
			try {
				aa = new AttackSparkle(new Ellipse(faerie.xPosition, faerie.yPosition, 5, 10),
						(float)0.6, (float)600, faerie.sparkleImage, faerie.direction, new Sound("assets/sound/faerie/firespell.wav"), 5);
				faerie.shotAutoattacks.add(aa);
				aa.shoot(faerie.xPosition, faerie.yPosition);
				faerie.amunition--;
			} catch (SlickException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	public void setStats(int maxAmunition, float velocity, int maxHp, int invinvibleDuration, Faerie faerie) {
		faerie.velocity = 0.5f;
		faerie.setMaxHp(maxHp);
		faerie.setMaxamunition(10); 
	}

}

package de.faerix.base.faerie;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.geom.Ellipse;

import de.faerix.base.enums.Direction;



public class WitchFaerie implements FaerieState {
	
	private Sound sound; 
	public WitchFaerie(Faerie faerie) {
		try {
			faerie.image = new Image("assets/faerie/witchfaerie.png").getScaledCopy(68, 65);
			faerie.leftWings = new Image("assets/faerie/left_wing_witch.png").getScaledCopy(150, 150);
			faerie.rightWings = new Image("assets/faerie/right_wing_witch.png").getScaledCopy(150, 150);
			faerie.sparkleImage = new Image("assets/faerie/witch_sparkle.png", new Color(255,255,255,0.5f));
			this.setStats(15, 0.9f, 200, 1000, faerie);
			this.sound = new Sound("assets/sound/faerie/witch.wav");
			faerie.color = new Color(188, 151, 222, 0.2f);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	@Override
	    public void autoattack(Faerie faerie) {
	        Direction[] directions = {Direction.South, Direction.SouthWest, Direction.SouthEast};
	        if(faerie.amunition > 2 ) {
	            for(int i = 0; i<3; i++) {
	                AttackSparkle aa = new AttackSparkle(new Ellipse(faerie.xPosition, faerie.yPosition, 5, 15),
	                        (float)0.6, (float)900, faerie.sparkleImage, directions[i], this.sound, 3);
	                faerie.shotAutoattacks.add(aa);
	                aa.shoot(faerie.xPosition, faerie.yPosition);
	                faerie.amunition--;
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
	public void setStats(int maxAmunition, float velocity, int maxHp, int invinvibleDuration, Faerie faerie){
		faerie.velocity = 0.4f;
		faerie.setMaxHp(150);
		faerie.setMaxamunition(15); 
	}

}

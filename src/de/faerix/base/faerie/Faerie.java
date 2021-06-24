package de.faerix.base.faerie;

import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Ellipse;

import de.faerix.base.Spielobjekt;
import de.faerix.base.enums.StoneEnum;


public class Faerie extends Spielobjekt{
	Image image, leftWings, rightWings; 
	Image sparkleImage; 
	public Ellipse ellipse; 
	float yPosition = 200;
	float xPosition = 200; 
	private float[] fallingSparkX = new float[50];
	private float[] fallingSparkY = new float[50];
	private int[] stopping = new int[50];
	Image[] sparkles = new Image[50];
	public FaerieState form;
	private boolean isLeftSide; 
	private boolean isSideWays; 
	int maxHp;
	public int currentHp = 50;
	
	public Faerie() {
		this.form = new BasicFaerie(this);
		this.ellipse = new Ellipse(this.xPosition, this.yPosition, 25, 25);
		Random random = new Random();
		for(int i = 0; i <50; i++) {
			this.fallingSparkX[i]=this.xPosition - 25 + (float)random.nextInt(50);
			this.fallingSparkY[i]=this.yPosition - 25 + (float)random.nextInt(50);
			this.stopping[i] = 30 + (int)random.nextInt(25);
		}
//		this.sparkle();
	
	}
	

	public void drawImage(Graphics g) {
		if(isLeftSide || !isSideWays)  g.drawImage(this.leftWings, this.xPosition-85, this.yPosition-85);
		if(!isLeftSide || !isSideWays) {g.drawImage(this.rightWings, this.xPosition-75, this.yPosition-85);}
		g.drawImage(this.image, this.xPosition-32, this.yPosition-28);
	    
	}
	
	public void updateImage() {
		
	}
	
	public void fall() {
		for (int i = 0; i< 50 ; i++) {
			Random random = new Random();
			if(this.fallingSparkY[i] > this.yPosition+this.stopping[i]) {
				this.fallingSparkY[i] = this.yPosition - 10 + (float)random.nextInt(20);
				this.fallingSparkX[i] = this.xPosition - 25 + (float)random.nextInt(50);
			}
			this.fallingSparkY[i] += random.nextFloat();
			this.fallingSparkX[i] +=  - 1 + (float)random.nextInt(3);
		}

	}
	

	public void moveX(int xMove) {
		isSideWays = true;
		if(xMove > 0) {
			this.isLeftSide = true;
		}
		else {
			this.isLeftSide =false;
		}
		this.xPosition += (float)(xMove*0.5);
		this.ellipse.setCenterX(this.xPosition);
		
	}
	
	public void moveY( int yMove) {
		isSideWays = false;
		if(yMove>0) {
			this.yPosition += yMove*0.6;
		}else {
			this.yPosition += yMove *0.5;			
		}
		this.ellipse.setCenterY(this.yPosition);			
	}
	
	@Override
	public void update( int delta) {
	this.fall();
	}
	
	@Override
	public void render(Graphics g) {
		this.form.setSparkleColor(this, g);
		this.renderSparkle(g);
		g.fill(this.ellipse);
		this.drawImage(g);
	}
	
	public void collectSphere(StoneEnum stone) {
		switch(stone) {
		case BLUE:
			this.form.collectWaterStone(this);
			break;
		case YELLOW:
			this.form.collectStarStone(this);
			break;
		case RED:
			this.form.collectFireStone(this);
			break;
		}

	}
	
	public void renderSparkle(Graphics g) {
		for (int i = 0; i< 50 ; i++) {
			int size = 1 + (int) (Math.random() * ((15-1)));
			g.drawImage(this.sparkleImage.getScaledCopy(size, size), this.fallingSparkX[i], this.fallingSparkY[i]);
		}
	}


	public void takeDamage() {
		this.currentHp += -1; 
		
	}
}

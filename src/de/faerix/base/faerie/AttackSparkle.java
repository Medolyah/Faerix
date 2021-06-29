package de.faerix.base.faerie;

import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Sound;
import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Shape;

import de.faerix.base.GameObject;
import de.faerix.base.enums.Direction;

public class AttackSparkle extends GameObject{
	
	public Shape shape;
	float xPos;
	float yPos;
	float speed;
	Image img; 
	boolean isAttack;
    public boolean hasHitEnemy;
	float rangeX; 
	float rangeY;
	boolean isDead = false;
	private int yDirection;
	private int xDirection; 
	private Direction direction; 
	public int damage = 10;
	private Sound sound;
	
	
	
	//sparkles
	private float[] fallingSparkX = new float[10];
	private float[] fallingSparkY = new float[10];
	private int[] stopping = new int[10];
	
	
	public AttackSparkle(Shape shape, float speed, float range,  Image img, Direction direction, Sound sound, int damage) {
		this.speed = speed;
		this.isAttack = false; 
		this.rangeY = range;
		this.rangeX = range;
		this.yDirection = this.getYDirection(direction);
		this.xDirection = this.getXDirection(direction); 
		this.direction = direction;
		this.shape = shape;
		this.img = img.getScaledCopy((int)shape.getWidth()*2, (int)shape.getHeight()*2);
		this.sound = sound;		
		this.damage = damage;
	}
	
	


	public void shoot(float xPos, float yPos) {
		this.sound.play();
		this.isAttack = true;
		this.xPos = xPos;
		this.yPos = yPos;
		this.rangeY = this.getYRange(yPos);
		this.rangeX = this.getXRange(xPos);
		this.initSparkles();
	}
	
	
	
	public void update(int delta) {
		if(isAttack) {
			if(this.isInXRange(xPos) &&this.isInYRange(yPos)) {
				shape.setCenterX(this.xPos);
				shape.setCenterY(this.yPos);
				this.xPos += (this.xDirection*this.speed);	
				this.yPos += (this.yDirection*this.speed);	
				this.sparkle();
			}
			else {
				this.isDead = true; 
			}
			if(this.hasHitEnemy) {
				this.yPos+= (1*(this.speed*2));
				shape.setCenterY(this.yPos);
				shape.setCenterX(this.xPos);
				this.xPos += (0.02*this.speed);	
			}
		}
	}
	
	
	

	

	
	public void render(Graphics g) {
		if(isAttack && !isDead) {
			g.fill(shape);
			g.drawImage(img, this.xPos-shape.getWidth(), this.yPos-shape.getHeight());
			
			for (int i = 0; i < 10; i++) {
				int size = 1 + (int) (Math.random() * ((15 - 1)));
				g.drawImage(this.img.getScaledCopy(size, size), this.fallingSparkX[i], this.fallingSparkY[i]);
			}
		}
	}
	
	

	
	// Directions
	private float getYRange(float yPos) {
		if(direction == Direction.North || direction == Direction.NorthWest || direction == Direction.NorthEast) {
			return yPos-this.rangeY;
		}
		else return yPos + this.rangeY;
	}	
	
	private float getXRange(float xPos) {
		if(direction == Direction.West || direction == Direction.NorthWest || direction == Direction.SouthWest) {
			return xPos-this.rangeX;
		}
		else return xPos + this.rangeX;
	}
	
	private boolean isInYRange(float yPos) {
		if(direction == Direction.North || direction == Direction.NorthWest || direction == Direction.NorthEast) {
			return yPos >= this.rangeY;
		}
		else return yPos <= this.rangeY;
	}	
	
	
	private boolean isInXRange(float xPos) {
		if(direction == Direction.West || direction == Direction.NorthWest || direction == Direction.SouthWest) {
			return xPos >= this.rangeX;
		}
		else return xPos <= this.rangeX;
	}
	
	private int getXDirection(Direction direction) {
		if(direction == Direction.South || direction == Direction.North) return 0;
		else {
			if(direction == Direction.West || direction ==Direction.SouthWest || direction ==Direction.NorthWest) return -1;
			else return +1;
		}
	}
	
	private int getYDirection(Direction direction) {
		if(direction == Direction.West || direction == Direction.East) return 0;
		else {
			if(direction == Direction.North || direction == Direction.NorthWest || direction == Direction.NorthEast) return -1;
			else return +1;
		}
	}
	
	//SPARKLE
	
	public void initSparkles(){
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			this.fallingSparkX[i] = this.xPos - 25 + (float) random.nextInt(10);
			this.fallingSparkY[i] = this.yPos - 25 + (float) random.nextInt(10);
			this.stopping[i] = 10 + (int) random.nextInt(25);
		}
		
	}
	public void sparkle(){
		for (int i = 0; i < 10; i++) {
			Random random = new Random();
			if (this.fallingSparkY[i] > this.yPos + this.stopping[i]) {
				this.fallingSparkY[i] = this.yPos - (float) random.nextInt(20);
				this.fallingSparkX[i] = this.xPos + (float) random.nextInt(10);
			}
			this.fallingSparkY[i] += random.nextFloat();
			this.fallingSparkX[i] += -1 + (float) random.nextInt(3);
		}
	}

}

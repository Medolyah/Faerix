package de.faerix.base.faerie;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Ellipse;

import de.faerix.base.GameObject;
import de.faerix.base.enums.Direction;
import de.faerix.base.enums.StoneEnum;
import gamehub.EnergyObserver;
import gamehub.Subject;

public class Faerie extends GameObject {
	Image image, leftWings, rightWings;
	Image sparkleImage;
	public Ellipse ellipse;
	public float yPosition = 200;
	public float xPosition = 200;
	private float[] fallingSparkX = new float[50];
	private float[] fallingSparkY = new float[50];
	private int[] stopping = new int[50];
	Image[] sparkles = new Image[50];
	public FaerieState form;
	Direction direction;
	public int maxHp = 5000;
	public int currentHp = 5000;
	public int amunition = 5;
	public int maxAmunition = 5;
	public float velocity;
	public Deque<AttackSparkle> shotAutoattacks = new ArrayDeque<AttackSparkle>();
	private boolean invincible;
	public int invincibleDuration = 2000;
	private int invincibleTimer = 0; 

	public Faerie() {
		this.form = new BasicFaerie(this);
		this.ellipse = new Ellipse(this.xPosition, this.yPosition, 25, 25);
		Random random = new Random();
		this.direction = Direction.East;
		for (int i = 0; i < 50; i++) {
			this.fallingSparkX[i] = this.xPosition - 25 + (float) random.nextInt(50);
			this.fallingSparkY[i] = this.yPosition - 25 + (float) random.nextInt(50);
			this.stopping[i] = 30 + (int) random.nextInt(25);
		}
//		this.sparkle();

	}

	public void drawImage(Graphics g) {
		if (direction == Direction.South || direction == Direction.North || direction == Direction.East)
			g.drawImage(this.leftWings, this.xPosition - 85, this.yPosition - 85);
		if (direction == Direction.South || direction == Direction.North || direction == Direction.West) {
			g.drawImage(this.rightWings, this.xPosition - 75, this.yPosition - 85);
		}
		g.drawImage(this.image, this.xPosition - 32, this.yPosition - 28);

	}

	public void updateImage() {

	}

	public void fall() {
		for (int i = 0; i < 50; i++) {
			Random random = new Random();
			if (this.fallingSparkY[i] > this.yPosition + this.stopping[i]) {
				this.fallingSparkY[i] = this.yPosition - 10 + (float) random.nextInt(20);
				this.fallingSparkX[i] = this.xPosition - 25 + (float) random.nextInt(50);
			}
			this.fallingSparkY[i] += random.nextFloat();
			this.fallingSparkX[i] += -1 + (float) random.nextInt(3);
		}

	}

	public void moveX(int xMove) {
		if (xMove > 0) {
			direction = Direction.East;
		} else {
			direction = Direction.West;
		}
		this.xPosition += (float) (xMove * this.velocity);
		this.ellipse.setCenterX(this.xPosition);

	}

	public void moveY(int yMove) {
		if (yMove > 0) {
			direction = Direction.South;
			this.yPosition += yMove * (this.velocity - 0.1f);
		} else {
			direction = Direction.North;
			this.yPosition += yMove * this.velocity;
		}
		this.ellipse.setCenterY(this.yPosition);
	}

	@Override
	public void update(int delta) {
		this.fall();
		this.updateAutoattacks(delta);
		
//		if(this.invincibleTimer > 500) {
//			try {
//				this.image = new Image("assets/faerie.png").getScaledCopy(68, 65);
//			} catch (SlickException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			};
//		}
		this.invincibleTimer++; 
		if(this.invincibleDuration < this.invincibleTimer) {
			this.invincible = false;
		}
	}



	public void updateAutoattacks(int delta) {
		for (AttackSparkle aa : this.shotAutoattacks) {
			if (aa.isDead) {
				this.shotAutoattacks.remove();
				if (this.amunition <= this.maxAmunition) {
					this.amunition++;
				}
			} else {
				aa.update(delta);
			}
		}
	}

	public void collectSphere(StoneEnum stone) {
		switch (stone) {
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



	public void takeDamage(int hp){
		if(!this.invincible) {
			this.currentHp -= hp;
			this.invincible = true; 
			this.invincibleTimer = 0; 
//			try {
//				this.image = new Image("assets/firefaerie.png").getScaledCopy(68, 65);
//			} catch (SlickException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}

	public void autoattack() {
		this.form.autoattack(this);
	}

	public void setMaxamunition(int i) {
		this.maxAmunition = i;
		this.amunition = i;
	}
	
	public void setMaxHp(int i) {
		this.maxHp = i;
		this.currentHp = i;
	}
	
	
	@Override
	public void render(Graphics g) {
		this.form.setSparkleColor(this, g);
		this.renderSparkle(g);
		g.setColor(Color.white);
		g.fill(this.ellipse);
		this.drawImage(g);
		this.renderAutoattacks(g);
	}

	public void renderAutoattacks(Graphics g) {
		for (AttackSparkle aa : this.shotAutoattacks) {
			aa.render(g);

		}
	}
	
	public void renderSparkle(Graphics g) {
		for (int i = 0; i < 50; i++) {
			int size = 1 + (int) (Math.random() * ((15 - 1)));
			g.drawImage(this.sparkleImage.getScaledCopy(size, size), this.fallingSparkX[i], this.fallingSparkY[i]);
		}
	}
}

package map_objects;

import java.util.List;
import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Ellipse;

import de.faerix.base.GameObject;
import de.faerix.base.enums.ContainerSize;

public class Enemy extends GameObject{
	public float xPos;
	public float yPos;
	public Image img;
	public Image damageImg; 
	public Image normalImg;
	public Ellipse shape; 
	public int size;
	public int maxHp;
	
	public boolean isDead = false;
	public boolean hasStone = false;
	public int hp; 
	
	
	public Enemy(int size) {
		Random random = new Random(); 
		this.xPos = (float)random.nextInt(ContainerSize.width.getNumVal());
		this.yPos = (float)random.nextInt(ContainerSize.height.getNumVal());
		this.shape = new Ellipse(this.xPos, this.yPos, size/4, size/4);
		this.size= size;
		this.maxHp = 50;
		
		try {
			this.damageImg = new Image("assets/map_objects/enemy_dmg.png").getScaledCopy(size, size);
			this.normalImg = new Image("assets/map_objects/enemy.png").getScaledCopy(size, size);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		if(random.nextInt(100) < 5) this.hasStone = true; 
	}
	
	public void move(float faerieX, float faerieY) {
		if(this.xPos - faerieX < 0) this.xPos += 1*0.02;
		else this.xPos -= 1*0.02;
		if(this.yPos - faerieY < 0 ) this.yPos += 1*0.02;			
		else this.yPos -= 1*0.02;
	}
	
	private int timer = 1001;
	public void takeDamage(int hp) {
		this.maxHp -= hp; 
		this.img = this.damageImg;
		this.timer++;
		if(this.maxHp <= 0 ) {
			this.isDead = true; 
		}
	}
	
	
	public void render(Graphics g) {
		g.setColor(Color.black);
		g.fill(shape);
		if(this.timer > 1000) {
			this.img = this.normalImg;
		}
		else {
			this.img = this.damageImg;
		}
		g.drawImage(this.img, this.xPos -size/2, this.yPos - size/2);
	}
	
	public void update(int delta) {
		this.shape.setCenterX(this.xPos);
		this.shape.setCenterY(this.yPos);
	}

}

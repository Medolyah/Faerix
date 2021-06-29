package map_objects;

import java.util.Random;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import de.faerix.base.GameObject;

public class Cloud extends GameObject{
	
	private float xPos;
	private float yPos; 
	private float velocity;
	private Image image; 
	private int direction;
	private int maxWidth;
	private int maxHeight; 
	
	public Cloud(float velocity, float xPos, float yPos, Image image, int direction, int maxWidth, int maxHeight) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.velocity = velocity;
		this.image = image;
		this.direction = direction;
		this.maxHeight = maxHeight;
		this.maxWidth = maxWidth; 
	}
	
	
	public void update(int delta) {
		if(this.xPos< -300) {
			this.xPos = this.maxWidth+300;
			this.yPos = this.getRandomYHeight(this.maxHeight); 
		}
		if(this.xPos > this.maxWidth+150) {
			this.xPos = -300;
			this.yPos = this.getRandomYHeight(this.maxHeight);
		}
		this.xPos += this.direction*delta*velocity; 
		
	}
	
	public void render(Graphics g) {
		g.drawImage(this.image, this.xPos, this.yPos);	
	}
	
	
	public static int getRandomYHeight(int maxHeight){
		Random random = new Random();
		return random.nextInt(maxHeight-50);	
	}
	

}

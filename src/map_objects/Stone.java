package map_objects;

import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Shape;

import de.faerix.base.GameObject;
import de.faerix.base.enums.StoneEnum;

public class Stone extends GameObject {
	float xPos;
	float yPos;
	public StoneEnum type;
	public Shape shape;
	public Image image;
	private int size = 50;

	public Stone(float xPos, float yPos) {
		this.type =  this.getType();
		this.xPos = xPos;
		this.yPos = yPos;
		this.shape = new Ellipse(this.xPos, this.yPos, (size-11)/2, (size-11)/2);
		this.setImage();

	}

	public void render(Graphics g) {
		g.setColor(this.getColor());
		g.fill(this.shape);
		g.drawImage(this.image, this.xPos-size/2, this.yPos-size/2);
	}

	public void update() {

	}

	private void setImage() {
		try {
			switch (this.type) {
			case RED:
				this.image = new Image("assets/map_objects/fire_stone.png").getScaledCopy(size, size);
				break;
			case BLUE:
				this.image = new Image("assets/map_objects/water_stone.png").getScaledCopy(size, size);
				break;
			case YELLOW:
				this.image = new Image("assets/map_objects/star_stone.png").getScaledCopy(size, size);
				break;
			}
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Color getColor() {
		switch (this.type) {
		default:
		case RED:
			return new Color(255f, 148f, 155f, 0.2f);
		case BLUE:
			return new Color(166f, 187f, 255f, 0.2f);
		case YELLOW:
			return new Color(255f, 247f, 179f, 0.2f);
		}
	}
	
	private StoneEnum getType() {
		Random random = new Random();
		StoneEnum[] stones = {StoneEnum.RED, StoneEnum.BLUE, StoneEnum.YELLOW};
		return stones[random.nextInt(3)];
		
	}
}

package gamehub;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import de.faerix.base.GameObject;

public class QButton extends GameObject{
	

	private boolean isPressed = true;
	private Image qButtonImg;
	private Image qPressedButtonImg;
	private Image button; 
	
	public QButton() throws SlickException {
		this.qButtonImg = new Image("assets/hub/qButton.png").getScaledCopy(150,150);
		this.qPressedButtonImg = new Image("assets/hub/qPressedButton.png").getScaledCopy(150,150);	
		this.button = this.qButtonImg;
	}
	
	public void update(int delta) {
		timer++;
		if(isPressed && timer > 250) {
			this.isPressed = false;
			this.button = this.qButtonImg;
		}
	}
	
	private int timer = 0; 
	public void pressQ(boolean pressed) {
		this.isPressed = pressed;
		this.button = this.qPressedButtonImg;
		this.timer = 0; 
	}
	
	public void render(Graphics g) {
			g.drawImage(this.button, 50,  900-200);			
	}
}

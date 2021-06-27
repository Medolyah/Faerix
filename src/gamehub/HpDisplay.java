package gamehub;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import de.faerix.base.GameObject;

public class HpDisplay extends GameObject {
	private static final int displayWidth = 1000;
	private static final int displayHeight = 150;
	private static final int gameWidth = 1500;
	private static final int  gameHeight = 900;
	
	
	public Image hub; 
	public float xPos;

	public Rectangle emptyHpBar;
	public Rectangle manaBar; 
	public Rectangle hpBar;
	public Rectangle emptyManaBar; 
	
	public int maxHpWidth;
	public int hpWidth; 
	
	public int maxManaWidth;
	public int manaWidth;
	
	public int manaDivider;
	public int hpDivider;
	
	public HpDisplay() throws SlickException {
		this.hub = new Image("assets/hub/displayImg.png").getScaledCopy(displayWidth,displayHeight);
		this.initBars(); 
	}
	
	public void setManaDivider(int manaDivider){
		this.manaDivider = manaDivider;
	}
	
	public void setHpDivider(int hpDivider){
		this.hpDivider = hpDivider;
	}
	
	public void update(int delta) {
		this.hpBar.setWidth(this.hpWidth);
		this.manaBar.setWidth(this.manaWidth);
	}
	
	public void setHp(int hp){
		this.hpWidth = this.maxHpWidth * hp / this.hpDivider;
		if(this.hpWidth < 0 ) this.hpWidth = 0;
	}
	
	public void setMana(int mana) {
		this.manaWidth = this.maxManaWidth * mana / this.manaDivider;
		if(this.manaWidth < 0 ) this.manaWidth = 0;
	}
	
	public void initBars(){
		this.maxHpWidth = 871; 
		this.hpWidth = this.maxHpWidth;
		
		this.maxManaWidth = 871;
		this.manaWidth = this.maxManaWidth;
		
		int x = 319;
		int hpY = 750;
		int hpHeight= 50;
		int manaY = hpY +50;
		
		this.hpBar = new Rectangle(x, hpY, this.hpWidth, hpHeight);
		this.emptyHpBar = new Rectangle(x, hpY, 871, hpHeight);
		this.manaBar = new Rectangle(x, manaY , this.manaWidth, 20);
		this.emptyManaBar = new Rectangle(x, manaY , 871, 20);
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white.darker(0.2f));
		g.fill(this.emptyHpBar);
		
		g.setColor(Color.white);
		g.fill(this.hpBar);
		
		g.setColor(new Color(163, 227, 240).darker(0.2f));
		g.fill(this.emptyManaBar);
		
		g.setColor(new Color(163, 227, 240));
		g.fill(this.manaBar);
		
		g.drawImage(this.hub, (gameWidth - displayWidth) / 2, (gameHeight - (displayHeight +50)));
	}
}

package de.faerix.base.stages;

import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameOver extends BasicGameState {

	GameOver play;
	Image background;
	Music bgMusic;
	private Shape[] circles = new Shape[30];
	private float[] xPositions = new float[30];
	private float[] yPositions = new float[30];
	private float width = 10;
	private float[] factors = new float[30];

	public GameOver(int state) {

	}

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		// bgMusic = new Music("testdata/sound/Death_Note_achtig.ogg");
		// bgMusic.loop();
		background = new Image("assets/game_over.png").getScaledCopy(container.getWidth(), container.getHeight());
		this.play = new GameOver(14);

		Random random = new Random();
		for (int i = 0; i < 30; i++) {
			int width = 10 * (i/10 + 1);
			xPositions[i] = random.nextInt(container.getWidth() - width);
			yPositions[i] = random.nextInt(container.getHeight()-500);
			factors[i] = 1;
			Ellipse circle = new Ellipse(xPositions[i], yPositions[i], width, width);
			circles[i] = circle;
		}
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		g.setColor(new Color(1f, 0f, 0f, 0.2f));
		for (Shape circle : this.circles) {
			g.fill(circle);
		}
		background.draw();

	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		Random random = new Random();
		for (int i = 0; i < 30; i++) {
			yPositions[i] += factors[i] * ((i + 1) * 0.015);
			circles[i].setCenterY(yPositions[i]);
			circles[i].setCenterX(xPositions[i]);
			if (yPositions[i] >= container.getHeight()) {
				yPositions[i] = 0;
				xPositions[i] = random.nextInt((int) container.getWidth() - (int) circles[i].getWidth());
			}
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 14;
	}

}

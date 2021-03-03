package de.faerix.base;

import java.util.Random;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class test extends BasicGame {

	public faerie faerie;

	public test() {
		super("Hallo World");
	}

	public static void main(String[] args) throws SlickException {
		AppGameContainer container = new AppGameContainer(new test());
		container.setDisplayMode(1500, 900, false);
		container.start();
		container.setMinimumLogicUpdateInterval(1000);
		container.setMaximumLogicUpdateInterval(1000);
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		this.faerie.render(g);

	}

	@Override
	public void init(GameContainer container) throws SlickException {
		this.faerie = new faerie();
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		Input input = container.getInput();
		this.faerie.update(delta);

		// Maus Taste1 abfragen und auf Kollision mit Oval testen
		if (input.isKeyPressed(Input.KEY_ESCAPE)) {
			container.exit();
		} else if (input.isKeyDown(Input.KEY_UP)) {
			this.faerie.moveY(-1);
		} else if (input.isKeyDown(Input.KEY_DOWN)) {
			this.faerie.moveY(1);
		} else if (input.isKeyDown(Input.KEY_RIGHT)) {
			this.faerie.moveX(+1);
		} else if (input.isKeyDown(Input.KEY_LEFT)) {
			this.faerie.moveX(-1);
		}
	}
}
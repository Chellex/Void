package dearden.voidspace.systems;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import dearden.voidspace.entities.EntityHandler;

public class Game extends BasicGame {

	EntityHandler entityHandler;
	SystemRender systemRender;
	
	public Game(String gamename) {
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) 
	throws SlickException {
		entityHandler = new EntityHandler();
		systemRender = new SystemRender();
	}

	@Override
	public void update(GameContainer gc, int delta) 
	throws SlickException {
		
	}

	public void render(GameContainer gc, Graphics g) 
	throws SlickException {
		systemRender.render(gc, g, entityHandler.entityDB);
	}

	public static void main(String[] args) {
		try {
			AppGameContainer appgc;
			appgc = new AppGameContainer(new Game("Simple Slick Game"));
			appgc.setDisplayMode(640, 480, false);
			appgc.start();
		} catch (SlickException ex) {
			Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}

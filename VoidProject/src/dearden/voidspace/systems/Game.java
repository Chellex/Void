package dearden.voidspace.systems;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import dearden.voidspace.entities.EntityHandler;
import dearden.voidspace.entities.components.ComponentHandler;

public class Game extends BasicGame {
	
	public static final float TICK = 16.66f;
	
	SystemRender systemRender;
	SystemMotion systemMotion;
	SystemControl systemControl;
	ComponentHandler componentHandler;
	EntityHandler entityHandler;
	
	
	public Game(String gamename) {
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) 
	throws SlickException {
		systemRender = new SystemRender();
		systemRender.init();
		systemMotion = new SystemMotion(); 
		systemControl = new SystemControl();
		componentHandler = new ComponentHandler();
		componentHandler.init();
		entityHandler = new EntityHandler(gc);
	}

	@Override
	public void update(GameContainer gc, int delta) 
	throws SlickException {
		systemRender.update(gc, delta, entityHandler.entityDB);
		systemControl.update(gc, delta, entityHandler.entityDB);
		systemMotion.update(gc, delta, entityHandler.entityDB);
	}

	public void render(GameContainer gc, Graphics g)
	throws SlickException {
		systemRender.render(gc, g, entityHandler.entityDB);
	}

	public static void main(String[] args) {
		
		System.setProperty("org.lwjgl.librarypath", new File("natives/").getAbsolutePath());
		
		try {
			AppGameContainer appgc;
			appgc = new AppGameContainer(new Game("Logan is cool. I guess..."));
			appgc.setDisplayMode(640, 480, false);
			//appgc.setTargetFrameRate(60);
			appgc.start();
		} catch (SlickException ex) {
			Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}

package dearden.voidspace.entities.components;

import java.io.File;
import java.io.IOException;

import dearden.voidspace.systems.SystemRender;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.particles.ConfigurableEmitter;
import org.newdawn.slick.particles.ConfigurableEmitter.Range;
import org.newdawn.slick.particles.Particle;
import org.newdawn.slick.particles.ParticleEmitter;
import org.newdawn.slick.particles.ParticleIO;

public class ComponentParticle extends Component {

	/*
	 * Fields start.
	 */
	private ConfigurableEmitter emitter;
	
	public ComponentParticle(String particleDir){
		this.type = ComponentType.PARTICLE;
		
		try{
			File emitterFile = new File(particleDir);
			emitter = ParticleIO.loadEmitter(emitterFile);
		}catch(IOException e){
			System.err.println("The Emitter could not be loaded! " + particleDir);
			System.exit(1);
		}
		emitter.setPosition(100, 100);
		SystemRender.particleSystem.addEmitter(emitter);
	}
	
	/*
	 * Functions start.
	 */
	public void update(GameContainer gc, int delta){
		emitter.setPosition(parent.getCenterXMidpoint() + 4, parent.getCenterYMidpoint()+ 10, false);
	}
	
	@Override
	public void handleMessage(ComponentType type, String message) {
		
	}

	@Override
	public void cleanUp() {
		// TODO
	}
	
	/*
	 * GET Functions start.
	 */
	public ConfigurableEmitter getEmitter(){
		return emitter;
	}
}

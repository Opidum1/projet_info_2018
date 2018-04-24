package GameObject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Jeu.Handleur;
import affichage.Animation;
import affichage.Assets;

public class Player extends Creatures {
	
	
	//Animations
	private Animation animDown;
	private Animation animUp;
	private Animation animLeft;
	private Animation animRight;

	public Player(Handleur handler,float x,float y) {
		super(handler, x,y, Creatures.DEFAULT_CREATURE_LARGEUR, Creatures.DEFAULT_CREATURE_HAUTEUR);
		
		bounds.x = 21;
		bounds.y = 26;
		bounds.width = 22;
		bounds.height = 31;
	
		
		//Animations
		animDown = new Animation(500, Assets.player_down);
		animUp = new Animation(500, Assets.player_up);
		animLeft = new Animation(500, Assets.player_left);
		animRight = new Animation(500, Assets.player_right);
		
	}

	@Override
	public void update() {
		//Animations
		animDown.update();
		animUp.update();
		animRight.update();
		animLeft.update();
		
		//Movement
		getInput();
		move();
		handler.getGameCamera().CenterOneEntity(this);
	}

	private void getInput() {
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyboard().isUp())
			yMove = -speed;
		if(handler.getKeyboard().isDown())
			yMove = speed;
		if(handler.getKeyboard().isLeft())
			xMove = -speed;
		if(handler.getKeyboard().isRight())
			xMove = speed;
	}
	
	@Override
	public void notifyView(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int)(x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()), largeur, hauteur,  null);
		
		//g.setColor(Color.red);
		//g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
			//(int) (y + bounds.y - handler.getGameCamera().getyOffset()),
					//	bounds.width, bounds.height);
	
	}
	
	private BufferedImage getCurrentAnimationFrame() {
		if(xMove < 0) {
			return animLeft.getCurrentFrame();
		}else if(xMove > 0) {
			return animRight.getCurrentFrame();
		}else if(yMove < 0) {
			return animUp.getCurrentFrame();
		}else {
			return animDown.getCurrentFrame();
		}

	}


}

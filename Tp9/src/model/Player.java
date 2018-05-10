package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import view.Sheets;
import view.Window;

public class Player extends Creatures {
	
	
	//private int posX;
	//private int posY;
	public Window window;
	public Game game;
	private Graphics g;
	// PARTIE TIMER
	
	private long lastTime;
	private long timer;
	
	private long lastTime2;
	private long timer2;
	

	
	private Rectangle porté;
	private Rectangle coliRec;
	private int range;
	
	private boolean isAttacking;
	
	
	
	public Player(Game game, float posX, float posY) {
		super(game,posX,posY);
		this.game = game;
		this.posX = posX;
		this.posY = posY;
		isMoving = true;
		isPlayerMovable = true;
		lastTime = 800;
		timer = 0;

		
		// GESTION DES COLLISIONS
		
		 collisionRec.x = 21;
		 collisionRec.y = 26;
		 collisionRec.width = 22;
		 collisionRec.height = 31;
		
	//	collisionRec = new Rectangle(collisionRec_x,collisionRec_y,collisionRec_width,collisionRec_height);
		

	
	}

	

	
	
	
	public void mort() {
		
	}
	
	public void dmgAnim() {
		
	}
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public float getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public float getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public void getInput() {
		xMove =0;
		yMove =0;
		
		if(isPlayerMovable) {
			if(game.getKeyboard().isHaut())
				yMove = -VITESSE_CREATURE;
			if(game.getKeyboard().isBas())
				yMove = VITESSE_CREATURE;
			if(game.getKeyboard().isGauche())
				xMove = -VITESSE_CREATURE;
			if(game.getKeyboard().isDroite())
				xMove = VITESSE_CREATURE;
		}
		}
	

	public void update() {
		//System.out.println(isMoving);
		getInput();
		move();
		collisionObjet();
		game.getCamera().centerPlayer(this);  // PERMET DE CENTRER LA CAM SUR LE PLAYER
	
		hit();
		
		
		
		//TEST
	//	System.out.println(game.getCamera().getDecalage_x());
	}
	
	// GESTION DES DEGATS 
	
	public void hit() {
		timer += System.currentTimeMillis() - lastTime;   // nous donne le temps passé avant entre le dernier update et maintenant
		lastTime = System.currentTimeMillis();


		if(timer < 500) {
			isAttacking = false;
			return;
		}


		coliRec = getCollisionRec(this,0,0);
		porté = new Rectangle();
		
		range = 20;
		
		porté.width = range;
		porté.height = range;
		
		if(game.getKeyboard().isAttaque_haut()) {
			porté.x = coliRec.x + coliRec.width / 2 - range / 2;
			porté.y = coliRec.y - range / 2;
			isAttacking = true;
			g.setColor(Color.BLACK);
			g.fillRect((int) (porté.x - game.getCamera().getDecalage_x()), (int) (porté.y - game.getCamera().getDecalage_y()), porté.width, porté.height);
		}else 		if(game.getKeyboard().isAttaque_bas()) {
			porté.x = coliRec.x + coliRec.width / 2 - range / 2;
			porté.y = coliRec.y + coliRec.height;
			isAttacking = true;
		}else 		if(game.getKeyboard().isAttaque_gauche()) {
			porté.x = coliRec.x +  - range / 2;
			porté.y = coliRec.y;
			isAttacking = true;
		}else 		if(game.getKeyboard().isAttaque_droite()) {
			porté.x = coliRec.x + coliRec.width;
			porté.y = coliRec.y;
			isAttacking = true;
		}else {
			return;
		}
	
		timer = 0;
		
		
		for(Creatures c :game.getInGame().getPnjList().getPnj()) {
			if(c.equals(this))
				continue;
			
			if(c.getCollisionRec(c, 0, 0).intersects(porté)){
				c.degat(1);
				System.out.println(c.hp);
				return;
			}
		
		}
		System.out.println("Attack");
		
	}
	
	
	public void collisionObjet() {
		
		for(Objets o : game.getInGame().getItems_list().getItems_list()) {
			if(this.getCollisionRec(this,0,0).intersects(o.getCollisionRec(o))){
				o.ramassé();
			}
		}
	}
	
	
	public void notifyView(Graphics g) {
		this.g = g;
		g.drawImage(Sheets.getPlayer(),(int)(posX - game.getCamera().getDecalage_x()),(int)(posY - game.getCamera().getDecalage_y()),LARGEUR_CREATURE,HAUTEUR_CREATURE,null);
		

		// TEST
		if(isAttacking) {
			g.setColor(Color.BLACK);
			g.drawImage(Sheets.getBois(),(int) (porté.x - game.getCamera().getDecalage_x()), (int) (porté.y - game.getCamera().getDecalage_y()), porté.width, porté.height,null);
		}

}


	@Override
	public Rectangle getCollisionRec(Objets c) {
		// TODO Auto-generated method stub
		return null;
	}







			}

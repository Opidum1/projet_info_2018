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
	
	// PARTIE TIMER
	
	private long lastTime;
	private long timer;
	
	private Rectangle porté;
	
	
	
	
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
			return;
		}

		Rectangle coliRec = getCollisionRec(this,0,0);
		Rectangle porté = new Rectangle();
		
		int range = 20;
		
		porté.width = range;
		porté.height = range;
		
		if(game.getKeyboard().isAttaque_haut()) {
			porté.x = coliRec.x + coliRec.width / 2 - range / 2;
			porté.y = coliRec.y - range / 2;
			game.getG().setColor(Color.BLACK);
			game.getG().fillRect(porté.x, porté.y, porté.width, porté.height);
			System.out.println(porté.x);
		}else 		if(game.getKeyboard().isAttaque_bas()) {
			porté.x = coliRec.x + coliRec.width / 2 - range / 2;
			porté.y = coliRec.y + coliRec.height;
		}else 		if(game.getKeyboard().isAttaque_gauche()) {
			porté.x = coliRec.x +  - range / 2;
			porté.y = coliRec.y;
		}else 		if(game.getKeyboard().isAttaque_droite()) {
			porté.x = coliRec.x + coliRec.width;
			porté.y = coliRec.y;
		}else {
			return;
		}
	
		timer = 0;
		game.getG().setColor(Color.BLACK);
		game.getG().fillRect(porté.x, porté.y, porté.width, porté.height);
		
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
	
	public void notifyView(Graphics g) {
		g.drawImage(Sheets.getPlayer(),(int)(posX - game.getCamera().getDecalage_x()),(int)(posY - game.getCamera().getDecalage_y()),LARGEUR_CREATURE,HAUTEUR_CREATURE,null);
		
		Rectangle coliRec = getCollisionRec(this,0,0);
		Rectangle porté = new Rectangle();
		
		int range = 20;
		
		porté.width = range;
		porté.height = range;
		
		if(game.getKeyboard().isAttaque_haut()) {
			porté.x = coliRec.x + coliRec.width / 2 - range / 2;
			porté.y = coliRec.y - range / 2;
			g.setColor(Color.BLACK);
			g.fillRect((int)(porté.x - game.getCamera().getDecalage_x()),(int) (porté.y - game.getCamera().getDecalage_y()), porté.width, porté.height);
		}else 		if(game.getKeyboard().isAttaque_bas()) {
			porté.x = coliRec.x + coliRec.width / 2 - range / 2;
			porté.y = coliRec.y + coliRec.height;
			g.fillRect((int)(porté.x - game.getCamera().getDecalage_x()),(int) (porté.y - game.getCamera().getDecalage_y()), porté.width, porté.height);

		}else 		if(game.getKeyboard().isAttaque_gauche()) {
			porté.x = coliRec.x +  - range / 2;
			porté.y = coliRec.y;
			g.fillRect((int)(porté.x - game.getCamera().getDecalage_x()),(int) (porté.y - game.getCamera().getDecalage_y()), porté.width, porté.height);

		}else 		if(game.getKeyboard().isAttaque_droite()) {
			porté.x = coliRec.x + coliRec.width;
			porté.y = coliRec.y;
			g.fillRect((int)(porté.x - game.getCamera().getDecalage_x()),(int) (porté.y - game.getCamera().getDecalage_y()), porté.width, porté.height);

		}else {
			return;
		}

}}

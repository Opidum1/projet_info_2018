package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


import view.Animation;
import view.Sheets;
import view.Window;

public class Player extends Creatures {
	
	
	// GESTION DE L'AFFICHAGE
	
	public Window window;
	public Game game;
	private Graphics g;
	
	// PARTIE TIMER
	
	private long lastTime;
	private long timer;
	
	private long lastTime2;
	private long timer2;
	

	// GESTION DE L'ATTAQUE
	
	private Rectangle porté;
	private Rectangle coliRec;
	private int range;
	
	private boolean isAttacking;
	private int direction;
	// GESTION DE L'INVENTAIRE
	
	//private ArrayList<Objets> potion_list = new ArrayList<Objets>(); 
	//private ArrayList<Objets> armor_list = new ArrayList<Objets>(); 
	private ArrayList<Objets> potion_list = new ArrayList<Objets>(); 
	int counter = 0;
	
	//Animations
	
	private Animation animDown;
	private Animation animUp;
	private Animation animLeft;
	private Animation animRight;

	
	public Player(Game game, float posX, float posY) {
		super(game,posX,posY);
		this.game = game;
		this.posX = posX;
		this.posY = posY;
		isMoving = true;
		isPlayerMovable = true;
		lastTime = 800;
		timer = 0;
		hp = 5;
		
		// GESTION DES COLLISIONS
		
		 collisionRec.x = 21;
		 collisionRec.y = 26;
		 collisionRec.width = 22;
		 collisionRec.height = 31;
		
			//Animations
			
		 animDown = new Animation(500, Sheets.player_down);
		 animUp = new Animation(500,Sheets.player_up);
		 animLeft = new Animation(500,Sheets.player_left);
		 animRight = new Animation(500,Sheets.player_right);
		 
		 
		 
		 
	
	}

	

	
	
	
	
	public void addHp(int nombre) {
		if(hp < 5)
		hp += nombre;
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
		
		
		if(game.getKeyboard().isInventaire()) {
			if(game.getKeyboard().isInventaire1())
				counter =0;
			if(game.getKeyboard().isInventaire2())
				counter =1;
			if(game.getKeyboard().isInventaire3())
				counter =2;
		}

		
		
		if(game.getKeyboard().isUtiliser()) {
			useObjet();
		}
			
	
	}
		
		

	public void update() {

		// ANIMATION
		
		animDown.update();
		animUp.update();
		animRight.update();
		animLeft.update();
		
		getInput();
		move();
		collisionObjet();
		game.getCamera().centerPlayer(this);  // PERMET DE CENTRER LA CAM SUR LE PLAYER
	
		hit();
		

		
		//TEST

	}
	
	
	// UTILISATION DES OBJETS 
	
	public void useObjet() {
		
		timer2 += System.currentTimeMillis() - lastTime2;   
		lastTime2 = System.currentTimeMillis();
		
		if(timer2 < 5000) {
			return;
		}
		
		
		if(potion_list.size() == 0) {
			return;
		}
		if(potion_list.size() ==counter) {
			return;
		}
		
		
		if(potion_list.get(counter) != null ) {

			potion_list.get(counter).use();
			potion_list.remove(potion_list.get(counter));
			System.out.println(counter);
			
		}
		timer2=0;
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
			game.getInGame().getPnjList().getPnj().add((new Projectile(game,posX + 15,posY - 15,1,1)));
			
//			porté.x = coliRec.x + coliRec.width / 2 - range / 2;
//			porté.y = coliRec.y - range / 2;
//			isAttacking = true;
		}else 		if(game.getKeyboard().isAttaque_bas()) {
			game.getInGame().getPnjList().getPnj().add((new Projectile(game,posX + 15,posY + LARGEUR_CREATURE,1,3)));
			
//			porté.x = coliRec.x + coliRec.width / 2 - range / 2;
//			porté.y = coliRec.y + coliRec.height;
			isAttacking = true;
		}else 		if(game.getKeyboard().isAttaque_gauche()) {
			game.getInGame().getPnjList().getPnj().add((new Projectile(game,posX,posY + 15,1,4)));
			
			
//			porté.x = coliRec.x +  - range / 2;
//			porté.y = coliRec.y;
			isAttacking = true;
		}else 		if(game.getKeyboard().isAttaque_droite()) {
			game.getInGame().getPnjList().getPnj().add((new Projectile(game,posX+ LARGEUR_CREATURE/2,posY + 15,1,2)));
			
//			porté.x = coliRec.x + coliRec.width;
//			porté.y = coliRec.y;
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
				//System.out.println(c.hp);
				return;
			}
		
		}
		System.out.println(isAttacking);
		
	}
	
	
	public void collisionObjet() {
		if(game.getInGame().getItems_list().getItems_list() == null) {
			return;
		}
		for(Objets o : game.getInGame().getItems_list().getItems_list()) {
			if(o == null) {
				return;
			}
			if(this.getCollisionRec(this,0,0).intersects(o.getCollisionRec(o,0,0)) && potion_list.size() < 3){
				potion_list.add(o);
				o.ramassé();
			}
		}
	}
	
	
	public void notifyView(Graphics g) {
		this.g = g;
		
		//////////////////////////////
		// AFFICHAGE DE L'INVENTAIRE//
		//////////////////////////////
		g.drawImage(getCurrentAnimationFrame(),(int)(posX - game.getCamera().getDecalage_x()),(int)(posY - game.getCamera().getDecalage_y()),LARGEUR_CREATURE,HAUTEUR_CREATURE,null);

		
		if(game.getKeyboard().isInventaire()) {
			g.drawImage(Sheets.getInventaire(),(int)(posX - game.getCamera().getDecalage_x() + LARGEUR_CREATURE),(int)(posY - game.getCamera().getDecalage_y()),(LARGEUR_CREATURE*3) /2 + 8,(HAUTEUR_CREATURE*3)/2 + 8,null);
			

			
			g.drawImage(Sheets.getSelection_inventaire(),(int)(posX - game.getCamera().getDecalage_x() + LARGEUR_CREATURE + 2 + (32 + 2) *counter),(int)(posY - game.getCamera().getDecalage_y()) + 2,LARGEUR_CREATURE /2,HAUTEUR_CREATURE/2,null);
			
			
			
			
			// GESTION DU STUFF
			
			g.drawImage(Sheets.wooden_sword_inventaire,(int)(posX - game.getCamera().getDecalage_x() + LARGEUR_CREATURE + 2),(int)(posY - game.getCamera().getDecalage_y()) + 2 + 32,LARGEUR_CREATURE /2,HAUTEUR_CREATURE/2,null);
			
		
				
				// GESTION DES BIJOUX
				
				if(potion_list.size() != 0) {
					
					if(potion_list.size() == 1) {	
					g.drawImage(potion_list.get(0).getIm_item(),(int)(posX - game.getCamera().getDecalage_x() + LARGEUR_CREATURE + 2),(int)(posY - game.getCamera().getDecalage_y()) + 2,LARGEUR_CREATURE /2,HAUTEUR_CREATURE/2,null);
					
					}
					
					if(potion_list.size() == 2) {
						g.drawImage(potion_list.get(0).getIm_item(),(int)(posX - game.getCamera().getDecalage_x() + LARGEUR_CREATURE + 2),(int)(posY - game.getCamera().getDecalage_y()) + 2,LARGEUR_CREATURE /2,HAUTEUR_CREATURE/2,null);

						g.drawImage(potion_list.get(1).getIm_item(),(int)(posX - game.getCamera().getDecalage_x() + LARGEUR_CREATURE + 2 + 32),(int)(posY - game.getCamera().getDecalage_y()) + 2,LARGEUR_CREATURE /2,HAUTEUR_CREATURE/2,null);

					}
					if(potion_list.size() == 3) {
						g.drawImage(potion_list.get(0).getIm_item(),(int)(posX - game.getCamera().getDecalage_x() + LARGEUR_CREATURE + 2),(int)(posY - game.getCamera().getDecalage_y()) + 2,LARGEUR_CREATURE /2,HAUTEUR_CREATURE/2,null);

						g.drawImage(potion_list.get(1).getIm_item(),(int)(posX - game.getCamera().getDecalage_x() + LARGEUR_CREATURE + 2 + 32),(int)(posY - game.getCamera().getDecalage_y()) + 2,LARGEUR_CREATURE /2,HAUTEUR_CREATURE/2,null);

						g.drawImage(potion_list.get(2).getIm_item(),(int)(posX - game.getCamera().getDecalage_x() + LARGEUR_CREATURE + 2 + 64),(int)(posY - game.getCamera().getDecalage_y()) + 2,LARGEUR_CREATURE /2,HAUTEUR_CREATURE/2,null);

					}
			
				
				
				
				
			}
				
		
		

		// TEST
		
		// RAJOUTER LES 4 DIRECTIONS POUR L'EPEE
		
		
		if(isAttacking) {
			g.setColor(Color.BLACK);
			g.drawImage(Sheets.getWooden_sword_up(),(int) (porté.x - game.getCamera().getDecalage_x()), (int) (porté.y - game.getCamera().getDecalage_y()), porté.width *2, porté.height,null);
		}
		}
	////////////////////
	//AFFICHAGE DES HP//
	////////////////////
		
		drawLife(g);
		
		
		//g.setColor(Color.BLACK);
	 // g.drawString("HP = " + String.valueOf(hp),(int)(posX - game.getCamera().getDecalage_x() + 10),(int)(posY - game.getCamera().getDecalage_y()));
	
	}
	
	// ANIMATION DU PERSONNAGE
	
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



	@Override
	public Rectangle getCollisionRec(GameObject c, float decalage_x, float decalage_y) {

		return collisionRec;
	}}

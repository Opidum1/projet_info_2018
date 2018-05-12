package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;




public class Enemy extends Creatures {
	
	private bois bois;
	private Health_potion health_potion;
	
	
	private float posX_player,posY_player;

	private int time;
	
	private long lastTime;
	private long timer;
	
	private long lastTime2;
	private long timer2;
	
	private Random rand = new Random();
	private Random rand2 = new Random();
	
	int randomNum ;
	int randomNum2;
	
	public Game game;
	
	public Enemy(Game game, float posX, float posY,int hp,int time) {
		super(game, posX, posY);
		this.game = game;
		this.posX = posX;
		this.posY = posY;
		this.time = time;
		this.hp = hp;
		hp = HP_CREATURE;
		isMoving = true;
		
		 collisionRec.x = 0;
		 collisionRec.y = 0;
		 collisionRec.width = LARGEUR_CREATURE;
		 collisionRec.height = HAUTEUR_CREATURE;

		 lastTime = System.currentTimeMillis();
		 lastTime2 = System.currentTimeMillis();
		 
	
	
	}

	



	@Override
	public void update() {
		
		
		timer += System.currentTimeMillis() - lastTime;   // nous donne le temps passé avant entre le dernier update et maintenant
		lastTime = System.currentTimeMillis();

		timer2 += System.currentTimeMillis() - lastTime2;   // nous donne le temps passé avant entre le dernier update et maintenant
		lastTime2 = System.currentTimeMillis();
		
		 posX_player = game.getInGame().getPlayer().getPosX();
		 posY_player = game.getInGame().getPlayer().getPosY();
		
		System.out.println(hp);
		if(timer2 < time) {
		}else {
			mort();
		}
		
		if(timer < 500) {
			return;
		}
		
		
		// PERMET DE CHASE LE JOUEUR 
		
		if(Math.pow(Math.pow((int)(posX_player),2) - Math.pow((int)(posX),2) - Math.pow((int)(posY_player),2),1/2) < 1000) {
			if(posX < posX_player) {
				xMove = 10*VITESSE_CREATURE;
			}
			if(posX > posX_player) {
				xMove = -10*VITESSE_CREATURE;
			}
			
			if(posY < posY_player) {
				yMove = 10*VITESSE_CREATURE;
			}
			if(posY > posY_player) {
				yMove = -10*VITESSE_CREATURE;
			}
		
		}

	move();	
	if(this.getCollisionRec(this,0,0).intersects(game.getInGame().getPlayer().getCollisionRec(game.getInGame().getPlayer(), 0,0))){

		hp=0;
		mort();
		game.getInGame().getPlayer().degat(1);
	}
	timer =0;
	}

	@Override
	public void notifyView(Graphics g) {
		
		g.setColor(Color.RED);
		g.fillRect((int)(posX - game.getCamera().getDecalage_x()),(int) (posY - game.getCamera().getDecalage_y()), LARGEUR_CREATURE, HAUTEUR_CREATURE);
		
	}

	public boolean isObstacle() {
		return true;
	}

	private boolean CollisionPnj(float decalage_x, float decalage_y) {
		return false;
	}

	public void move() {
		
		if(xMove !=0 && !CollisionPnj(xMove,0f))
			moveX();
			
		if(yMove !=0 && !CollisionPnj(0f,yMove))
			moveY();
	}
	


	@Override
	public void mort() {			
		vivant = false;	
			
		randomNum = 1;//rand.nextInt((2 - 1) + 1);	
		randomNum2 = rand2.nextInt((2 - 1) + 1);	
		if(randomNum ==1) {														// 1 CHANCE SUR 2 DE DROP UNE POTION
	
			health_potion = new Health_potion(game,(int)(posX),(int)(posY),1);
			game.getInGame().getItems_list().addObjet(health_potion);
		}
	}





	@Override
	public void dmgAnim() {
		// TODO Auto-generated method stub
		
	}





	@Override
	public Rectangle getCollisionRec(GameObject c,float decalage_x,float decalage_y) {
		return collisionRec;
	}

}

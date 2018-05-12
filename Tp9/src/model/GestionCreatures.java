package model;

import java.awt.Graphics;
import java.util.ArrayList;

public class GestionCreatures {
	
	private Player player;
	private ArrayList<Creatures> pnj = new ArrayList<Creatures>();
	private Enemy red1,red2,red3,red4,red5;
	

	private int deadMobs =0;
	public int count = 1;
	
	
	public GestionCreatures(Player player) {  //prends 1 player pour pouvoir être sur qu'il soit la et en plus pouvoir le get/set
		this.player = player;
		
		red1 = new Enemy(player.getGame(), 70f,70f,count*5,count*10*1000);
		red2 = new Enemy(player.getGame(), 400f,400f,count*5,count*10*1000);
		red3 = new Enemy(player.getGame(), 800f,40f,count*5,count*10*1000);
		red4 = new Enemy(player.getGame(), 40f,800f,count*5,count*10*1000);
		red5 = new Enemy(player.getGame(), 800f,800f,count*5,count*10*1000);
		
		
//		pnj.add(red1);
//		pnj.add(red2);		
//		pnj.add(red3);
//		pnj.add(red4);
//		pnj.add(red5);		
		

		//pnj.add(red2);
		pnj.add(player);                     	 // AJOUTE LE PLAYER EN DERNIER POUR QU'IL SOIT AFFICHER AU DESSUS 5 POSSIBLITE DE TRIER LA LISTE DE CREATURES

	}
   
	
	public ArrayList<Creatures> getPnj(){
		return pnj;
	}

	
	public void setPnj(ArrayList<Creatures> pnj) {
		this.pnj = pnj;
	}

	public void ajoutCreatures(Creatures c) {
		pnj.add(c);
	}
	
	// BLOC SPAWN

	public void spawn() {
		
		
		if(deadMobs == 5 || deadMobs ==0) {

			red1 = new Enemy(player.getGame(), 70f,70f,count*5,count*10*1000);
			red2 = new Enemy(player.getGame(), 200f,200f,count*5,count*10*1000);
			red3 = new Enemy(player.getGame(), 800f,40f,count*5,count*10*1000);
			red4 = new Enemy(player.getGame(), 40f,800f,count*5,count*10*1000);
			red5 = new Enemy(player.getGame(), 800f,800f,count*5,count*10*1000);
			
			
			pnj.add(red1);
			pnj.add(red2);
			pnj.add(red3);
			pnj.add(red4);
			pnj.add(red5);
			
			
			deadMobs =0;
			count +=1;
		
		}
		
	}
	
	
	// BLOC UPDATE
	
	public void update() {
		if(deadMobs == 5) {
			//spawn();
		}

		for(int i =0; i < pnj.size();i++) {
			Creatures  c = pnj.get(i);
			c.update();
			if(!c.vivant) {
				if(!c.isProjectile) {
					deadMobs +=1;
				}
				
		
				pnj.remove(c);
		}}
		
	}
	
	public void notifyView(Graphics g) {
		for(int i =0; i < pnj.size();i++) {
			Creatures c = pnj.get(i);
			c.notifyView(g);
		}
	
	}



}

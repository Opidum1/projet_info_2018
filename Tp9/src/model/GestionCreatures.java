package model;

import java.awt.Graphics;
import java.util.ArrayList;

public class GestionCreatures {
	
	private Player player;
	private ArrayList<Creatures> pnj = new ArrayList<Creatures>();
	private Enemy red,red2;

	
	public GestionCreatures(Player player) {  //prends 1 player pour pouvoir être sur qu'il soit la et en plus pouvoir le get/set
		this.player = player;
		
		red = new Enemy(player.getGame(), 150,150);
		red2 = new Enemy(player.getGame(), 250,400);
		pnj.add(red);
		pnj.add(red2);
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
	
	// BLOC UPDATE
	
	public void update() {
		for(int i =0; i < pnj.size();i++) {
			Creatures  c = pnj.get(i);
			c.update();
			if(!c.vivant)
				pnj.remove(c);
		}
	}
	
	public void notifyView(Graphics g) {
		for(int i =0; i < pnj.size();i++) {
			Creatures c = pnj.get(i);
			c.notifyView(g);
		}
	}



}

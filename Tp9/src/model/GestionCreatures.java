package model;

import java.awt.Graphics;
import java.util.ArrayList;

public class GestionCreatures {
	
	private Player player;
	private ArrayList<Creatures> pnj = new ArrayList<Creatures>();
	private Enemy red;

	
	public GestionCreatures(Player player) {  //prends 1 player pour pouvoir être sur qu'il soit la et en plus pouvoir le get/set
		this.player = player;
		pnj.add(player);
		red = new Enemy(player.getGame(), 150,150);
		pnj.add(red);
		
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
		}
	}
	
	public void notifyView(Graphics g) {
		for(int i =0; i < pnj.size();i++) {
			Creatures c = pnj.get(i);
			c.notifyView(g);
		}
	}



}

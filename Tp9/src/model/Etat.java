package model;

import java.awt.Graphics;

public abstract class Etat {
	
	protected Game game;
	protected static Etat etat_actuel = null;
	
	
	public Etat(Game game) {
		this.game = game;
	}
	
	public abstract void update();
	public abstract void notifyView(Graphics g);
	
	
	public static void setEtat(Etat etat) {
		etat_actuel = etat;
	}
	
	public static Etat getEtat() {
		return etat_actuel;
	}

	public GestionCreatures getPnjList() {
		// TODO Auto-generated method stub
		return null;
	}

	public GestionObjets getItems_list() {
		// TODO Auto-generated method stub
		return null;
	}

	public Player getPlayer() {
		return null;
		
	}

}

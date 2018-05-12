package model;

import java.awt.Graphics;
import java.util.ArrayList;

public class GestionObjets {

	
	private ArrayList<Objets> items_list = new ArrayList<Objets>();
	private Player player;
	
	// INVENTAIRE
	
	
	
	
	public GestionObjets(Player player) {
		this.player = player;
		
	}

	
	
	public void addObjet(Objets o) {
		System.out.println("ajouté");
		items_list.add(o);
	}
	
	
	public void update() {
		
		
		for(int i =0; i < items_list.size();i++) {
			Objets o = items_list.get(i);
			if(o == null) {
				return;
			}
			if(!o.existant) {
				items_list.remove(o);
		}}
	}
	
	public void notifyView(Graphics g) {
		for(int i =0; i < items_list.size();i++) {
			Objets o = items_list.get(i);
			if(o == null) {
				return;
			}
			o.notifyView(g);
			
		}
	}


	public ArrayList<Objets> getItems_list() {
		return items_list;
	}



	public void setItems_list(ArrayList<Objets> items_list) {
		this.items_list = items_list;
	}
	
	


}

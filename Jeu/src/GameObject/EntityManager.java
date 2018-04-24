package GameObject;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;

import Jeu.Handleur;

public class EntityManager {
	
	private Handleur handler;
	private Player player;
	private ArrayList<GameObject> entities;
	private Comparator<GameObject> renderSorter = new Comparator<GameObject>() {

		@Override
		public int compare(GameObject a, GameObject b) { // on va vérifier les différents y pour voir qui doit être affiché au premier plan
			if(a.getY() + a.getHauteur() < b.getY() + b.getHauteur()) 
				return -1;
			return 1;
		}
		
		
	};
		

	
	public EntityManager(Handleur handler, Player player) {
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<GameObject>();
		addEntity(player);
	}

	public void update() {                          //update chaque Objet de la liste Entity
		for(int i = 0; i < entities.size();i++) {
			GameObject e = entities.get(i);
			e.update();
		}
		entities.sort(renderSorter);
	}
	
	public void notifyView(Graphics g) {            //notifyView de chaque objet de la liste Entity
		for(GameObject e : entities) {
			e.notifyView(g);
		}
	}

	
	public void addEntity(GameObject e) {
		entities.add(e);
	}
	
	
	
	//GET/SET
	
	
	public Handleur getHandler() {
		return handler;
	}

	public void setHandler(Handleur handler) {
		this.handler = handler;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<GameObject> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<GameObject> entities) {
		this.entities = entities;
	}
	
	
}

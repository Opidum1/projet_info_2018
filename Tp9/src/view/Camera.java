package view;

import model.Creatures;
import model.Game;

public class Camera {
	
	private float decalage_x,decalage_y;  //donne le décalage par rapport à la pos du player
	private Game game;
	
	
	public Camera(Game game,float decalage_x, float decalage_y) {
		this.game = game;
		this.decalage_x = decalage_x;
		this.decalage_y = decalage_y;
		
	}


	public void centerPlayer(Creatures e) {   // PERMET DE CENTRER LE PLAYER 
		decalage_x = e.getPosX() - game.getLargeur() / 2 + 64 / 2;
		decalage_y = e.getPosY() - game.getHauteur() / 2 + 64 / 2;
		
		
		// PARTIE VERIFIANT QUE LA CAMERA NE SORT PAS DE LA MAP
		
		if(decalage_x < 0) {   
			decalage_x = 0;
		}else if(decalage_x >= game.getFond().getLargeur() * game.getFond().getLargeur_fond() - game.getLargeur()) {
			decalage_x = game.getFond().getLargeur() * game.getFond().getLargeur_fond() - game.getLargeur();
		}
		
		if(decalage_y < 0) {
			decalage_y = 0;
		}else if(decalage_y >= game.getFond().getHauteur() * game.getFond().getHauteur_fond() - game.getHauteur()) {
			decalage_y = game.getFond().getHauteur() * game.getFond().getHauteur_fond() - game.getHauteur()	;
		}
		
	
	}
	
	public void move(float xAdd, float yAdd) {
		decalage_x += xAdd;
		decalage_y += yAdd;

	}
	
	
	
	// GET/SET
	
	public float getDecalage_x() {
		return decalage_x;
	}


	public void setDecalage_x(float decalage_x) {
		this.decalage_x = decalage_x;
	}


	public float getDecalage_y() {
		return decalage_y;
	}


	public void setDecalage_y(float decalage_y) {
		this.decalage_y = decalage_y;
	}

}

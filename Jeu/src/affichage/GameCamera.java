package affichage;

import GameObject.GameObject;
import Jeu.Handleur;
import Jeu.Jeu;
import tiles.Tile;

public class GameCamera {
	
	private Handleur handler;
	private float xOffset, yOffset;
	
	public GameCamera(Handleur handler,float xOffset, float yOffset) {
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public void checkBlankSpace() {
		if(xOffset < 0) {
			xOffset = 0;
		}else if(xOffset > handler.getWorld().getLargeur() * Tile.TILE_LARGEUR - handler.getLargeur()){
			xOffset = handler.getWorld().getLargeur() * Tile.TILE_LARGEUR - handler.getLargeur();
		}
		
		if(yOffset < 0) {
			yOffset = 0;
		}else if(yOffset > handler.getWorld().getHauteur() * Tile.TILE_HAUTEUR - handler.getHauteur()) {
			yOffset = handler.getWorld().getHauteur() * Tile.TILE_HAUTEUR - handler.getHauteur();
		}
	}
	
	public void CenterOneEntity(GameObject e) {
		xOffset = e.getX() - handler.getLargeur() / 2 + e.getLargeur() / 2;
		yOffset = e.getY() - handler.getHauteur() / 2 + e.getHauteur() / 2;
		checkBlankSpace();
	}

	public void move(float xAmt, float yAmt) {
		xOffset += xAmt;
		yOffset += yAmt;
		checkBlankSpace();
	}
	
	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
		checkBlankSpace();
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
		checkBlankSpace();
	}

}

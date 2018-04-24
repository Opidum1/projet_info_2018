package GameObject.statics;

import java.awt.Color;
import java.awt.Graphics;

import Jeu.Handleur;
import affichage.Assets;
import tiles.Tile;


public class Tree extends StaticEntity {

	public Tree(Handleur handler, float x, float y) {
		super(handler, x, y,Tile.TILE_LARGEUR*2, Tile.TILE_HAUTEUR * 2);

		bounds.x = 40;
		bounds.y = 104;
		bounds.width = 18;
		bounds.height = 4;
		
		
	}

	@Override
	public void update() {

		
	}

	@Override
	public void notifyView(Graphics g) {
		g.drawImage(Assets.tree, (int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()), largeur, hauteur, null);
	}
	


}

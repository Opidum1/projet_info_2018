package tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	//STATIC STUFF HERE
	
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(0);
	public static Tile dirtTile = new DirtTile(1);
	
	//CLASS
	
	public static final int TILE_LARGEUR = 64, TILE_HAUTEUR = 64;
	
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;       // pour chaque carreau
		
		tiles[id] = this;
		
	}
	
	public void update() {
		
	}
	
	public void notifyView(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILE_LARGEUR, TILE_HAUTEUR, null );
		
	}
	
	public boolean isObstacle() {
		return false;
	}
	
	public int getId() {
		return id;
	}
	
}

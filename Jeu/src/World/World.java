package World;

import java.awt.Graphics;

import GameObject.EntityManager;
import GameObject.Player;
import GameObject.statics.Tree;
import Jeu.Handleur;
import Utils.Utils;
import tiles.Tile;

public class World {
	
	private Handleur handler;
	private int largeur, hauteur;
	private int spawnX, spawnY;
	private int[][] tiles;
	
	//GameObject
	private EntityManager entityManager;
	
	public World(Handleur handler, String path) {
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler,300,200));
		entityManager.addEntity(new Tree(handler,100,250));
		loadWorld(path);
	
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setX(spawnY);
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void update() {
		entityManager.update();
	}
	
	public void novifyView(Graphics g) {
		
		
		
		// Pour charger seulement les Tiles de l'écran et pas toute la map
		
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILE_LARGEUR); // pour retourner 0 si jamais il y a des valeurs négatives
		int xEnd = (int) Math.min(largeur,(handler.getGameCamera().getxOffset() + handler.getLargeur()) / Tile.TILE_LARGEUR + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILE_HAUTEUR);
		int yEnd = (int) Math.min(hauteur,(handler.getGameCamera().getyOffset() + handler.getHauteur()) / Tile.TILE_HAUTEUR + 1);
		
		for(int y = yStart; y < yEnd;y++) {
			for(int x = xStart; x < xEnd;x++) {
				getTile(x, y).notifyView(g,(int) (x * Tile.TILE_LARGEUR - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILE_HAUTEUR - handler.getGameCamera().getyOffset()));
			}
		}
		//Entities
		entityManager.notifyView(g);
	}
	
	public Tile getTile(int x, int y) {  // get du tile en position (x,y)
		if (x < 0 || x < 0 || x >= largeur || y >= hauteur)   // pour éviter que le jeu crash si on sort de la map
			return Tile.grassTile;
		
		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null)
			return Tile.dirtTile;
		return t;
	}
	
	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		largeur = Utils.parseInt(tokens[0]);
		hauteur = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int [largeur][hauteur];
		for(int y = 0; y < hauteur;y++ ) {
			for(int x = 0; x < largeur;x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y*largeur) + 4]);
				
			}
		}
		
	}

	public int getLargeur() {
		return largeur;
	}

	public int getHauteur() {
		return hauteur;
	}
}

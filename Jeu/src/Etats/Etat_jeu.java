package Etats;

import java.awt.Graphics;

import GameObject.Player;
import GameObject.statics.Tree;
import Jeu.Handleur;
import World.World;

public class Etat_jeu extends Etat {
	
	private Player player;
	private World world;


	public Etat_jeu(Handleur handler) {
		super(handler);
		world = new World(handler,"ressources/World/world1.txt");
		handler.setWorld(world);

	}
	
	@Override
	public void update() { 
		world.update();


	}
	
	@Override
	public void notifyView(Graphics g) {
		world.novifyView(g);


	}
	
}

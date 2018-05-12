package model;

import java.awt.Color;
import java.awt.Graphics;

public class Etat_test extends Etat {

	public Etat_test(Game game) {
		super(game);
		this.game = game;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyView(Graphics g) {
		game.getInGame().notifyView(g);
		g.drawString("PAUSE",(int)(game.getLargeur())/2,(int)(game.getHauteur())/2);
		
	}

}

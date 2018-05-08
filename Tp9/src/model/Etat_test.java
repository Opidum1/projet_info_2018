package model;

import java.awt.Color;
import java.awt.Graphics;

public class Etat_test extends Etat {

	public Etat_test(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyView(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 400, 400);
		
	}

}

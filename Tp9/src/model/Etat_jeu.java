package model;

import java.awt.Graphics;

import view.Fond;

public class Etat_jeu extends Etat {

	private Game game;
	private Fond fond;
	private Player player;
	private GestionCreatures pnjList;

	public Etat_jeu(Game game) {
		super(game);
		player = new Player(game,250,250);
		pnjList = new GestionCreatures(player);
		fond = new Fond(game,"ressources_ext/monde/monde.txt");
	}




	@Override
	public void notifyView(Graphics g) {
		fond.notifyView(g);
		pnjList.notifyView(g);
	}


	@Override
	public void update() {
		pnjList.update();
		
	}




	public Game getGame() {
		return game;
	}




	public void setGame(Game game) {
		this.game = game;
	}




	public Fond getFond() {
		return fond;
	}




	public void setFond(Fond fond) {
		this.fond = fond;
	}




	public Player getPlayer() {
		return player;
	}




	public void setPlayer(Player player) {
		this.player = player;
	}




	public GestionCreatures getPnjList() {
		return pnjList;
	}




	public void setPnjList(GestionCreatures pnjList) {
		this.pnjList = pnjList;
	}



}

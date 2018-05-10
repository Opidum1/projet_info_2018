package model;

import java.awt.Graphics;

import view.Fond;

public class Etat_jeu extends Etat {

	private Game game;
	private Fond fond;
	private Player player;
	private GestionCreatures pnjList;
	private GestionObjets items_list;

	public Etat_jeu(Game game) {
		super(game);
		player = new Player(game,250,250);
		pnjList = new GestionCreatures(player);
		items_list = new GestionObjets(player);
		fond = new Fond(game,"ressources_ext/monde/monde.txt");
	}




	@Override
	public void notifyView(Graphics g) {
		fond.notifyView(g);
		
		items_list.notifyView(g);
		pnjList.notifyView(g);
	}


	@Override
	public void update() {
		pnjList.update();
		items_list.update();
	}




	public GestionObjets getItems_list() {
		return items_list;
	}




	public void setItems_list(GestionObjets items_list) {
		this.items_list = items_list;
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

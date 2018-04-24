package Etats;

import java.awt.Graphics;

import Jeu.Handleur;
import UI.ClickListener;
import UI.UIImageButton;
import UI.UIManager;
import affichage.Assets;

public class Main_Menu extends Etat {

	
	private UIManager uiManager;
	
	public Main_Menu(Handleur handleur) {
		super(handleur);
		uiManager = new UIManager(handleur);
		handleur.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new UIImageButton(200,200,128,64, Assets.btn_start, new ClickListener() {

			@Override
			public void onClick() {
				handleur.getMouseManager().setUIManager(null);
				Etat.setEtat(handleur.getJeu().inGame);
			}}));
	}
	
	@Override
	public void update() {
		uiManager.update();
	}

	@Override
	public void notifyView(Graphics g) {
		uiManager.notifyView(g);
	}

}

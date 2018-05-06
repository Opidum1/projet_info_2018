package model;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import controller.Keyboard;
import view.Fond;
import view.Sheets;
import view.Window;

public class Game implements Runnable {
	
	
	private Window window;
	private Player player;
	private Enemy red;
	private Keyboard keyboard = new Keyboard(this);
	private Graphics g;
	private BufferStrategy bs;
	private Fond fond = new Fond(this,"ressources_ext/monde/monde.txt");
	private GestionCreatures pnjList;


	private Thread thread = new Thread(this);
	

	
	public Game(Window window) {
		this.window = window;
		window.getFrame().addKeyListener(keyboard);
		//	window.setKeyListener(keyboard);
		player = new Player(this,100,100);
		pnjList = new GestionCreatures(player);
		

		Sheets.Init();
		
		thread.start();
	}
	


	
	public void notifyView() {
		bs = window.getCanvas().getBufferStrategy();  // un bufferStrategy explique à l'écran comment dessiner quelque chose
		if(bs == null) {
			window.getCanvas().createBufferStrategy(3);			
			return;
		}
		g = bs.getDrawGraphics();     // Graphics c'est comme un pinceau, permet de dessiner sur le canva
		//Clear Screen			g.clearRect(0, 0, 400, 400);
		// début  Dessin
			
		fond.notifyView(g);
		pnjList.notifyView(g);

		//fin du dessin
		bs.show();
		g.dispose();
		window.draw();
	}



	public void update() {
		pnjList.update();
	}

	public void run() {
			try {
				while(true) {
					update();
					notifyView();
					thread.sleep(1000/60);
				}
			} catch (InterruptedException e) {
				
			}
		
	}

	// GET/SET
		
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

	public Keyboard getKeyboard() {
		return keyboard;
	}




	public Fond getFond() {
		return fond;
	}




	public void setFond(Fond fond) {
		this.fond = fond;
	}

}

package model;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import controller.Keyboard;
import view.Camera;
import view.Fond;
import view.Sheets;
import view.Window;

public class Game implements Runnable {
	
	private boolean running = true;
	
	// WINDOW
	
	private Window window;
	
	private int largeur,hauteur;

	
	
	
	private Player player;
	private Enemy red;
	private Keyboard keyboard = new Keyboard(this);
	private Graphics g;
	private BufferStrategy bs;
	private Fond fond;
	private GestionCreatures pnjList;

	private Camera camera;
	
	private Etat inGame;
	private Etat test;
	private Etat state;

	private Thread thread = new Thread(this);
	

	
	public Game(int largeur, int hauteur) {
		this.largeur = largeur;
		this.hauteur = hauteur;
		
		window = new Window("jeu", largeur, hauteur);
		window.getFrame().addKeyListener(keyboard);

		camera = new Camera(this,0f,0f);
		

		fond = new Fond(this,"ressources_ext/monde/monde.txt");
		
		inGame = new Etat_jeu(this);
		test = new Etat_test(this);
		state = inGame;
			
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
		//Clear Screen			
		g.clearRect(0, 0, 400, 400);
		// début  Dessin
			
		//fond.notifyView(g);
		state.notifyView(g);

		//fin du dessin
		bs.show();
		g.dispose();
		window.draw();
	}



	public void update() {
		state.update();
	}

	public void run() {
			try {
				while(true) {
					
					
					update();
					notifyView();
					thread.sleep(1000/60);
					
				
					// LE IF EST LA POUR LA PAUSE 
					
					if(getKeyboard().isSpace()) {
						state = test;
					}else if(!getKeyboard().isSpace()) {
						state = inGame;
					}
					
					// TEST
					
					//System.out.println(running);
				}
			} catch (InterruptedException e) {
				
			}
		
	}

	// GET/SET
	
	
	

	public int getLargeur() {
		return largeur;
	}


	public Etat getInGame() {
		return inGame;
	}




	public void setInGame(Etat inGame) {
		this.inGame = inGame;
	}




	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}


	public int getHauteur() {
		return hauteur;
	}


	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	public Camera getCamera() {
		return camera;
	}


	public void setCamera(Camera camera) {
		this.camera = camera;
	}

	public Player getPlayer() {
		return player;
	}


	public Graphics getG() {
		return g;
	}




	public void setG(Graphics g) {
		this.g = g;
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

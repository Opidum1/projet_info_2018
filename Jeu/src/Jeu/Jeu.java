package Jeu;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import Controller.Keyboard;
import Controller.MouseManager;
import Etats.Etat;
import Etats.Etat_jeu;
import Etats.Main_Menu;
import affichage.Affichage;
import affichage.Assets;
import affichage.GameCamera;


public class Jeu implements Runnable {
	
	private Affichage affichage;
	private int largeur,hauteur;
	private String titre;
	
	private boolean running = false;
	private Thread thread;
	
	
	private BufferStrategy bs;
	private Graphics g;

	//Etats
	public Etat inGame;
	public Etat menuState;
	private Etat options;
	
	
	//Input
	private Keyboard keyboard;
	private MouseManager mouseManager;
	
	//Camera
	private GameCamera gameCamera;
	
	//HANDLER
	private Handleur handler;
	
	public Jeu(String titre, int largeur, int hauteur) {
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.titre = titre;
		keyboard = new Keyboard();
		mouseManager = new MouseManager();
	}
	
	private void initialisation() {
		affichage = new Affichage(titre,largeur,hauteur);   // pour pouvoir créer un game dans le launcher
		affichage.getFrame().addKeyListener(keyboard);
		affichage.getFrame().addMouseListener(mouseManager);
		affichage.getFrame().addMouseMotionListener(mouseManager);   
		affichage.getCanvas().addMouseListener(mouseManager);            // si on avait que le getFrame, ça pourrait bugger en fonction de ce qui a le focus 
		affichage.getCanvas().addMouseMotionListener(mouseManager);
		Assets.init();
		
		
		handler = new Handleur(this);
		gameCamera = new GameCamera(handler, 0, 0);
		
		inGame = new Etat_jeu(handler);   // on peut l'initialiser en "Etat_jeu" car cette classe hérite de "Etat"
		menuState = new Main_Menu(handler);
		Etat.setEtat(menuState);
	}
	

	
	private void update() {
		keyboard.update();
		if(Etat.getEtat() != null)
			Etat.getEtat().update();
	}
	
	private void notifyView() {
		bs = affichage.getCanvas().getBufferStrategy();  // un bufferStrategy explique à l'écran comment dessiner quelque chose
		if(bs == null) {
			affichage.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();     // Graphics c'est comme un pinceau, permet de dessiner sur le canva
		//Clear Screen
		g.clearRect(0, 0, largeur, hauteur);
		// début  Dessin

		if(Etat.getEtat() != null)
			Etat.getEtat().notifyView(g);

		
		//fin du dessin
		bs.show();
		g.dispose();
	}
	
	
	@Override
	public void run() {
		
		initialisation();
		
		int fps =60;
		double timePerTick = 1000000000  / fps; // 10000000 nanosec dans 1 sec
		double delta =0;
		long now;
		long lastTime = System.nanoTime();
		long timer =0;
		int ticks =0;
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;  // nous donne le temps restant avant de refaire la boucle
			timer +=(now - lastTime);
			lastTime = now;
			
			if(delta >= 1) {
				update();
				notifyView();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000) {
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			
			}
			
			
		}
		stop(); // au cas ou le jeu ne s'est pas fermé après la boucle
	}
	
	public GameCamera  getGameCamera() {
		return gameCamera;
	}
	
	public int getLargeur() {
		return largeur;
	}
	
	public int getHauteur() {
		return hauteur;
	}
	
	public Keyboard getKeyboard() {
		return keyboard;
	}
	
	public MouseManager getMouseManager() {
		return mouseManager;
	}
	
	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start(); // appel la méthode run
	}
	
	public synchronized void stop() {
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
 
}

package view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Window {
	
	
	
	private JFrame frame;
	private int largeur,hauteur;
	private String titre;
	private Canvas canvas;
	private Map map = new Map();

	
	
	public Window(String titre, int largeur,int hauteur) {
		this.titre = titre;
		this.largeur = largeur;
		this.hauteur = hauteur;
		creatWindow();
			
	}
	
	public void creatWindow() {
		frame = new JFrame(titre);
		frame.setBounds(0, 0, largeur, hauteur);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(largeur, hauteur));
		canvas.setMaximumSize(new Dimension(largeur, hauteur));   // pour être sur que le canvas garde la bonne taille
		canvas.setMinimumSize(new Dimension(largeur, hauteur));   // pour être sur que le canvas garde la bonne taille
		canvas.setFocusable(false);
		
		
		frame.add(canvas);  // on pose le canvas sur le frame
		frame.pack();  // être sur que la fenêtre soit à la bonne taille pour tout voir
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public void draw() {
		this.map.notifyView();
		
	}
	
	public void setKeyListener(KeyListener keyboard) {
		this.map.addKeyListener(keyboard);
	}

	
	public Canvas getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

	public JFrame getFrame() {
		return frame;
	}
}


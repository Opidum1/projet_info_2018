package affichage;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Affichage {
	
	private JFrame frame;
	private Canvas canvas;
	
	private String titre;
	private int largeur, hauteur;
	
	public Affichage(String titre, int largeur, int hauteur) {
		this.titre = titre;
		this.largeur = largeur;
		this.hauteur = hauteur;
		
		creatAffichage();
	}
	
	private void creatAffichage() {
		frame = new JFrame(titre);
		frame.setBounds(0, 0, largeur, hauteur);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false); // permet de ne pas pouvoir "resize" la fenêtre
		frame.setLocationRelativeTo(null);   // permet d'avoir l'a fenêtre au milieu de l'écran
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(largeur, hauteur));
		canvas.setMaximumSize(new Dimension(largeur, hauteur));   // pour être sur que le canvas garde la bonne taille
		canvas.setMinimumSize(new Dimension(largeur, hauteur));   // pour être sur que le canvas garde la bonne taille
		canvas.setFocusable(false);
		
		
		frame.add(canvas);  // on pose le canvas sur le frame
		frame.pack();  // être sur que la fenêtre soit à la bonne taille pour tout voir
		 
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	
}




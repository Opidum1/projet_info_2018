package Etats;
import java.awt.Graphics;
import Jeu.Handleur;

public abstract class Etat {
	
	private static Etat Etat_actuel = null;
	
	public static void setEtat(Etat etat) {    // Change l'etat du jeu
		Etat_actuel = etat;
	}
	
	public static Etat getEtat(){
		return Etat_actuel;
	}
	
	// CLASS
	
	protected Handleur handleur;
	
	public Etat(Handleur handleur) {
		this.handleur = handleur;
	}

	public abstract void update();
	
	public abstract void notifyView(Graphics g);
	
}
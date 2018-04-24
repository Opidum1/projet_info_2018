import Jeu.Jeu;
import affichage.Affichage;

public class Launcher {  // sert à lancer le jeu
	
	public static void main(String [] args) {
		 Jeu jeu = new Jeu("Game",600,600);
		 jeu.start();
		}

}

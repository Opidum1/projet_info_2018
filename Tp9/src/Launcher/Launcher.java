package Launcher;

import controller.Keyboard;
import model.Game;
import view.Window;

public class Launcher {
	
	
	public static void main(String[] args) {
		Window window = new Window("jeu", 400, 400);

		Game game = new Game(window);
	
	}
}

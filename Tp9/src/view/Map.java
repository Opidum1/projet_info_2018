package view;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.Game;
import model.Player;

public class Map extends JPanel {
	
	
	private int[][] mapMatrix; 
	private Player player;
	public Game game;
	
	public Map() {
		this.setFocusable(true);
		this.requestFocusInWindow();
	}


	
    public void paint(Graphics g) { // permet de mettre tout les carré en gris ( light_gray + black)
    	for (int i = 0; i < 20; i++) { // Virer la valeur 20 et parametrer ca
            for (int j = 0; j < 20; j++) {
                int x = i;
                int y = j;
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(x * 50, y * 50, 48, 48);
                g.setColor(Color.BLACK);
                g.drawRect(x * 50, y * 50, 48, 48);
                 
            }
        }
		
		
	}
    
    public void notifyView() {
    	this.repaint();
    }
    
    
	// Get/Set
	
	public int[][] getMapMatrix() {
		return mapMatrix;
	}

	public void setMapMatrix(int[][] mapMatrix) {
		this.mapMatrix = mapMatrix;
	}

}


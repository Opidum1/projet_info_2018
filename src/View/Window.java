package View;

import Model.GameObject;

import java.awt.Color;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;


//COMMENTE

public class Window {
    private Map map = new Map();

    public Window() {
        JFrame window = new JFrame("Games"); // donne le nom à la fenêtre
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // permet de fermer l'application
        window.setBounds(0, 0, 1000, 1020); // donne le coin supérieur gauche de l'appli + largeur + longueur
        window.getContentPane().setBackground(Color.gray);   // met la couleur du fond en gris
        window.getContentPane().add(this.map);  
        window.setVisible(true);    // affiche la fenêtre
    }

    public void setGameObjects(ArrayList<GameObject> objects) { // initialise l'objet voulue
        this.map.setObjects(objects);
        this.map.redraw();
    }

    public void update() {  // " repaint" l'objet
        this.map.redraw();
    }

    public void setKeyListener(KeyListener keyboard) {  // permet de recevoir des commandes du clavier
        this.map.addKeyListener(keyboard);
    }
}

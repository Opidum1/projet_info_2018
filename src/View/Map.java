package View;

import Model.Directable;
import Model.GameObject;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;


//COMMENTE


public class Map extends JPanel {
    private ArrayList<GameObject> objects = null;

    public Map() {
        this.setFocusable(true); // permet à l'objet créer d'avoir le " focus ", de pouvoir être modifié
        this.requestFocusInWindow(); // permet à l'objet d'avoir l' "input focus " de pouvoir utiliser des commandes dessus
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

        for (GameObject object : this.objects) {  // for sur tout les objet de this.object
            int x = object.getPosX();
            int y = object.getPosY();
            int color = object.getColor();

            if (color == 0) {
                g.setColor(Color.DARK_GRAY);
            } else if (color == 1) {
                g.setColor(Color.GRAY);
            } else if (color == 2) {
                g.setColor(Color.BLUE);
            } else if (color == 3) {
                g.setColor(Color.GREEN);
            } else if (color == 4) {
                g.setColor(Color.RED);
            } else if (color == 5) {
                g.setColor(Color.ORANGE);
            }

            g.fillRect(x * 50, y * 50, 48, 48);
            g.setColor(Color.BLACK);
            g.drawRect(x * 50, y * 50, 48, 48);
            
            // Decouper en fontions
            if(object instanceof Directable) {    // vérifie si object est une instance de Directable
                int direction = ((Directable) object).getDirection();
                
                int deltaX = 0;
                int deltaY = 0;
                
                //Le swtich remplace les "else if", pour simplifier le code
                switch (direction) {  // évalue ce qu'il y a dans le switch
                case Directable.EAST:   // si = à ce qu'il y a après le "case", effectue l'instruction
                    deltaX = +24;
                    break;
                case Directable.NORTH:
                    deltaY = -24;
                    break;
                case Directable.WEST:
                    deltaX = -24;
                    break;
                case Directable.SOUTH:
                    deltaY = 24;
                    break;
                }

                int xCenter = x * 50 + 24;
                int yCenter = y * 50 + 24;
                g.drawLine(xCenter, yCenter, xCenter + deltaX, yCenter + deltaY); // déssine la ligne dans la direction du dernier déplacement
            }
        }
    }

    public void setObjects(ArrayList<GameObject> objects) { // transforme l'objet en celui voulue
        this.objects = objects;
    }

    public void redraw() { // réutilise la fonction paint
        this.repaint();
    }
}

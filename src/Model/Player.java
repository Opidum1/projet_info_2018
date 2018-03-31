package Model;
import java.util.ArrayList;

//COMMENTE


public class Player extends GameObject implements Directable {
   
	private ArrayList<Items> bag = new ArrayList<Items>();
	int size_bag;
	int level;
	int maxLifes;
    int lifes = 0;
    int direction = EAST;  

    public Player(int x, int y, int maxBomb, int lifes) {
        super(x, y, 2);            // cr�e le GameObject du player
        this.lifes = lifes;
    }

    public void move(int X, int Y) {    // change la position du joueur 
        this.posX = this.posX + X;
        this.posY = this.posY + Y;
    }

    public void rotate(int x, int y) {      // change l'orientation du joueur
        if(x == 0 && y == -1)
            direction = NORTH;
        else if(x == 0 && y == 1)
            direction = SOUTH;
        else if(x == 1 && y == 0)
            direction = EAST;
        else if(x == -1 && y == 0)
            direction = WEST;
    }

   // //////////////////////////////////////////////////////////////////////////////////////


    @Override                           //signifie que c'est une m�thode herit� ( plus pr�cisement d'une m�thode abstraite ici )
    public boolean isObstacle() {
        return false;
    }

    @Override                           // herit� de l'interface " directable"
    public int getDirection() {
    return direction;
    }

    public int getFrontX() {           // donne la direction suivante en X
        int delta = 0;
        if (direction % 2 == 0){
            delta += 1 - direction;
        }
        return this.posX + delta;
    }

    public int getFrontY() {          // donne la direction suivante en Y
        int delta = 0;
        if (direction % 2 != 0){
            delta += direction - 2;
        }
        return this.posY + delta;
    }
}

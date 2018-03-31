package Model;

import java.util.ArrayList;


//COMMENTE

public class BlockBreakable extends Block implements Deletable, Activable {

    private ArrayList<DeletableObserver> observers = new ArrayList<DeletableObserver>();
    private int lifepoints = 0;
    public BlockBreakable(int X, int Y, int lifepoints) {   // crée un block en X,Y de couleur 1 avec les points de vies donné
        super(X, Y, 1);
        this.lifepoints = lifepoints; 
    }
    
    public void activate(){             //      
        if (lifepoints == 1){
            crush();
        }
        else {
            lifepoints--;
            this.color = lifepoints + 2; // pour Ã©viter de retourner au gris
        }
    }


    public void crush(){                 // utilise la méthode " notifyDelatableObserver "
        notifyDeletableObserver();
    }
    // //////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void attachDeletable(DeletableObserver po) {     // add l'objet "po" à observers
        observers.add(po);
    }

    @Override
    public void notifyDeletableObserver() {    //     pour tout les objets " delatableObservers " dans observers 
        int i = 0;
        for (DeletableObserver o : observers) {
            i++;
            o.delete(this, null);
        }
    }

    @Override
    public boolean isObstacle() {               // dit que c'est un obstacle
        return true;
    }

}

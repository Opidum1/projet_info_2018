package Model;


// COMMENTE


public class BlockUnbreakable extends Block {

    public BlockUnbreakable(int X, int Y) {  // crée un block incassable
        super(X, Y, 0);
    }

    @Override                                // l'objet est alors un obstacle
    public boolean isObstacle() {
        return true;
    }
}

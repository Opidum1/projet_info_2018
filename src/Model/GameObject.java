package Model;


//COMMENTE


public abstract class GameObject {
    protected int posX;
    protected int posY;
    protected int color;

    public GameObject(int X, int Y, int color) {   // constructeur d'un objet quelconque du jeu
        this.posX = X;
        this.posY = Y;
        this.color = color;
    }

    public int getPosX() {
        return this.posX;
    }

    public int getPosY() {
        return this.posY;
    }

    public int getColor() {
        return this.color;
    }

    public boolean isAtPosition(int x, int y) {
        return this.posX == x && this.posY == y;
    }

    public abstract boolean isObstacle();
}

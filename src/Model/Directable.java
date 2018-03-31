package Model;


//COMMENTE

public interface Directable {     // interface donnant la direction 
    
    public static int EAST = 0;
    public static int NORTH = 1;
    public static int WEST = 2;
    public static int SOUTH = 3;
    
    public int getDirection();

}

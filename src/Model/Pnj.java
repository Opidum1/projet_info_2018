package Model;

public class Pnj extends GameObject {
	
	public Pnj(int x,int y,int color) {
		super(x,y,color);
	}
	
	public boolean isObstacle() {
		return true;
	}

}

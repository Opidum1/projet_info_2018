package model;

import java.awt.Graphics;
import java.awt.Rectangle;

public interface GameObject {
	

	
	public void update();
	public void notifyView(Graphics g);
	
	public Rectangle getCollisionRec(GameObject c,float decalage_x, float decalage_y );
	//public Rectangle getCollisionRec(GameObject c);

}

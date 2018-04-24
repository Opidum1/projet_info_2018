package GameObject.statics;

import java.awt.Graphics;

import javax.swing.text.html.parser.Entity;

import GameObject.GameObject;
import Jeu.Handleur;

public abstract class StaticEntity extends GameObject{
	
	public StaticEntity(Handleur handler, float x, float y,int largeur, int hauteur) {
		super(handler,x,y,largeur,hauteur);
	}


}

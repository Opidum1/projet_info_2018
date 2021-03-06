package UI;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Jeu.Handleur;

public class UIManager {
	
	private Handleur handleur;
	private ArrayList<UIObject> objects;
	
	
	public UIManager(Handleur handler) {
		this.handleur = handleur;
		objects = new ArrayList<UIObject>();
	}

	public void update() {
		for(UIObject o : objects)
			o.update();
	}

public void notifyView(Graphics g) {
	for(UIObject o : objects)
		o.notifyView(g);
}
	
	
	public void onMouseMove(MouseEvent e) {
		for(UIObject o : objects)
			o.onMouseMove(e);
	}

	public void onMouseRelease(MouseEvent e) {
		for(UIObject o : objects)
			o.onMouseRelease(e);
	}
	
	public Handleur getHandleur() {
		return handleur;
	}

	public void setHandleur(Handleur handleur) {
		this.handleur = handleur;
	}

	public ArrayList<UIObject> getObjects() {
		return objects;
	}

	public void setObjects(ArrayList<UIObject> objects) {
		this.objects = objects;
	}

	public void addObject(UIObject o) {
		objects.add(o);
	}
	
	public void removeObject(UIObject o) {
		objects.remove(0);
	}
	
}

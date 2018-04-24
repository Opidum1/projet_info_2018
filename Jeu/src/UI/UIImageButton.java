package UI;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class UIImageButton extends UIObject {

	
	private BufferedImage[] images;
	private ClickListener clicker;
	
	public UIImageButton(float x, float y, int largeur, int hauteur, BufferedImage[] images, ClickListener clicker) {
		super(x, y, largeur, hauteur);
		this.images = images;
		this.clicker = clicker;
	}

	@Override
	public void update() {		
	}

	@Override
	public void notifyView(Graphics g) {
		if(hovering)
			g.drawImage(images[1], (int) x, (int) y, largeur, hauteur, null);
		else
			g.drawImage(images[0], (int) x, (int) y, largeur, hauteur, null);
	}

	@Override
	public void onClick() {
		clicker.onClick();
	}
	
	
	
}

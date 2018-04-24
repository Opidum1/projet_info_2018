package affichage;



import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int largeur = 32, hauteur = 32;
	public static BufferedImage grass,dirt,tree;
	public static BufferedImage[] player_down;
	public static BufferedImage[] player_left;
	public static BufferedImage[] player_right;
	public static BufferedImage[] player_up;
	public static BufferedImage[] btn_start;
	
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sprite_sheet_gd.png"));
		
		//START BUTTON
		btn_start = new BufferedImage[2];
		btn_start[0] = sheet.cut(largeur * 3, hauteur, largeur*2, hauteur);
		btn_start[1] = sheet.cut(largeur * 3, hauteur * 2, largeur*2, hauteur);
		
		
		//DOWN
		player_down = new BufferedImage[2];
		player_down[0] = sheet.cut(largeur * 2, 0, largeur, hauteur);
		player_down[1] = sheet.cut(largeur * 3, 0, largeur, hauteur);
		
		//UP
		player_up = new BufferedImage[2];
		player_up[0] = sheet.cut(largeur * 4, 0, largeur, hauteur);
		player_up[1] = sheet.cut(largeur * 5, 0, largeur, hauteur);
		
		
		//LEFT
		player_left = new BufferedImage[2];
		player_left[0] = sheet.cut(largeur * 6, 0, largeur, hauteur);
		player_left[1] = sheet.cut(largeur * 7, 0, largeur, hauteur);
		
		//RIGHT
		player_right = new BufferedImage[2];
		player_right[0] = sheet.cut(0, hauteur, largeur, hauteur);
		player_right[1] = sheet.cut(largeur, hauteur, largeur, hauteur);
		
		
		grass = sheet.cut(0, 0, largeur, hauteur);
		dirt = sheet.cut(largeur, 0, largeur, hauteur);
		tree = sheet.cut(largeur * 2, hauteur, largeur, hauteur);

		
	}
	

}

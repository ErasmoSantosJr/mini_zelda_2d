package zelda_mini_clone;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spritesheet {

	public static BufferedImage spritesheet;
	public static BufferedImage[] player_front;
	public static BufferedImage tileWall;
	public static BufferedImage fireball;
	
	public Spritesheet() {
		try {
			spritesheet = ImageIO.read(getClass().getResource("/spritesheet.png"));	
			player_front =  new BufferedImage[2]; 
			
			player_front[0] = Spritesheet.getSprite(0,11,16,16);
			player_front[1] = Spritesheet.getSprite(16,11,16,16);
			
			tileWall = Spritesheet.getSprite(307,184,16,16);
			fireball = Spritesheet.getSprite(190,184,16,16);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static BufferedImage getSprite(int x, int y, int width, int height) {
		return spritesheet.getSubimage(x, y, width, height);
	}
}

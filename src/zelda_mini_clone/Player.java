package zelda_mini_clone;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;
import java.util.ArrayList;

public class Player extends Rectangle{

	public int spd = 4;
	public boolean right,up,down,left;
	
	public int curAnimation = 0;
	public int curFrames = 0, targetFrames = 15;
	
	public static List<Bullet> bullets = new ArrayList<>();
	
	public boolean shoot = false;
	
	public int dir = 1;
	public Player(int x, int y) {
		super(x,y,32,32);
	}
	
	public void tick() {
		
		boolean moved = false;
		
		if(right && Word.isFree(x+spd, y)) {
			x+=spd;
			moved = true;
			dir = 1;
		}else if(left&& Word.isFree(x-spd, y)) {
			x-=spd;
			moved = true;
			dir = -1;
		}
		
		if(up && Word.isFree(x,y-spd)) {
			y-=spd;
			moved = true;
		}else if(down && Word.isFree(x,y+spd)) {
			y+=spd;
			moved = true;
		}
		
		if(moved) {
			curFrames ++;
			if(curFrames == targetFrames) {
				curFrames = 0;
				curAnimation++;
				if(curAnimation == Spritesheet.player_front.length) {
					curAnimation = 0;
				}
			}
		}
		
		if(shoot) {
			shoot = false;
			bullets.add(new Bullet(x,y,dir));
		}
		
		for(int i = 0; i < bullets.size(); i++) {
			bullets.get(i).tick();
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(Spritesheet.player_front[curAnimation],x,y,32,32, null);
		
		for(int i = 0; i < bullets.size(); i++) {
			bullets.get(i).render(g);
		}
	}
	
}

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;


public class Bullet {
	int x,y;
	int orient;
	Image image = new ImageIcon
			(getClass().getResource("/image/bullet.png")).getImage();
	public Bullet(int x, int y, int orient) {
		super();
		this.x = x - image.getWidth(null)/2;
		this.y = y - image.getHeight(null)/2;
		this.orient = orient;
	}
	
	boolean move(ArrayList<Map> arrMap){
		int speed = 1;
		if (orient == Tank.LEFT) {
			x -= speed;
		}else if (orient == Tank.RIGHT) {
			x += speed;
		}else if (orient == Tank.UP) {
			y -= speed;
		}else if (orient == Tank.DOWN) {
			y += speed;
		}
		
		for (int i = 0; i < arrMap.size(); i++) {
			Rectangle rectangle = getRect()
					.intersection(arrMap.get(i).getRect());
			if (rectangle.isEmpty() == false) {
				if (arrMap.get(i).bit == 0 || arrMap.get(i).bit == 1) {
					if (arrMap.get(i).bit == 0) {
						arrMap.get(i).bit = 5;
					}
					return false;
				}
			}
		}
		
		if (x <= 0 
			|| x >= MyFrame.W_FRAME - image.getWidth(null) - 10
			|| y <= 0
			|| y >= MyFrame.H_FRAME - image.getHeight(null) - 30
				) {
			return false;
		}
		return true;
	}
	
	void draw(Graphics2D g2d){
		g2d.drawImage(image, x, y, null);
	}
	
	Rectangle getRect(){
		Rectangle rectangle = new Rectangle(x, y
				, image.getWidth(null), image.getHeight(null));
		return rectangle;
	}
	
}

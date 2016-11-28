import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Tank {
	int x, y;
	Image image;
	Image[] images = new Image[4];
	int orient;
	int xRaw, yRaw;
	// Orient of tank
	static int LEFT = 0;
	static int RIGHT = 1;
	static int UP = 2;
	static int DOWN = 3;
	long tF = 0;

	public Tank(int x, int y, int orient) {
		super();
		this.x = x;
		this.y = y;
		this.orient = orient;
	}

	void draw(Graphics2D g2d) {
		g2d.drawImage(image, x, y, null);
	}

	void move(ArrayList<Map> arrMap) {
		int speed = 3;
		xRaw = x;
		yRaw = y;
		if (orient == LEFT) {
			xRaw -= speed;
		} else if (orient == RIGHT) {
			xRaw += speed;
		} else if (orient == UP) {
			yRaw -= speed;
		} else if (orient == DOWN) {
			yRaw += speed;
		}

		for (int i = 0; i < arrMap.size(); i++) {
			Rectangle rectangle = getRect().intersection(
					arrMap.get(i).getRect());
			if (rectangle.isEmpty() == false) {
				if (arrMap.get(i).bit == 0 || arrMap.get(i).bit == 1) {
					return;
				}
			}
		}

		if (xRaw <= 0 || xRaw >= MyFrame.W_FRAME - image.getWidth(null) - 10
				|| yRaw <= 0
				|| yRaw >= MyFrame.H_FRAME - image.getHeight(null) - 30) {
			return;
		}
		x = xRaw;
		y = yRaw;
	}

	void changeOrient(int newOrient) {
		orient = newOrient;
		image = images[orient];
	}

	Rectangle getRect() {
		Rectangle rectangle = new Rectangle(xRaw, yRaw, image.getWidth(null),
				image.getHeight(null));
		return rectangle;
	}

	Bullet fire() {
		long tC = System.currentTimeMillis();
		if (tC - tF >= 300) {
			tF = tC;
			Bullet bullet = new Bullet(x + image.getWidth(null) / 2, y
					+ image.getHeight(null) / 2, orient);
			return bullet;
		}else{
			return null;
		}
	}
}

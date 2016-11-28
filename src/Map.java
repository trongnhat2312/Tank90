import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Map {
	int x, y;
	int bit;
	Image[] images = {
			new ImageIcon(getClass().getResource("/image/brick.png"))
					.getImage(),
			new ImageIcon(getClass().getResource("/image/rock.png")).getImage(),
			new ImageIcon(getClass().getResource("/image/tree.png")).getImage(),
			new ImageIcon(getClass().getResource("/image/water.png"))
					.getImage(),
			new ImageIcon(getClass().getResource("/image/bird.png")).getImage() };

	public Map(int x, int y, int bit) {
		super();
		this.x = x;
		this.y = y;
		this.bit = bit;
	}

	void draw(Graphics2D g2d) {
		if (bit != 5) {
			g2d.drawImage(images[bit], x, y, null);
		}
	}

	Rectangle getRect() {
		Rectangle rectangle;
		if (bit == 5) {
			rectangle = new Rectangle();
		} else {
			rectangle = new Rectangle(x, y, images[bit].getWidth(null),
					images[bit].getHeight(null));
		}
		return rectangle;
	}

}

import java.util.Random;

import javax.swing.ImageIcon;

public class BossTank extends Tank {

	Random random = new Random();

	public BossTank(int x, int y) {
		super(x, y, DOWN);

		images[0] = new ImageIcon(getClass().getResource(
				"/image/bossyellow_left.png")).getImage();
		images[1] = new ImageIcon(getClass().getResource(
				"/image/bossyellow_right.png")).getImage();
		images[2] = new ImageIcon(getClass().getResource(
				"/image/bossyellow_up.png")).getImage();
		images[3] = new ImageIcon(getClass().getResource(
				"/image/bossyellow_down.png")).getImage();

		image = images[DOWN];
	}

	void createOrient() {
		int percent = random.nextInt(101);
		if (percent >= 90) {
			int newOrient = random.nextInt(4);
			changeOrient(newOrient);
		}
	}
}

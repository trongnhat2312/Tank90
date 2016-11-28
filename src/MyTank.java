import javax.swing.ImageIcon;


public class MyTank extends Tank{

	public MyTank(int x, int y) {
		super(x, y, UP);
		images[0]=new ImageIcon(getClass()
				.getResource("/image/player_green_left.png")).getImage();
		images[1]=new ImageIcon(getClass()
				.getResource("/image/player_green_right.png")).getImage();
		images[2]=new ImageIcon(getClass()
				.getResource("/image/player_green_up.png")).getImage();
		images[3]=new ImageIcon(getClass()
				.getResource("/image/player_green_down.png")).getImage();
		
		image = images[UP];
	}

}

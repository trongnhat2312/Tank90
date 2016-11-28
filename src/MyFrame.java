import java.awt.Component;

import javax.swing.JFrame;

public class MyFrame extends JFrame {

	MyPanel myPanel = new MyPanel();
	static int W_FRAME = 800;
	static int H_FRAME = 600;

	public MyFrame() {
		setTitle("Tank 90");
		setSize(W_FRAME, H_FRAME);
		setLocationRelativeTo(null);
		add(myPanel);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}

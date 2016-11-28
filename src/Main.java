
public class Main {
	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		Thread thread = new Thread(frame.myPanel);
		thread.start();
	}
}

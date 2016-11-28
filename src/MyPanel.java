import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class MyPanel extends JPanel implements Runnable{

    GameManager gameManager = new GameManager();
    boolean isRunning = true;
    KeyListener keyListener = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                gameManager.move(Tank.LEFT);
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                gameManager.move(Tank.RIGHT);
            } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                gameManager.move(Tank.UP);
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                gameManager.move(Tank.DOWN);
            } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                gameManager.myTankFire();
            }
            repaint();
        }
    };


    @Override
    public void update(Graphics g) {
        super.update(g);
    }

    public MyPanel() {
        setBackground(Color.BLACK);
        gameManager.initGame();
        addKeyListener(keyListener);
        setFocusable(true);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        gameManager.draw(g2d);
    }

    @Override
    public void run() {
        while (isRunning) {
            gameManager.AI();
            repaint();
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    private final Thread thread = new Thread(this);

    private final Player player;
    private final Board board = new Board();

    public GamePanel(Player player) {
        this.player = player;
        thread.start();
        setBackground(Color.BLUE);
        addKeyListener(player);
        setFocusable(true);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        while (thread != null) {

            update();
            repaint();
            if (player.isGameOver()) {
                return;
            }

            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        player.drawPlayer(g2);

        board.drawBoard1(g2);
    }

    private void update() {
        player.update();
    }
}

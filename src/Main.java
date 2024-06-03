import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        Player player = new Player();

        JFrame frame = new JFrame();
        GamePanel gamePanel = new GamePanel(player);

        frame.add(gamePanel);
        frame.setSize(1000, 700);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);



    }

}
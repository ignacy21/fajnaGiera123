import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Player implements KeyListener {

    public int x = 0;
    public int y = 0;
    private int speed = 5;
    private String direction = "down";
    private int animationCounter = 0;
    private List<BufferedImage> animations;

    public Player() {
        try {
            animations = List.of(
                    ImageIO.read(new File("src/files/bird/flappy_bird_1.png")),
                    ImageIO.read(new File("src/files/bird/flappy_bird_2.png")),
                    ImageIO.read(new File("src/files/bird/flappy_bird_3.png"))
            );

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void drawPlayer(Graphics2D g2) {

        int animationUpdate = 6;
        if (animationCounter >= animations.size() * animationUpdate) {
            animationCounter = 0;
        }

        BufferedImage bufferedImage = animations.get(animationCounter / animationUpdate);
        animationCounter++;

        g2.drawImage(bufferedImage, x, y, 80, 80, null);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_UP) {
            direction = "up";
            System.out.println("up");
        }
        if (keyCode == KeyEvent.VK_DOWN) {
            System.out.println("down");
            direction = "down";
        }
        if (keyCode == KeyEvent.VK_LEFT) {
            System.out.println("left");
            direction = "left";
        }
        if (keyCode == KeyEvent.VK_RIGHT) {
            System.out.println("right");
            direction = "right";
        }
    }

    public void update() {
        switch (direction) {
            case "up" -> y -= speed;
            case "down" -> y += speed;
            case "left" -> x -= speed;
            case "right" -> x += speed;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}

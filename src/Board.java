import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Board {

    int animationCounter = 0;


    List<BufferedImage> boardImages;

    public Board() {
        try {
            boardImages = List.of(
                    ImageIO.read(new File("src/files/board/ramka1.png")),
                    ImageIO.read(new File("src/files/board/ramka7.png")),
                    ImageIO.read(new File("src/files/board/ramka5.png")),
                    ImageIO.read(new File("src/files/board/ramka3.png"))
            );

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected void drawBoard1(Graphics2D g2) {

        int move = -5;
        if (animationCounter < 10) {
            drawEntireLine(g2, 0);
        } else if (animationCounter < 20) {
            drawEntireLine(g2, move);
        } else if (animationCounter < 30) {
            drawEntireLine(g2, move * 2);
        } else if (animationCounter < 40) {
            drawEntireLine(g2, move * 3);
        }  else if (animationCounter < 50) {
            drawEntireLine(g2, move * 4);
//        } else if (animationCounter < 60) {
//            drawEntireLine(g2, move * 5);
        } else {
            animationCounter = -1;
        }
        animationCounter++;
    }

    private void drawEntireLine(Graphics2D g2, int move) {
        drawSection(g2, 0, move);
        drawSection(g2, 1, move);
        drawSection(g2, 2, move);
        drawSection(g2, 3, move);
        drawSection(g2, 0, move);
    }

    private void drawSection(Graphics2D g2, int x, int move) {
        int bigger = 5;
        g2.drawImage(boardImages.get(x),
                50 * bigger * x + move,
                670 - 35 * bigger,
                50 * bigger,
                35 * bigger,
                null);
    }
}

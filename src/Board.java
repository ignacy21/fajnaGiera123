import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Board {

    int animationCounter = 1;


    List<BufferedImage> boardImages;

    public Board() {
        try {
            boardImages = List.of(
                    ImageIO.read(new File("src/files/board/ramka0.png")),
                    ImageIO.read(new File("src/files/board/ramka1.png")),
                    ImageIO.read(new File("src/files/board/ramka2.png")),
                    ImageIO.read(new File("src/files/board/ramka3.png")),
                    ImageIO.read(new File("src/files/board/ramka4.png")),
                    ImageIO.read(new File("src/files/board/ramka5.png")),
                    ImageIO.read(new File("src/files/board/ramka6.png")),
                    ImageIO.read(new File("src/files/board/ramka7.png"))
            );

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected void drawBoard1(Graphics2D g2) {

        switch (animationCounter){
            case 1 -> drawEntireLine(g2, 1);
            case 2 -> drawEntireLine(g2, 2);
            case 3 -> drawEntireLine(g2, 3);
            case 4 -> drawEntireLine(g2, 4);
            case 5 -> drawEntireLine(g2, 5);
            case 6 -> drawEntireLine(g2, 6);
            case 7 -> drawEntireLine(g2, 7);
            case 8 -> drawEntireLine(g2, 8);
        }
        if (animationCounter == 8)
            animationCounter = 0;
        animationCounter++;
    }

    private void drawEntireLine(Graphics2D g2, int boarNum) {
        switch (boarNum) {
            case 1 -> drawEntireLine1(g2);
            case 2 -> drawEntireLine2(g2);
            case 3 -> drawEntireLine3(g2);
            case 4 -> drawEntireLine4(g2);
            case 5 -> drawEntireLine5(g2);
            case 6 -> drawEntireLine6(g2);
            case 7 -> drawEntireLine7(g2);
            case 8 -> drawEntireLine8(g2);
        }
    }
    private void drawEntireLine1(Graphics2D g2) {
        drawSection(g2, 0, 0);
        drawSection(g2, 6, 1);
        drawSection(g2, 4, 2);
        drawSection(g2, 2, 3);
    }
    private void drawEntireLine2(Graphics2D g2) {
        drawSection(g2, 7, 0);
        drawSection(g2, 5, 1);
        drawSection(g2, 3, 2);
        drawSection(g2, 1, 3);
    }
    private void drawEntireLine3(Graphics2D g2) {
        drawSection(g2, 6, 0);
        drawSection(g2, 4, 1);
        drawSection(g2, 2, 2);
        drawSection(g2, 0, 3);
    }
    private void drawEntireLine4(Graphics2D g2) {
        drawSection(g2, 5, 0);
        drawSection(g2, 3, 1);
        drawSection(g2, 1, 2);
        drawSection(g2, 7, 3);
    }
    private void drawEntireLine5(Graphics2D g2) {
        drawSection(g2, 4, 0);
        drawSection(g2, 2, 1);
        drawSection(g2, 0, 2);
        drawSection(g2, 6, 3);
    }
    private void drawEntireLine6(Graphics2D g2) {
        drawSection(g2, 3, 0);
        drawSection(g2, 1, 1);
        drawSection(g2, 7, 2);
        drawSection(g2, 5, 3);
    }
    private void drawEntireLine7(Graphics2D g2) {
        drawSection(g2, 2, 0);
        drawSection(g2, 0, 1);
        drawSection(g2, 6, 2);
        drawSection(g2, 4, 3);
    }
    private void drawEntireLine8(Graphics2D g2) {
        drawSection(g2, 1, 0);
        drawSection(g2, 7, 1);
        drawSection(g2, 5, 2);
        drawSection(g2, 3, 3);
    }

    private void drawSection(Graphics2D g2, int boardNum, int section) {
        int bigger = 5;
        g2.drawImage(
                boardImages.get(boardNum),
                50 * bigger * section,
                670 - 35 * bigger,
                50 * bigger,
                35 * bigger,
                null
        );
    }
}

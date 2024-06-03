import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Board {


    List<BufferedImage> boardImages;
    public Board() {
        try {
            boardImages = List.of(
                    ImageIO.read(new File("src/files/board/ramka1.png")),
                    ImageIO.read(new File("src/files/board/ramka2.png")),
                    ImageIO.read(new File("src/files/board/ramka3.png")),
                    ImageIO.read(new File("src/files/board/ramka4.png")),
                    ImageIO.read(new File("src/files/board/ramka5.png")),
                    ImageIO.read(new File("src/files/board/ramka6.png")),
                    ImageIO.read(new File("src/files/board/ramka7.png")),
                    ImageIO.read(new File("src/files/board/ramka8.png"))
                    );

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected void drawBoard1(Graphics2D g2) {
        BufferedImage bufferedImage1 = boardImages.get(0);
        BufferedImage bufferedImage2 = boardImages.get(6);
        BufferedImage bufferedImage3 = boardImages.get(7);
        BufferedImage bufferedImage4 = boardImages.get(1);
        BufferedImage bufferedImage5 = boardImages.get(2);
        BufferedImage bufferedImage6 = boardImages.get(6);
        int bigger = 5;


        int x = 50 * bigger;
        g2.drawImage(bufferedImage1, 0, 670 - 35 * bigger, 50 * bigger, 35 * bigger, null);
        g2.drawImage(bufferedImage2, x, 670 - 35 * bigger, 50 * bigger, 35 * bigger, null);
        g2.drawImage(bufferedImage3, 2 * x, 670 - 35 * bigger, 50 * bigger, 35 * bigger, null);
//        g2.drawImage(bufferedImage4, 3 * x, 670 - 35 * bigger, 50 * bigger, 35 * bigger, null);
//        g2.drawImage(bufferedImage5, 4 * x, 670 - 35 * bigger, 50 * bigger, 35 * bigger, null);
    }
}

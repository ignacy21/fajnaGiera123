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
                    ImageIO.read(new File("src/files/board/ramka2.png"))
            );

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected void drawBoard1(Graphics2D g2) {
        BufferedImage bufferedImage = boardImages.get(0);
        int bigger = 5;

        g2.drawImage(bufferedImage, 0, 670 - 35 * bigger, 50 * bigger, 35 * bigger, null);

    }
}

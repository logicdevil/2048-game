import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by daymond on 07.09.2016.
 */
public class Bar {
    public int x;
    public int y;
    Image image;
    Game_2048 game;
    int img;
    public Bar(int x, int y, Image image,int img, Game_2048 game) {
        this.x = x;
        this.y = y;
        this.game = game;
        this.image = image;
        this.img = img;

    }

    public void paint(Graphics g) {

        g.drawImage(image, 150*x, 150*y, null);
    }



}

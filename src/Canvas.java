import javax.swing.*;
import java.awt.*;
/**
 * Created by daymond on 07.09.2016.
 */
public class Canvas extends JPanel {

    Game_2048 game_2048;
    public Canvas(Game_2048 game_2048) {
        this.game_2048 = game_2048;
    }


    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        game_2048.bars.paint(g);

    }
}

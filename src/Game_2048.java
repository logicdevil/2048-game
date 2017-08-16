import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by daymond on 07.09.2016.
 */
public class Game_2048 {
    private String TITLE_OF_THE_PROGRAM = "2048";
    public int START_SCORE = 0;
    private int SQARE_HEIGHT = 150;
    private int SQARE_WIDHT = 150;
    private int FIELD_WIDHT = 4*SQARE_WIDHT;
    private int FIELD_HEIGHT = 4*SQARE_HEIGHT;

    Bars bars;
    Canvas canvas;
    JFrame frame;

    public void go() {

        frame = new JFrame(TITLE_OF_THE_PROGRAM + "   :   Score = " + START_SCORE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(FIELD_WIDHT+6, FIELD_HEIGHT+28);
        frame.setLocation(350,50);
        //frame.setResizable(false);
        canvas = new Canvas(this);
        canvas.setBackground(Color.WHITE);
        frame.getContentPane().add(BorderLayout.CENTER, canvas);
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                bars.direction(e.getKeyCode());
            }
        });
        bars = new Bars(this);


        frame.setVisible(true);
        bars.newBar(true,true);

        while(true)
        {

            try{
                Thread.sleep(10);
            }catch (Exception e){}
            frame.setTitle(TITLE_OF_THE_PROGRAM + "   :   Score = " + START_SCORE);
            canvas.repaint();
        }
    }
}

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by daymond on 11.09.2016.
 */
public class Bars {
    ArrayList<Bar> listOfBar = new ArrayList<>();
    Game_2048 game_2048;
    ArrayList<Image> listOfImage = new ArrayList<>();
    Random r = new Random();
    public Bars(Game_2048 game_2048){
        this.game_2048 = game_2048;
        loadImage();
        for (int i = 0, j = 0, k = -1; i < 16; i++)  {
            if(i%4==0)  {
                j=0;
                k++;
            }
            listOfBar.add(new Bar(j,k,listOfImage.get(0),0, game_2048));
            j++;
        }
    }
    public void loadImage() {
        try {
            listOfImage.add(ImageIO.read(new File("./images/empty_bar.png")));
            listOfImage.add(ImageIO.read(new File("./images/2_bar.png")));
            listOfImage.add(ImageIO.read(new File("./images/4_bar.png")));
            listOfImage.add(ImageIO.read(new File("./images/8_bar.png")));
            listOfImage.add(ImageIO.read(new File("./images/16_bar.png")));
            listOfImage.add(ImageIO.read(new File("./images/32_bar.png")));
            listOfImage.add(ImageIO.read(new File("./images/64_bar.png")));
            listOfImage.add(ImageIO.read(new File("./images/128_bar.png")));
            listOfImage.add(ImageIO.read(new File("./images/256_bar.png")));
            listOfImage.add(ImageIO.read(new File("./images/512_bar.png")));
            listOfImage.add(ImageIO.read(new File("./images/1024_bar.png")));
            listOfImage.add(ImageIO.read(new File("./images/2048_bar.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void paint(Graphics q) {
        for(Bar bar : listOfBar) {
            bar.paint(q);
        }
    }
    public void direction(int keyCode) {
        switch (keyCode) {
            case 37 : moveLeft(); break;
            case 38 : moveUp(); break;
            case 39 : moveRight(); break;
            case 40 : moveDown(); break;
            default:break;
        }
    }
    public void moveLeft(){

        boolean createNewBarOrNot = false;
        boolean createNewBarOrNot2 = false;
       for(int j = 0; j <=12; j+=4)
        {

            createNewBarOrNot2 |= ifEqualsLeft(j);
             for(int k = 0; k < 3; k++) {
                for (int i = 0; i < 3; i++) {
                    if (listOfBar.get(i + j).img == 0 && listOfBar.get(i + 1 + j).img != 0) {
                        listOfBar.get(i + j).img = listOfBar.get(i + 1 + j).img;
                        listOfBar.get(i + j).image = listOfBar.get(i + 1 + j).image;

                        listOfBar.get(i + 1 + j).img = 0;
                        listOfBar.get(i + 1 + j).image = listOfImage.get(0);
                        createNewBarOrNot = true;
                    }
                }
            }
        }
            newBar(createNewBarOrNot,createNewBarOrNot2);
    }





    public void moveUp(){
        boolean createNewBarOrNot = false;
        boolean createNewBarOrNot2 = false;
        for(int j = 0; j < 4; j++)
        {

            createNewBarOrNot2 |= ifEqualsUp(j);
            for(int k = 0; k < 3; k++) {
                for (int i = 0; i <= 8; i+=4) {
                    if (listOfBar.get(i+j).img == 0 && listOfBar.get(i+j+4).img != 0) {
                        listOfBar.get(i+j).img = listOfBar.get(i+j+4).img;
                        listOfBar.get(i+j).image = listOfBar.get(i+j+4).image;
                        listOfBar.get(i+j+4).img = 0;
                        listOfBar.get(i+j+4).image = listOfImage.get(0);

                        createNewBarOrNot = true;
                    }
                }
            }
        }
        newBar(createNewBarOrNot,createNewBarOrNot2);
    }





    public void moveRight(){
        boolean createNewBarOrNot = false;
        boolean createNewBarOrNot2 = false;
        for(int j = 12; j >=0; j-=4)
        {

            createNewBarOrNot2 |= ifEqualsRight(j);
            for(int k = 0; k < 3; k++) {
                for (int i = 3; i > 0; i--) {
                    if (listOfBar.get(i + j).img == 0 && listOfBar.get(i - 1 + j).img != 0) {
                        listOfBar.get(i + j).img = listOfBar.get(i - 1 + j).img;
                        listOfBar.get(i + j).image = listOfBar.get(i - 1 + j).image;

                        listOfBar.get(i - 1 + j).img = 0;
                        listOfBar.get(i - 1 + j).image = listOfImage.get(0);
                        createNewBarOrNot = true;
                    }
                }
            }
        }

            newBar(createNewBarOrNot,createNewBarOrNot2);
    }





    public void moveDown(){
        boolean createNewBarOrNot = false;
        boolean createNewBarOrNot2 = false;
        for(int j = 3; j >= 0; j--)
        {

            createNewBarOrNot2 |= ifEqualsDown(j);
            for(int k = 0; k < 3; k++) {
                for (int i = 12; i > 0; i-=4) {
                    if (listOfBar.get(i+j).img == 0 && listOfBar.get(i+j-4).img != 0) {
                        listOfBar.get(i+j).img = listOfBar.get(i+j-4).img;
                        listOfBar.get(i+j).image = listOfBar.get(i+j-4).image;
                        listOfBar.get(i+j-4).img = 0;
                        listOfBar.get(i+j-4).image = listOfImage.get(0);

                        createNewBarOrNot = true;
                    }
                }
            }
        }
        newBar(createNewBarOrNot,createNewBarOrNot2);
    }





    public boolean ifEqualsLeft(int j) {
        boolean createNewBarOrNot = false;
        boolean createNewBarOrNot2 = false;
        createNewBarOrNot2 = ifEqualsUniqueCasesForHorizontal(createNewBarOrNot2,j);
        for(int i = 0; i < 3; i++) {
            if ((listOfBar.get(i + j).img == listOfBar.get(i + j + 1).img) && listOfBar.get(i + j).img != 0) {
                System.out.println("\nLeft before: " + (i+j) + "  >>  " + listOfBar.get(i+j).img + " " + listOfBar.get(i+j).image.hashCode());
                int dop = ++listOfBar.get(i + j).img;
                listOfBar.get(i + j).image = listOfImage.get(dop);
                System.out.println("Left after: " + (i+j) + "  >>  " + listOfBar.get(i+j).img + " " + listOfBar.get(i+j).image.hashCode());
                game_2048.START_SCORE+=(int)Math.pow(2,dop);
                listOfBar.get(i + 1 + j).img = 0;
                listOfBar.get(i + 1 + j).image = listOfImage.get(0);
                createNewBarOrNot = true;

            }
        }

        return createNewBarOrNot||createNewBarOrNot2;
    }



 public boolean ifEqualsRight(int j) {
        boolean createNewBarOrNot = false;
        boolean createNewBarOrNot2 = false;
        createNewBarOrNot2 = ifEqualsUniqueCasesForHorizontal(createNewBarOrNot2,j);
        for(int i = 3; i > 0; i--) {
            if((listOfBar.get(i+j).img==listOfBar.get(i+j-1).img)&&listOfBar.get(i+j).img!=0) {
                System.out.println("\nRight before: " + (i+j) + "  >>  " + listOfBar.get(i+j).img + " " + listOfBar.get(i+j).image.hashCode());
                int dop = ++listOfBar.get(i+j).img;
                listOfBar.get(i+j).image = listOfImage.get(dop);
                System.out.println("Right after: " + (i+j) + "  >>  " + listOfBar.get(i+j).img + " " + listOfBar.get(i+j).image.hashCode());
                game_2048.START_SCORE+=(int)Math.pow(2,dop);
                listOfBar.get(i+j-1).img = 0;
                listOfBar.get(i+j-1).image = listOfImage.get(0);
                createNewBarOrNot = true;

            }
        }

        return createNewBarOrNot||createNewBarOrNot2;
    }

    public boolean ifEqualsUp(int j) {
        boolean createNewBarOrNot = false;
        boolean createNewBarOrNot2 = false;
        createNewBarOrNot2 = ifEqualsUniqueCasesForVertical(createNewBarOrNot2,j);
        for(int i = 0; i <= 8; i+=4) {
            if((listOfBar.get(i+j).img==listOfBar.get(i+j+4).img)&&listOfBar.get(i+j).img!=0) {
                System.out.println("\nUp before: " + (i+j) + "  >>  " + listOfBar.get(i+j).img + " " + listOfBar.get(i+j).image.hashCode());
                int dop = ++listOfBar.get(i+j).img;
                listOfBar.get(i+j).image = listOfImage.get(dop);
                System.out.println("Up after: " + (i+j) + "  >>  " + listOfBar.get(i+j).img + " " + listOfBar.get(i+j).image.hashCode());
                game_2048.START_SCORE+=(int)Math.pow(2,dop);
                listOfBar.get(i+j+4).img = 0;
                listOfBar.get(i+j+4).image = listOfImage.get(0);
                createNewBarOrNot = true;

            }
        }
        return createNewBarOrNot||createNewBarOrNot2;
    }


    public boolean ifEqualsDown(int j) {
        boolean createNewBarOrNot = false;
        boolean createNewBarOrNot2 = false;
        createNewBarOrNot2 = ifEqualsUniqueCasesForVertical(createNewBarOrNot2,j);
        for(int i = 12; i > 0; i-=4) {
            if((listOfBar.get(i+j).img==listOfBar.get(i+j-4).img)&&listOfBar.get(i+j).img!=0) {
                System.out.println("\nDown before: " + (i+j) + "  >>  " + listOfBar.get(i+j).img + " " + listOfBar.get(i+j).image.hashCode());
                int dop = ++listOfBar.get(i+j).img;
                listOfBar.get(i+j).image = listOfImage.get(dop);
                System.out.println("Down after: " + (i+j) + "  >>  " + listOfBar.get(i+j).img + " " + listOfBar.get(i+j).image.hashCode());
                game_2048.START_SCORE+=(int)Math.pow(2,dop);
                listOfBar.get(i+j-4).img = 0;
                listOfBar.get(i+j-4).image = listOfImage.get(0);
                createNewBarOrNot = true;

            }
        }
        return createNewBarOrNot||createNewBarOrNot2;
    }





    public void newBar(boolean createNewBarOrNor, boolean createNewBarOrNot2) {
        boolean allRight = false;
        int count = 0;
        for(Bar bar: listOfBar){
            if(bar.img==0)
                count++;
        }
        if(count!=0){
            if(createNewBarOrNor||createNewBarOrNot2){
                while(!allRight) {
                    int rand1 =  r.nextInt(15 + 1);
                    int rand2 = 1 + r.nextInt(2 - 1 + 1);
                    if (listOfBar.get(rand1).img == 0) {
                        listOfBar.get(rand1).image = listOfImage.get(rand2);
                        listOfBar.get(rand1).img = rand2;
                        allRight = true;
                    }
               }
            }
        }
        else
            System.out.println("GameOver");

    }
    public boolean ifEqualsUniqueCasesForHorizontal(boolean createNewBarOrNot, int j) {
        if((createNewBarOrNot == false)&&(listOfBar.get(j).img==listOfBar.get(j+2).img)&&listOfBar.get(j+1).img==0&&listOfBar.get(j).img!=0){
            int dop = ++listOfBar.get(j).img;
            game_2048.START_SCORE+=(int)Math.pow(2,dop);
            listOfBar.get(j).image = listOfImage.get(listOfBar.get(j).img);
            listOfBar.get(2+j).img = 0;
            listOfBar.get(2+j).image = listOfImage.get(0);
            createNewBarOrNot = true;
        }
        if((createNewBarOrNot == false)&&(listOfBar.get(j+1).img==listOfBar.get(j+3).img)&&listOfBar.get(j+2).img==0&&listOfBar.get(j+1).img!=0) {
            int dop = ++listOfBar.get(j+1).img;
            game_2048.START_SCORE+=(int)Math.pow(2,dop);
            listOfBar.get(j+1).image = listOfImage.get(listOfBar.get(j).img);
            listOfBar.get(3+j).img = 0;
            listOfBar.get(3+j).image = listOfImage.get(0);
            createNewBarOrNot = true;
        }
        if((createNewBarOrNot == false)&&(listOfBar.get(j).img==listOfBar.get(j+3).img)&&listOfBar.get(j+1).img==0&&listOfBar.get(j+2).img==0&&listOfBar.get(j).img!=0) {
            int dop = ++listOfBar.get(j).img;
            game_2048.START_SCORE+=(int)Math.pow(2,dop);
            listOfBar.get(j).image = listOfImage.get(dop);
            listOfBar.get(3+j).img = 0;
            listOfBar.get(3+j).image = listOfImage.get(0);
            createNewBarOrNot = true;
        }

        return createNewBarOrNot;
    }
public boolean ifEqualsUniqueCasesForVertical(boolean createNewBarOrNot, int j) {
        if((listOfBar.get(j).img==listOfBar.get(j+8).img)&&listOfBar.get(j+4).img==0&&listOfBar.get(j).img!=0){
            int dop = ++listOfBar.get(j).img;
            game_2048.START_SCORE+=(int)Math.pow(2,dop);
            listOfBar.get(j).image = listOfImage.get(dop);
            listOfBar.get(8+j).img = 0;
            listOfBar.get(8+j).image = listOfImage.get(0);
            createNewBarOrNot = true;
        }
        if((listOfBar.get(j+4).img==listOfBar.get(j+12).img)&&listOfBar.get(j+8).img==0&&listOfBar.get(j+4).img!=0) {
            int dop =  ++listOfBar.get(j+4).img;
            game_2048.START_SCORE+=(int)Math.pow(2,dop);
            listOfBar.get(j+4).image = listOfImage.get(dop);
            listOfBar.get(12+j).img = 0;
            listOfBar.get(12+j).image = listOfImage.get(0);
            createNewBarOrNot = true;
        }
        if((listOfBar.get(j).img==listOfBar.get(j+12).img)&&listOfBar.get(j+4).img==0&&listOfBar.get(j+8).img==0&&listOfBar.get(j).img!=0) {
            int dop = ++listOfBar.get(j).img;
            game_2048.START_SCORE+=(int)Math.pow(2,dop);
            listOfBar.get(j).image = listOfImage.get(dop);
            listOfBar.get(12+j).img = 0;
            listOfBar.get(12+j).image = listOfImage.get(0);
            createNewBarOrNot = true;
        }

        return createNewBarOrNot;
    }

}

import javax.swing.*;
import java.awt.*;

//BY Jackson Coleman 2/16 for Mr Blick E block GUI game.

public class GUIFront extends JFrame{



        private int windowWidth, windowHeight;

        Round r1, r2;

        public GUIFront(int windowWidth, int windowHeight, Image side[], Round r1, Round r2, GUIMain m)
        {
            //Constructor takes in array of images, 2 rounds of the game, and main file of backend and initializes them
            Image[] s = new Image[6];
            this.windowWidth = windowWidth;
            this.windowHeight = windowHeight;
            this.r1 = r1;
            this.r2 = r2;

            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setTitle("GUIPROJECT");
            this.setSize(this.windowWidth, this.windowHeight);
            this.setVisible(true);
            this.repaint();

        }
        public void paint(Graphics g){
            //paint draws the window, the instructions, the di, and a suprise!
            g.setColor(Color.blue);
            g.fillRect(0,0,windowWidth,windowHeight);
            g.setColor(Color.black);
            g.setColor(Color.red);
            g.drawString("Welcome to the Dice Game: Navigate through the Terminal:", 400, 50);
            g.setColor(Color.yellow);
            g.drawString("These are the Death squares", 450, 200);

            //smiley face!
            g.setColor(Color.GREEN);
            g.fillOval(50, 600, 200, 200);
            g.setColor(Color.BLACK);
            g.fillOval(100, 600, 25, 25);
            g.fillOval(175, 600, 25, 25);
            g.drawArc(100, 650, 100, 50, 180, 180);

            //Spaceship
            g.setColor(Color.ORANGE);
            g.fillRect(700, 700, 200, 50);
            g.fillRect(750, 675, 100, 25);
            g.setColor(Color.RED);
            g.fillRect(775, 725, 50, 75);
            g.fillRect(800, 800, 10, 50);

            int x = 400;
            int y = 700;
            //Rainbow!
            g.setColor(Color.RED);
            g.fillArc(x, y, 200, 200, 0, 180);
            g.setColor(Color.ORANGE);
            g.fillArc(x + 10, y + 10, 180, 180, 0, 180);
            g.setColor(Color.YELLOW);
            g.fillArc(x + 20, y + 20, 160, 160, 0, 180);
            g.setColor(Color.GREEN);
            g.fillArc(x + 30, y + 30, 140, 140, 0, 180);

            g.setColor(new Color(75, 0, 130)); // Indigo
            g.fillArc(x + 50, y + 50, 100, 100, 0, 180);
            g.setColor(new Color(238, 130, 238)); // Violet
            g.fillArc(x + 60, y + 60, 80, 80, 0, 180);

            //Dice!
            r1.getDie().paintComponent(g, this);
            r2.getDie().paintComponent(g, this);

        }

    }



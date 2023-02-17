import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
public class GUIMain {


        private static int totscore;
        private static int p2totscore;

        private GUIFront window;

        private Player no1, no2;
        private  Round r, r2;
        private Image side[];

        private final int WINDOWWIDTH = 1000;
        private final int WINDOWHEIGHT = 1000;


        public GUIMain() {
            //initializes the images
            Image[] side = new Image[6];
            side[0] = new ImageIcon("Resources/dice-six-faces-one.png").getImage();
            side[1] = new ImageIcon("Resources/dice-six-faces-two.png").getImage();
            side[2] = new ImageIcon("Resources/dice-six-faces-three.png").getImage();
            side[3] = new ImageIcon("Resources/dice-six-faces-four.png").getImage();
            side[4] = new ImageIcon("Resources/dice-six-faces-five.png").getImage();
            side[5] = new ImageIcon("Resources/dice-six-faces-six.png").getImage();

            //initializes players and rounds
             no1 = new Player("alex", 0);
             no2 = new Player("gani", 0);
             r = new Round(no1, this);
             r2 = new Round(no2,  this);

             //initializes window
            this.window = new GUIFront(WINDOWWIDTH,WINDOWHEIGHT, side, r, r2, this);

        }
        public void run(){
            //repaints the window when function is run
            window.repaint();

            instructions();


            int p1Score = 0;
            int p2Score = 0;
            while(p1Score < 2 && p2Score < 2)
            {
                totscore = r.isDuplicate(window);
                r.end(totscore);

                System.out.println("\n Player 2 turn");
                p2totscore = r2.isDuplicate(window);
                r2.end(p2totscore);
                if(totscore > p2totscore)
                {
                    p1Score++;
                    System.out.println("Player one wins this round!");
                }
                if(totscore < p2totscore)
                {
                    p2Score++;
                    System.out.println("Player two wins this round!");
                }
                System.out.println("\n");
            }
            getWinner();
        window.repaint();
        }

        public static void main(String[] args)
        {

            GUIMain m = new GUIMain();
            m.run();


        }
        public static void getWinner()
        {
            if (totscore > p2totscore)
            {
                System.out.print("PLAYER ONE WINS!!!");
            }
            else
            {
                System.out.print("PLAYER TWO WINS!!!");
            }

        }



        public static void instructions()
        {
            System.out.println("This game is called a spinoff of 4 corners:");
            System.out.println("3 numbers will be death  ");
            System.out.print("The game has two players, and the winner");
            System.out.println(" is the first person to win 2 rounds");
        }




}

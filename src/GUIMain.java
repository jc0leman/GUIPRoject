import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
public class GUIMain {


        private static int totscore;
        private static int p2totscore;

        private Image side1, side2, side3, side4, side5, side6;
        public GUIMain() {
            side1 = new ImageIcon("Resources/dice-six-faces-one.png").getImage();
            side2 = new ImageIcon("Resources/dice-six-faces-two.png").getImage();
            side3 = new ImageIcon("Resources/dice-six-faces-three.png").getImage();
            side4 = new ImageIcon("Resources/dice-six-faces-four.png").getImage();
            side5 = new ImageIcon("Resources/dice-six-faces-five.png").getImage();
            side6 = new ImageIcon("Resources/dice-six-faces-six.png").getImage();

        }
        public static void main(String[] args)
        {

            Player no1 = new Player("alex", 0);
            Player no2 = new Player("gani", 0);
            instructions();


            Round r = new Round(no1);
            Round r2 = new Round(no2);

            int p1Score = 0;
            int p2Score = 0;
            while(p1Score < 2 && p2Score < 2)
            {
                totscore = r.isDuplicate();
                r.end(totscore);

                System.out.println("\n Player 2 turn");
                p2totscore = r2.isDuplicate();
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

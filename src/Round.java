
import java.util.Scanner;
public class Round {


       GUIMain m;

        private Player cur;

        //private Die d;
        Die d;


        public Round(Player cur,  GUIMain m)
        {
            this.cur = cur;
            this.m = m;
            d = new Die(12, m);

        }
        //need to send scanner to isduplicate (not in round)
        public int isDuplicate(GUIFront window)
        {
             d = new Die(12, m);
            Scanner s = new Scanner(System.in);
            int score = 0;
            int num = -1;
            //gets num of sides on the die, it will always = 12 but added-
            //so we can use dif side die
            int sides;
            sides = d.getSides();
            System.out.print("Choose a number 1-" + sides + ": ");
            num = s.nextInt();
            window.repaint();
            //honestly, checkDup could be a bool but it is an int
            while (d.checkDup(num) != 1)
            {
                window.repaint();
                System.out.print("Choose a number 1-12: ");
                num = s.nextInt();
                score = changeScore(score);
                window.repaint();
            }
            return score;
        }
        public int changeScore(int score)
        {
            score++;
            return score;
        }

        public void end(int printScore)
        {
            System.out.println("Your final score is: " + d.endscore(printScore));
        }
        public Die getDie() {
            return d;
        }


}

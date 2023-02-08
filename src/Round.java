
import java.util.Scanner;
public class Round {


        private String playername;
        private int playerscore;

        private Player cur;

        //private Die d;

        Die d = new Die(12);

        public Round(Player cur)
        {
            this.cur = cur;
        }
        //need to send scanner to isduplicate (not in round)
        public int isDuplicate()
        {
            Scanner s = new Scanner(System.in);
            int score = 0;
            int num = -1;
            //gets num of sides on the die, it will always = 12 but added-
            //so we can use dif side die
            int sides;
            sides = d.getSides();
            System.out.print("Choose a number 1-" + sides + ": ");
            num = s.nextInt();
            //honestly, checkDup could be a bool but it is an int
            while (d.checkDup(num) != 1)
            {
                System.out.print("Choose a number 1-12: ");
                num = s.nextInt();
                score = changeScore(score);
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


}

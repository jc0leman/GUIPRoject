import javax.swing.*;
import java.awt.*;

public class Die
{
    /** Instance Variables **/
    private int sides;
    public int i, j, k;

    public final int DieXLoc = 200;
    public final int DieYLoc = 400;

    public final int DHeight = 100;

    public final int DWidth = 100;


    private Image[] s;

    private GUIMain m;


    /** Constructors **/
    public Die(GUIMain m)
    {

         s = new Image[6];
        this.m = m;
        sides = 12;
        s[0] = new ImageIcon("Resources/dice-six-faces-one.png").getImage();
        s[1] = new ImageIcon("Resources/dice-six-faces-two.png").getImage();
        s[2] = new ImageIcon("Resources/dice-six-faces-three.png").getImage();
        s[3] = new ImageIcon("Resources/dice-six-faces-four.png").getImage();
        s[4] = new ImageIcon("Resources/dice-six-faces-five.png").getImage();
        s[5] = new ImageIcon("Resources/dice-six-faces-six.png").getImage();
        this.i = 0;
        this.j = 0;
        this.k = 0;

    }

    public Die(int numSides, GUIMain m)
    {

        s = new Image[6];
        s[0] = new ImageIcon("Resources/dice-six-faces-one.png").getImage();
        s[1] = new ImageIcon("Resources/dice-six-faces-two.png").getImage();
        s[2] = new ImageIcon("Resources/dice-six-faces-three.png").getImage();
        s[3] = new ImageIcon("Resources/dice-six-faces-four.png").getImage();
        s[4] = new ImageIcon("Resources/dice-six-faces-five.png").getImage();
        s[5] = new ImageIcon("Resources/dice-six-faces-six.png").getImage();

        this.i = 0;
        this.j = 0;
        this.k = 0;
        sides = numSides;
        this.m = m;
    }

    /** Methods **/
    public int getSides()
    {
        return sides;
    }


    /**
     * Returns a random int between 1 and
     * the number of sides on the Die
     */
    public int roll()
    {
        int num = (int)(Math.random()*sides) + 1;
        return num;

    }

    //Checkdup takes 3 die and rolls them, used to find the "Death Squares"
    public int checkDup(int userInput)
    {

        i = 0;
        j = 0;
        k = 0;

        //Use three die, when I could use 1, to meet the requirement
        Die a = new Die(12,  m);
        Die b = new Die(12,  m);
        Die c = new Die(12,  m);

        System.out.print("rolling: ");
        i = a.roll();
        j = b.roll();
        k = c.roll();
        //prevents duplicate number rolls
        while (j == i)
        {
            j = b.roll();
        }
        //if k = j or k = i, we re-roll
        while (k == j || k == i)
        {
            k = c.roll();
        }
        System.out.println("Death squares are...." + i + " "+ j + " "+ k);
        int isdup = 0;
        //checks to see if matches user input, if so, returns 1 (false, ig)
        if(userInput == i || userInput == j || userInput == k)
        {
            isdup = 1;
        }
        System.out.println(i + " " + j + " " + k);
        return isdup;
    }
    //here to meet the method req. it takes a value and reutrns that same value
    public int endscore(int numscore)
    {
        return numscore;
    }

    public void paintComponent(Graphics g, GUIFront window)
    {
        //for i, j, k if greater than 6 for roll, draws a 6 sided die and a di 6 smaller than the di ie. 7 turns to 6+1
        if(i > 6)
        {
            g.drawImage(s[5], DieXLoc + 100, DieYLoc - 200 , DWidth, DHeight, window);
            g.drawImage(s[i - 7], DieXLoc + 100, DieYLoc - 100, DWidth, DHeight, window);
        }
        if(j > 6)
        {
            g.drawImage(s[5], DieXLoc + 250, DieYLoc - 100, DWidth, DHeight, window);
            g.drawImage(s[j - 7], DieXLoc + 350, DieYLoc - 100, DWidth, DHeight, window);
        }
        if(k > 6)
        {
            g.drawImage(s[5], DieXLoc + 500, DieYLoc, DWidth, DHeight, window);

            g.drawImage(s[k - 7], DieXLoc + 600, DieYLoc, DWidth, DHeight, window);


        }
        //if not greater than 6, just draws the single di
        if(i > 0 && i < 7) {
            g.drawImage(s[i - 1], DieXLoc + 100, DieYLoc - 100, DWidth, DHeight, window);
        }

            if(j > 0 && j < 7 )
        {
            g.drawImage(s[j - 1], DieXLoc + 350, DieYLoc - 100, DWidth, DHeight, window);
        }
        if(k > 0 && k < 7) {

            g.drawImage(s[k - 1], DieXLoc + 600, DieYLoc, DWidth, DHeight, window);
        }
            g.setColor(Color.white);
    }

}
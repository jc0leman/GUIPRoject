public class Die
{
    /** Instance Variables **/
    private int sides;
    public int i = 0;

    /** Constructors **/
    public Die()
    {
        sides = 12;
    }

    public Die(int numSides)
    {
        sides = numSides;
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
    public int checkDup(int userinput)
    {
        //Use three die, when I could use 1, to meet the requirement
        Die a = new Die(12);
        Die b = new Die(12);
        Die c = new Die(12);
        int j = 0;
        int k = 0;
        System.out.print("rolling: ");
        int i = a.roll();
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
        if(userinput == i || userinput == j || userinput == k)
        {
            isdup = 1;
        }
        return isdup;
    }
    //here to meet the method req. it takes a value and reutrns that same value
    public int endscore(int numscore)
    {
        return numscore;
    }
}
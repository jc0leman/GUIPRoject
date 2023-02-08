public class Player
{
    private String pName;
    private int pPoints;

    public Player(String pName, int pPoints)
    {
        this.pName = pName;
        this.pPoints = pPoints;
    }
    public String getName()
    {
        return pName;
    }
    public int getPoints()
    {
        return pPoints;
    }
    public String toString()
    {
        return pName + ": " + pPoints + " points";
    }
}
public class DieTester {
    Die d;

    /**
     * Die object-essentially creating a global that can be accessed everywhere
     */
    public DieTester() {
        d = new Die(12);
    }
}
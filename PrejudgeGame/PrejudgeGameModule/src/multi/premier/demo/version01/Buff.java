package multi.premier.demo.version01;

public abstract class Buff {
    int target=100;
    int appearTime;
    boolean isActive;
    String name;
    Player sufferer;

    public abstract void account() throws GameIsEndException;
}

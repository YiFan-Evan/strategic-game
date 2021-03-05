package multi.premier.demo.version02;

public abstract class Buff {
    int target=100;
    int appearTime;
    Player sufferer;
    boolean isActive;
    public abstract void account() throws GameIsEndException;
    String name;
}

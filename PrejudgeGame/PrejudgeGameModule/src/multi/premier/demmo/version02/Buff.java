package multi.premier.demmo.version02;

public abstract class Buff {
    int target=100;
    int appearTime;
    boolean isActive;
    String name;
    Player sufferer;
    GameSystem gameSystem;

    public abstract void account() throws GameIsEndException;
}

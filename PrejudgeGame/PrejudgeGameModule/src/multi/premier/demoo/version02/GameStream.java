package multi.premier.demoo.version02;

public abstract class GameStream {
    int var;
    Player from;
    Player to;
    String name;

    void change(){
        Player temp=from;
        from=to;
        to=temp;
    }

    abstract void account();

}

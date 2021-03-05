package multi.premier.demmo.version01;
/*
掉2血加8mp
 */
public class Priest extends Occupation {
    public Priest() {
        name="priest";
    }

    @Override
    void skill(int code) {
        GameSystem.players.get(code-1).hp-=2;
        GameSystem.players.get(code-1).mp+=8;
    }
}

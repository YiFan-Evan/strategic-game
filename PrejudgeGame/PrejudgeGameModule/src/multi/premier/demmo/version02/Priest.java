package multi.premier.demmo.version02;

/*
掉2血加8mp
 */
public class Priest extends Occupation {
    public Priest(GameSystem gameSystem) {
        name="priest";
        super.gameSystem=gameSystem;
    }

    @Override
    void skill(int code) {
        gameSystem.players.get(code-1).hp-=2;
        gameSystem.players.get(code-1).mp+=8;
    }
}

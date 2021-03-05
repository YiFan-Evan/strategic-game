package multi.premier.demmo.version02;

/*
3回合内mp无限
 */
public class Knight extends Occupation {
    public Knight(GameSystem gameSystem) {
        name="knight";
        super.gameSystem=gameSystem;
    }

    @Override
    void skill(int code) {
        gameSystem.buffs.add(new KnightBuff(code, gameSystem.players.get(code-1).mp,gameSystem));
    }
}



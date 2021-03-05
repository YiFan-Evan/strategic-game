package multi.premier.demmo.version01;

/*
3回合内mp无限
 */
public class Knight extends Occupation {
    public Knight() {
        name="knight";
    }

    @Override
    void skill(int code) {
        GameSystem.buffs.add(new KnightBuff(code, GameSystem.players.get(code-1).mp));
    }
}



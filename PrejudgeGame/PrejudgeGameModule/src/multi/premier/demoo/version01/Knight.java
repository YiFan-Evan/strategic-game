package multi.premier.demoo.version01;

public class Knight extends Occupation {
    public Knight() {
        name="knight";
    }

    @Override
    void skill(int code) {
        GameSystem.buffs.add(new KnightBuff(code, GameSystem.players.get(code-1).mp));
    }
}



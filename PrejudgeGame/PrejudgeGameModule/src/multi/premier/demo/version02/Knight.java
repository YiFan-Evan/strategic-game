package multi.premier.demo.version02;

public class Knight extends Occupation {
    public Knight() {
        name="knight";
    }

    @Override
    void skill(int code) {
        GameSystem.buffs.add(new KnightBuff(code, GameSystem.players.get(code-1).mp));
    }
}



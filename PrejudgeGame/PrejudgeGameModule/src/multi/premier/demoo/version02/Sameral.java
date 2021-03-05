package multi.premier.demoo.version02;

public class Sameral extends Occupation {
    public Sameral() {
        name="sameral";
    }

    @Override
    void skill(int code) {
        GameSystem.buffs.add(new SameralBuff(code, GameSystem.players.get(code-1).hp));
        GameSystem.players.get(code-1).hp=1;
    }
}

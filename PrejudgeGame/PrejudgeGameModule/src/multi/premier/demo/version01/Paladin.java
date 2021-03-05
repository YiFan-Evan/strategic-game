package multi.premier.demo.version01;

public class Paladin extends Occupation {
    public Paladin() {
        name="paladin";
    }

    @Override
    void skill(int code) {
        GameSystem.buffs.add(new PaladinBuff(code));
    }
}

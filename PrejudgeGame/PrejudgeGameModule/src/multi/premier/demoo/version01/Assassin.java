package multi.premier.demoo.version01;

public class Assassin extends Occupation {
    public Assassin() {
        name="assassin";
    }

    @Override
    void skill(int code) {
        GameSystem.buffs.add(new AssassinBuff(code));
    }
}

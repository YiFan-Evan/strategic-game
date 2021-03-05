package multi.premier.demo.version02;

public class Assassin extends Occupation {
    public Assassin() {
        name="assassin";
    }

    @Override
    void skill(int code) {
        GameSystem.buffs.add(new AssassinBuff(code));
    }
}

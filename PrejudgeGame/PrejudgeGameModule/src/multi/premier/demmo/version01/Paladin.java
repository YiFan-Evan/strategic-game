package multi.premier.demmo.version01;
/*
当回合以后免除一次对自己的stream伤害
 */
public class Paladin extends Occupation {
    public Paladin() {
        name="paladin";
    }

    @Override
    void skill(int code) {
        GameSystem.buffs.add(new PaladinBuff(code));
    }
}

package multi.premier.demmo.version01;

/*
反弹当回合所有对自己释放的stream
 */
public class Assassin extends Occupation {
    public Assassin() {
        name="assassin";
    }

    @Override
    void skill(int code) {
        GameSystem.buffs.add(new AssassinBuff(code));
    }
}

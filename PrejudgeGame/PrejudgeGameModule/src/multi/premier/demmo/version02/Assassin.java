package multi.premier.demmo.version02;

/*
反弹当回合所有对自己释放的stream
 */
public class Assassin extends Occupation {
    public Assassin(GameSystem gameSystem) {
        name="assassin";
        super.gameSystem=gameSystem;
    }

    @Override
    void skill(int code) {
        gameSystem.buffs.add(new AssassinBuff(code,gameSystem));
    }
}

package multi.premier.demmo.version02;

/*
当回合以后免除一次对自己的stream伤害
 */
public class Paladin extends Occupation {
    public Paladin(GameSystem gameSystem) {
        name="paladin";
        super.gameSystem=gameSystem;
    }

    @Override
    void skill(int code) {
        gameSystem.buffs.add(new PaladinBuff(code,gameSystem));
    }
}

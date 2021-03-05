package multi.premier.demmo.version02;

/*
下一次攻击伤害必杀
 */
public class Worrior extends Occupation {
    public Worrior(GameSystem gameSystem){
        name="worrior";
        super.gameSystem=gameSystem;
    }

    @Override
    void skill(int code) {
        gameSystem.buffs.add(new WorriorBuff(code,gameSystem));
    }
}

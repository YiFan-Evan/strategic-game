package multi.premier.demmo.version01;
/*
下一次攻击伤害必杀
 */
public class Worrior extends Occupation {
    public Worrior(){
        name="worrior";
    }

    @Override
    void skill(int code) {
        GameSystem.buffs.add(new WorriorBuff(code));
    }
}

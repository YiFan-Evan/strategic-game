package multi.premier.demmo.version01;
/*
用1血分身抵挡本回合伤害
 */
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

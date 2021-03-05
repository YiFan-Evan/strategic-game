package multi.premier.demmo.version02;

/*
用1血分身抵挡本回合伤害
 */
public class Sameral extends Occupation {
    public Sameral(GameSystem gameSystem) {
        name="sameral";
        super.gameSystem=gameSystem;
    }

    @Override
    void skill(int code) {
        gameSystem.buffs.add(new SameralBuff(code, gameSystem.players.get(code-1).hp,gameSystem));
        gameSystem.players.get(code-1).hp=1;
    }
}

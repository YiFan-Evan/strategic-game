package multi.premier.demmo.version02;

/*
强制结算
 */
public class Agent extends Occupation {
    public Agent(GameSystem gameSystem) {
        name="agent";
        super.gameSystem=gameSystem;
    }

    @Override
    void skill(int code) {
        gameSystem.buffs.add(new AgentBuff(code,gameSystem));
    }
}

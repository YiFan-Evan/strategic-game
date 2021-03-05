package multi.premier.demmo.version01;

/*
强制结算
 */
public class Agent extends Occupation {
    public Agent() {
        name="agent";
    }

    @Override
    void skill(int code) {
        GameSystem.buffs.add(new AgentBuff(code));
    }
}

package multi.premier.demo.version02;

public class Agent extends Occupation {
    public Agent() {
        name="agent";
    }

    @Override
    void skill(int code) {
        GameSystem.buffs.add(new AgentBuff(code));
    }
}

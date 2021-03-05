package multi.premier.demmo.version01;

import java.io.IOException;

/*
交换与目标的hp
 */
public class Mage extends Occupation {
    public Mage() {
        name="mage";
    }

    @Override
    void skill(int code) throws IOException {
        GameSystem.send("what's your target",code);
        int target=GameSystem.getNumber(code);
        GameSystem.buffs.add(new MageBuff(code,target));
    }
}


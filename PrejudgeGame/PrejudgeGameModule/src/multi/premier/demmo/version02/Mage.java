package multi.premier.demmo.version02;

import java.io.IOException;

/*
交换与目标的hp
 */
public class Mage extends Occupation {
    public Mage(GameSystem gameSystem) {
        name="mage";
        super.gameSystem=gameSystem;
    }

    @Override
    void skill(int code) throws IOException {
        gameSystem.send("what's your target",code);
        int target= gameSystem.getNumber(code);
        gameSystem.buffs.add(new MageBuff(code,target,gameSystem));
    }
}


package multi.premier.demmo.version02;

import java.io.IOException;

/*
若本回合目标使用了技能，目标被必杀
 */
public class Thief extends Occupation {
    public Thief(GameSystem gameSystem) {
        name="thief";
        super.gameSystem=gameSystem;
    }

    @Override
    void skill(int code) throws IOException {
        gameSystem.send("what's your target",code);
        int target= gameSystem.getNumber(code);
        gameSystem.buffs.add(new ThiefBuff(code,target,gameSystem));
    }
}


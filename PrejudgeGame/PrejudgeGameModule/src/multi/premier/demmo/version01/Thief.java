package multi.premier.demmo.version01;

import java.io.IOException;

/*
若本回合目标使用了技能，目标被必杀
 */
public class Thief extends Occupation {
    public Thief() {
        name="thief";
    }

    @Override
    void skill(int code) throws IOException {
        GameSystem.send("what's your target",code);
        int target=GameSystem.getNumber(code);
        GameSystem.buffs.add(new ThiefBuff(code,target));
    }
}


package multi.premier.demmo.version02;

import java.io.IOException;

/*
目标防御之前不回mp
 */
public class Ranger extends Occupation {
    public Ranger(GameSystem gameSystem) {
        name="ranger";
        super.gameSystem=gameSystem;
    }

    @Override
    void skill(int code) throws IOException {
        gameSystem.send("what's your target",code);
        int target= gameSystem.getNumber(code);
        gameSystem.buffs.add(new RangerBuff(code,target,gameSystem));
    }
}

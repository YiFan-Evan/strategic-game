package multi.premier.demmo.version01;

import java.io.IOException;

/*
目标防御之前不回mp
 */
public class Ranger extends Occupation {
    public Ranger() {
        name="ranger";
    }

    @Override
    void skill(int code) throws IOException {
        GameSystem.send("what's your target",code);
        int target=GameSystem.getNumber(code);
        GameSystem.buffs.add(new RangerBuff(code,target));
    }
}

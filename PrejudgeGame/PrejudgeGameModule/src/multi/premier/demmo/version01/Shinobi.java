package multi.premier.demmo.version01;

import java.io.IOException;

/*
此过后的第三回合对目标造成6点威力的攻击
 */
public class Shinobi extends Occupation {
    public Shinobi(){
        name="shinobi";
    }

    @Override
    void skill(int code) throws IOException {
        GameSystem.send("what's your target",code);
        int target=GameSystem.getNumber(code);
        GameSystem.buffs.add(new NinjaBuff(code,target));
    }
}

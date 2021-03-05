package multi.premier.demmo.version02;

import java.io.IOException;

/*
此过后的第三回合对目标造成6点威力的攻击
 */
public class Shinobi extends Occupation {
    public Shinobi(GameSystem gameSystem){
        name="shinobi";
        super.gameSystem=gameSystem;
    }

    @Override
    void skill(int code) throws IOException {
        gameSystem.send("what's your target",code);
        int target= gameSystem.getNumber(code);
        gameSystem.buffs.add(new NinjaBuff(code,target,gameSystem));
    }
}

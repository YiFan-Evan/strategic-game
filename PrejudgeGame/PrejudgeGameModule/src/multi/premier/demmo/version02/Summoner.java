package multi.premier.demmo.version02;

import java.io.IOException;

/*
将target身上附着的buff换到自己身上，可指定此buff的target为哪一位角色
 */
public class Summoner extends Occupation {
    public Summoner(GameSystem gameSystem) {
        name="summoner";
        super.gameSystem=gameSystem;
    }

    @Override
    void skill(int code) throws IOException {
        gameSystem.send("what's your target",code);
        int target= gameSystem.getNumber(code);
        gameSystem.send("what's your targettarget",code);
        int targettarget= gameSystem.getNumber(code);
        gameSystem.buffs.add(new CheaterBuff(code,target,targettarget,gameSystem));
    }
}


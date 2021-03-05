package multi.premier.demmo.version01;

import java.io.IOException;

/*
将target身上附着的buff换到自己身上，可指定此buff的target为哪一位角色
 */
public class Summoner extends Occupation {
    public Summoner() {
        name="summoner";
    }

    @Override
    void skill(int code) throws IOException {
        GameSystem.send("what's your target",code);
        int target=GameSystem.getNumber(code);
        GameSystem.send("what's your targettarget",code);
        int targettarget=GameSystem.getNumber(code);
        GameSystem.buffs.add(new CheaterBuff(code,target,targettarget));
    }
}


package multi.premier.demmo.version01;

import java.io.IOException;

/*
若下两回合自己血量未变动，则目标被必杀
 */
public class Warlock extends Occupation {
    public Warlock() {
        name="warlock";
    }

    @Override
    void skill(int code) throws IOException {
        GameSystem.send("what's your target",code);
        int target=GameSystem.getNumber(code);
        GameSystem.buffs.add(new WarlockBuff(code,target,GameSystem.players.get(code-1).hp));
    }
}


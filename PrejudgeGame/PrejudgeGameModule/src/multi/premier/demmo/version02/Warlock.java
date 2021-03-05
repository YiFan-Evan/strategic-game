package multi.premier.demmo.version02;

import java.io.IOException;

/*
若下两回合自己血量未变动，则目标被必杀
 */
public class Warlock extends Occupation {
    public Warlock(GameSystem gameSystem) {
        name="warlock";
        super.gameSystem=gameSystem;
    }

    @Override
    void skill(int code) throws IOException {
        gameSystem.send("what's your target",code);
        int target= gameSystem.getNumber(code);
        gameSystem.buffs.add(new WarlockBuff(code,target, gameSystem.players.get(code-1).hp,gameSystem));
    }
}


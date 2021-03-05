package multi.premier.demmo.version02;

import java.io.IOException;

/*
发动一次威力等于回合数的攻击
 */
public class Killer extends Occupation {
    public Killer(GameSystem gameSystem) {
        name="killer";
        super.gameSystem=gameSystem;
    }

    @Override
    void skill(int code) throws IOException {
        gameSystem.send("what's your target",code);
        int target= gameSystem.getNumber(code);
        gameSystem.streams.add(new AttackStream(gameSystem.round, gameSystem.players.get(code-1), gameSystem.players.get(target-1)));
    }
}

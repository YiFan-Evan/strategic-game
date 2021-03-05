package multi.premier.demmo.version01;

import java.io.IOException;
/*
发动一次威力等于回合数的攻击
 */
public class Killer extends Occupation {
    public Killer() {
        name="killer";
    }

    @Override
    void skill(int code) throws IOException {
        GameSystem.send("what's your target",code);
        int target=GameSystem.getNumber(code);
        GameSystem.streams.add(new AttackStream(GameSystem.round, GameSystem.players.get(code-1), GameSystem.players.get(target-1)));
    }
}

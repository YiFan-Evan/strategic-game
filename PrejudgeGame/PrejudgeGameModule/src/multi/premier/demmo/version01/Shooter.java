package multi.premier.demmo.version01;

import java.io.IOException;

/*
对目标强制扣除两血
 */
public class Shooter extends Occupation {
    public Shooter() {
        name="shooter";
    }

    @Override
    void skill(int code) throws IOException {
        GameSystem.send("what's your target",code);
        int target=GameSystem.getNumber(code);
        for(Player p: GameSystem.players){
            if(p.code==target){
                p.hp=p.hp-2;
            }
        }
    }
}

package multi.premier.demmo.version02;

import java.io.IOException;

/*
对目标强制扣除两血
 */
public class Shooter extends Occupation {
    public Shooter(GameSystem gameSystem) {
        name="shooter";
        super.gameSystem=gameSystem;
    }

    @Override
    void skill(int code) throws IOException {
        gameSystem.send("what's your target",code);
        int target= gameSystem.getNumber(code);
        for(Player p: gameSystem.players){
            if(p.code==target){
                p.hp=p.hp-2;
            }
        }
    }
}

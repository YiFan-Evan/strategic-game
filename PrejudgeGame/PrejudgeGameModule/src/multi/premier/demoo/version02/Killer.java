package multi.premier.demoo.version02;

import java.io.IOException;

public class Killer extends Occupation {
    public Killer() {
        name="killer";
    }

    @Override
    void skill(int code) throws IOException {
        int target=0;
        if(code==1){
            System.out.println("what's your target");
            target= GameSystem.getNumber(1);
        }else{
            GameSystem.send("what's your target",2);
            target= GameSystem.getNumber(2);
        }
        GameSystem.streams.add(new AttackStream(GameSystem.round, GameSystem.players.get(code-1), GameSystem.players.get(target-1)));
    }
}

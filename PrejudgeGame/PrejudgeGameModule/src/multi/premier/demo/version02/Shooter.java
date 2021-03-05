package multi.premier.demo.version02;

import java.io.IOException;

public class Shooter extends Occupation {
    public Shooter() {
        name="shooter";
    }

    @Override
    void skill(int code) throws IOException {
        int target=0;
        if(code==1){
            System.out.println("what's your target");
            target=GameSystem.getNumber(1);
        }else{
            GameSystem.send("what's your target",2);
            target=GameSystem.getNumber(2);
        }
        for(Player p:GameSystem.players){
            if(p.code==target){
                p.hp=p.hp-2;
            }
        }
    }
}

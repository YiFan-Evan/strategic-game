package multi.premier.demoo.version02;

import java.io.IOException;

public class Thief extends Occupation {
    public Thief() {
        name="thief";
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
        GameSystem.buffs.add(new ThiefBuff(code,target));
    }
}


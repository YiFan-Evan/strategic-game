package multi.premier.demo.version02;

import java.io.IOException;

public class Warlock extends Occupation {
    public Warlock() {
        name="warlock";
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
        GameSystem.buffs.add(new WarlockBuff(code,target));
    }
}


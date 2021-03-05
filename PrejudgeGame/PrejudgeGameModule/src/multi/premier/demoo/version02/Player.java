package multi.premier.demoo.version02;

import java.io.IOException;

public class Player {
    int hp;
    int mp;
    boolean isdefence;
    Occupation occupation;
    int code;

    public Player(Occupation occupation, int code) {
        this.occupation = occupation;
        hp=6;
        mp=2;
        isdefence=false;
        this.code=code;
    }

    void attack(Player target, int power) throws MPUnderZeroException {
        mp=mp-power;
        GameSystem.streams.add(new AttackStream(power,this,target));
        GameSystem.streamnumber+=1;
        if(mp<0){
            throw new MPUnderZeroException();
        }
    }
    void defence(){
        isdefence=true;
    }
    void unique(Player target){
        GameSystem.streams.add(new UniqueStream(this,target));
        GameSystem.streamnumber+=1;
    }
    void skill() throws MPUnderZeroException, IOException {
        mp=mp-3;
        if(mp<0){
            throw new MPUnderZeroException();
        }
        occupation.skill(code);
    }
}

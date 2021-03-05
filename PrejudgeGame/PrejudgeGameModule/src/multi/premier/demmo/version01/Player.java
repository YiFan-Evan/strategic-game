package multi.premier.demmo.version01;

import java.io.IOException;

public class Player {
    int hp;
    int mp;
    int code;
    boolean isdefence;
    Occupation occupation;

    public Player(Occupation occupation,int code) {
        this.occupation = occupation;
        hp=6;
        mp=2;
        isdefence=false;
        this.code=code;
    }
    void attack(Player target, int power) throws MPUnderZeroException {
        mp=mp-power;
        if(mp<0){
            throw new MPUnderZeroException();
        }
        GameSystem.streams.add(new AttackStream(power,this,target));
        GameSystem.streamnumber+=1;
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

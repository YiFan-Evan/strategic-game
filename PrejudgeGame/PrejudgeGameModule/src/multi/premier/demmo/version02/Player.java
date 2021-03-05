package multi.premier.demmo.version02;

import java.io.IOException;

public class Player {
    int hp;
    int mp;
    int code;
    boolean isdefence;
    Occupation occupation;
    GameSystem gameSystem;

    public Player(Occupation occupation, int code,GameSystem gameSystem) {
        this.occupation = occupation;
        hp=6;
        mp=2;
        isdefence=false;
        this.code=code;
        this.gameSystem=gameSystem;
    }
    void attack(Player target, int power) throws MPUnderZeroException {
        mp=mp-power;
        if(mp<0){
            throw new MPUnderZeroException();
        }
        gameSystem.streams.add(new AttackStream(power,this,target));
        gameSystem.streamnumber+=1;
    }
    void defence(){
        isdefence=true;
    }
    void unique(Player target){
        gameSystem.streams.add(new UniqueStream(this,target));
        gameSystem.streamnumber+=1;
    }
    void skill() throws MPUnderZeroException, IOException {
        mp=mp-3;
        if(mp<0){
            throw new MPUnderZeroException();
        }
        occupation.skill(code);
    }
}

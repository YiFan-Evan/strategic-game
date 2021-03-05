package multi.premier.demmo.version02;

public class WarlockBuff extends Buff {
    int count;
    int prehp;

    public WarlockBuff(int code,int target,int prehp,GameSystem gameSystem){
        super.gameSystem=gameSystem;
        isActive=true;
        sufferer= gameSystem.players.get(code-1);
        name="warlockbuff";
        appearTime= gameSystem.round;
        super.target=target;
        count=2;
        this.prehp=prehp;
    }

    @Override
    public void account() {
        if(count==2){
            count-=1;
        }else if(count==1&&sufferer.hp==prehp){
            count-=1;
        }else if(count==0&&sufferer.hp==prehp){
            gameSystem.players.get(target-1).hp-=999;
        }
        isActive=false;
    }
}

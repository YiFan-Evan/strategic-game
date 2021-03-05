package multi.premier.demmo.version02;

public class NinjaBuff extends Buff {
    int count;

    public NinjaBuff(int code,int target,GameSystem gameSystem){
        super.gameSystem=gameSystem;
        isActive=true;
        sufferer= gameSystem.players.get(code-1);
        name="ninjabuff";
        appearTime= gameSystem.round;
        super.target=target;
        count=3;
    }

    @Override
    public void account() {
        if(count==3){
            count-=1;
        }else if(count==2){
            count-=1;
        }else if(count==1){
            count-=1;
        }else if(count==0){
            gameSystem.streams.add(new AttackStream(6,sufferer, gameSystem.players.get(target-1)));
            isActive=false;
        }
    }

}

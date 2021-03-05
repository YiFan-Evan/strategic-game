package multi.premier.demo.version02;

public class NinjaBuff extends Buff {
    int count;
    public NinjaBuff(int code,int target){
        isActive=true;
        sufferer= GameSystem.players.get(code-1);
        name="ninjabuff";
        appearTime= GameSystem.round;
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
            GameSystem.streams.add(new AttackStream(6,sufferer, GameSystem.players.get(target-1)));
            isActive=false;
        }
    }

}

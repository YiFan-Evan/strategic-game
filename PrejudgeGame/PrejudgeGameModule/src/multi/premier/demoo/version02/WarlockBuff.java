package multi.premier.demoo.version02;

public class WarlockBuff extends Buff {
    int count;
    public WarlockBuff(int code,int target){
        isActive=true;
        sufferer= GameSystem.players.get(code-1);
        name="warlockbuff";
        appearTime= GameSystem.round;
        super.target=target;
        count=2;
    }

    @Override
    public void account() {
        if(count==2){
            count-=1;
        }else if(count==1){
            count-=1;
        }else if(count==0){
            if(sufferer.hp>0){
                for (Player p: GameSystem.players){
                    if (p.code==target){
                        p.hp-=999;
                    }
                }
            }
            isActive=false;
        }
    }
}

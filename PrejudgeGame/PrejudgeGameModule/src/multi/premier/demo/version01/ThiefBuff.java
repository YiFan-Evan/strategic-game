package multi.premier.demo.version01;

public class ThiefBuff extends Buff {
    boolean targetonbuff;
    boolean targethavestream;

    public ThiefBuff(int code,int target){
        isActive=true;
        sufferer=GameSystem.players.get(code-1);
        name="thiefbuff";
        appearTime=GameSystem.round;
        super.target=target;
        targetonbuff=false;
        targethavestream=false;
    }

    @Override
    public void account() {
        for(Buff b:GameSystem.buffs){
            if(b.isActive&&b.sufferer.code==target&&b.appearTime==GameSystem.round){
                targetonbuff=true;
            }
        }
        for (GameStream s:GameSystem.streams){
            if(s.from.code==target){
                targethavestream=true;
            }
        }
        if(targetonbuff||(!GameSystem.players.get(target-1).isdefence&&!targethavestream)){
            GameSystem.players.get(target-1).hp-=999;
        }
        isActive=false;
    }
}

package multi.premier.demmo.version02;

public class ThiefBuff extends Buff {
    boolean targetonbuff;
    boolean targethavestream;

    public ThiefBuff(int code,int target,GameSystem gameSystem){
        super.gameSystem=gameSystem;
        isActive=true;
        sufferer= gameSystem.players.get(code-1);
        name="thiefbuff";
        appearTime= gameSystem.round;
        super.target=target;
        targetonbuff=false;
        targethavestream=false;
    }

    @Override
    public void account() {
        for(Buff b: gameSystem.buffs){
            if(b.isActive&&b.sufferer.code==target&&b.appearTime== gameSystem.round){
                targetonbuff=true;
            }
        }
        for (GameStream s: gameSystem.streams){
            if(s.from.code==target){
                targethavestream=true;
            }
        }
        if(targetonbuff||(!gameSystem.players.get(target-1).isdefence&&!targethavestream)){
            gameSystem.players.get(target-1).hp-=999;
        }
        isActive=false;
    }
}

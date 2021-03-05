package multi.premier.demmo.version02;

public class RangerBuff extends Buff {
    public RangerBuff(int code,int target,GameSystem gameSystem){
        super.gameSystem=gameSystem;
        isActive=true;
        sufferer= gameSystem.players.get(code-1);
        name="rangerbuff";
        appearTime= gameSystem.round;
        super.target=target;
    }

    @Override
    public void account() {
        if(!gameSystem.players.get(target-1).isdefence){
            gameSystem.players.get(target-1).mp-=2;
        }else if(gameSystem.players.get(target-1).isdefence){
            isActive=false;
        }
    }
}

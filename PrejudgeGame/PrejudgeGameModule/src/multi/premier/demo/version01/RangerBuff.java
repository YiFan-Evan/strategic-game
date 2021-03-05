package multi.premier.demo.version01;

public class RangerBuff extends Buff{
    public RangerBuff(int code,int target){
        isActive=true;
        sufferer=GameSystem.players.get(code-1);
        name="rangerbuff";
        appearTime=GameSystem.round;
        super.target=target;
    }

    @Override
    public void account() {
        if(!GameSystem.players.get(target-1).isdefence){
            GameSystem.players.get(target-1).mp-=2;
        }else if(GameSystem.players.get(target-1).isdefence){
            isActive=false;
        }
    }
}

package multi.premier.demo.version02;

public class KnightBuff extends Buff {
    int premp;
    public KnightBuff(int code, int premp){
        isActive=true;
        sufferer= GameSystem.players.get(code-1);
        name="knightbuff";
        appearTime= GameSystem.round;
        this.premp=premp;
    }
    @Override
    public void account() {
        if(GameSystem.round==appearTime+3){
            sufferer.mp=premp;
            isActive=false;
        }else{
            sufferer.mp=999;
        }
    }
}

package multi.premier.demmo.version02;

public class KnightBuff extends Buff {
    int premp;

    public KnightBuff(int code, int premp,GameSystem gameSystem){
        super.gameSystem=gameSystem;
        isActive=true;
        sufferer= gameSystem.players.get(code-1);
        name="knightbuff";
        appearTime= gameSystem.round;
        this.premp=premp;
    }

    @Override
    public void account() {
        if(gameSystem.round==appearTime+3){
            sufferer.mp=premp;
            isActive=false;
        }else{
            sufferer.mp=999;
        }
    }
}

package multi.premier.demmo.version02;

public class PaladinBuff extends Buff {
    int deffencetime=0;

    public PaladinBuff(int code,GameSystem gameSystem){
        super.gameSystem=gameSystem;
        isActive=true;
        sufferer= gameSystem.players.get(code-1);
        name="paladinbuff";
        appearTime= gameSystem.round;
    }

    @Override
    public void account() {
        if(gameSystem.round!=appearTime){
            for(GameStream s: gameSystem.streams){
                if(s.to.code==sufferer.code){
                    s.var=0;
                    deffencetime=deffencetime+1;
                }
            }
        }
        if(deffencetime>0){
            isActive=false;
        }
    }
}

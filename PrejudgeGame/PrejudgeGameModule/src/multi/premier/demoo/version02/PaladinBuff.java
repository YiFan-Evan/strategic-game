package multi.premier.demoo.version02;

public class PaladinBuff extends Buff {
    int deffencetime=0;
    public PaladinBuff(int code){
        isActive=true;
        sufferer= GameSystem.players.get(code-1);
        name="paladinbuff";
        appearTime= GameSystem.round;
    }

    @Override
    public void account() {
        if(GameSystem.round!=appearTime){
            for(GameStream s: GameSystem.streams){
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

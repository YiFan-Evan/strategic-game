package multi.premier.demmo.version02;

public class CheaterBuff extends Buff {
    int targettarget;

    public CheaterBuff(int code,int target,int targettarget,GameSystem gameSystem){
        super.gameSystem=gameSystem;
        isActive=true;
        sufferer= gameSystem.players.get(code-1);
        name="cheaterbuff";
        appearTime= gameSystem.round;
        super.target=target;
        this.targettarget=targettarget;
    }

    @Override
    public void account() {
        isActive=false;
        for (Buff b: gameSystem.buffs){
            if(b.sufferer.code==target&&b.isActive){
                b.sufferer=sufferer;
                if(b.target!=100){
                    b.target=targettarget;
                }
            }
        }
    }
}

package multi.premier.demoo.version01;

public class CheaterBuff extends Buff {
    int targettarget;

    public CheaterBuff(int code,int target,int targettarget){
        isActive=true;
        sufferer= GameSystem.players.get(code-1);
        name="cheaterbuff";
        appearTime= GameSystem.round;
        super.target=target;
        this.targettarget=targettarget;
    }

    @Override
    public void account() {
        isActive=false;
        for (Buff b: GameSystem.buffs){
            if(b.sufferer.code==target&&b.isActive){
                b.sufferer=sufferer;
                if(b.target!=100){
                    b.target=targettarget;
                }
            }
        }
    }
}

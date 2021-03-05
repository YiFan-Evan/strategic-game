package multi.premier.demmo.version01;

public class SameralBuff extends Buff {
    int prehp;

    public SameralBuff(int code,int prehp){
        isActive=true;
        sufferer= GameSystem.players.get(code-1);
        name="sameralbuff";
        appearTime= GameSystem.round;
        this.prehp=prehp;
    }

    @Override
    public void account() {
        sufferer.hp=sufferer.hp>0?prehp:prehp-1;
        isActive=false;
    }
}

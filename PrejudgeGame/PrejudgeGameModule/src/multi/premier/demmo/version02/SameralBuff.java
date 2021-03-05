package multi.premier.demmo.version02;

public class SameralBuff extends Buff {
    int prehp;

    public SameralBuff(int code,int prehp,GameSystem gameSystem){
        super.gameSystem=gameSystem;
        isActive=true;
        sufferer= gameSystem.players.get(code-1);
        name="sameralbuff";
        appearTime= gameSystem.round;
        this.prehp=prehp;
    }

    @Override
    public void account() {
        sufferer.hp=sufferer.hp>0?prehp:prehp-1;
        isActive=false;
    }
}

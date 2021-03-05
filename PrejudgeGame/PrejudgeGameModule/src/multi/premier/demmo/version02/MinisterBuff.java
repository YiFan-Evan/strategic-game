package multi.premier.demmo.version02;

public class MinisterBuff extends Buff {
    int appear;

    public MinisterBuff(int code, int hp,GameSystem gameSystem){
        super.gameSystem=gameSystem;
        isActive=true;
        sufferer= gameSystem.players.get(code-1);
        name="ministerbuff";
        appearTime= gameSystem.round;
        appear=hp;
    }

    @Override
    public void account() {
        if (sufferer.hp!=appear&&sufferer.hp>0&&sufferer.hp<6){
            sufferer.hp=6;
        }
        isActive=false;
    }
}

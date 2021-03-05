package multi.premier.demo.version01;

public class MinisterBuff extends Buff{
    int appear;

    public MinisterBuff(int code, int hp){
        isActive=true;
        sufferer=GameSystem.players.get(code-1);
        name="ministerbuff";
        appearTime=GameSystem.round;
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

package multi.premier.demmo.version02;

public class WorriorBuff extends Buff {
    public WorriorBuff(int code,GameSystem gameSystem){
        super.gameSystem=gameSystem;
        isActive=true;
        sufferer= gameSystem.players.get(code-1);
        name="worriorbuff";
        appearTime= gameSystem.round;
    }

    @Override
    public void account() {
        for (GameStream s : gameSystem.streams) {
            if(s.name=="attackstream"&&s.from.code==sufferer.code&&s.var<100&&s.var>0){
                s.var+=999;
                isActive=false;
            }
        }
    }
}

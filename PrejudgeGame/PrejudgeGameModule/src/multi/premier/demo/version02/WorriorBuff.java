package multi.premier.demo.version02;

public class WorriorBuff extends Buff {
    public WorriorBuff(int code){
        isActive=true;
        sufferer=GameSystem.players.get(code-1);
        name="worriorbuff";
        appearTime=GameSystem.round;
    }
    @Override
    public void account() {
        for (GameStream s : GameSystem.streams) {
            if(s.name=="attackstream"&&s.from.code==sufferer.code&&s.var<100&&s.var>0){
                s.var+=999;
                isActive=false;
            }
        }
    }
}

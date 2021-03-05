package multi.premier.demoo.version01;

public class AssassinBuff extends Buff {
    public AssassinBuff(int code){
        isActive=true;
        sufferer= GameSystem.players.get(code-1);
        name="assassinbuff";
        appearTime= GameSystem.round;
    }

    @Override
    public void account() {
        for(GameStream s: GameSystem.streams){
            if(s.to.code==sufferer.code){
                s.change();
            }
        }
        isActive=false;
    }
}

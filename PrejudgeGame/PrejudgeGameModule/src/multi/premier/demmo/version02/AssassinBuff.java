package multi.premier.demmo.version02;

public class AssassinBuff extends Buff {
    public AssassinBuff(int code,GameSystem gameSystem){
        super.gameSystem=gameSystem;
        isActive=true;
        sufferer= gameSystem.players.get(code-1);
        name="assassinbuff";
        appearTime= gameSystem.round;
    }

    @Override
    public void account() {
        for(GameStream s: gameSystem.streams){
            if(s.to.code==sufferer.code){
                s.change();
            }
        }
        isActive=false;
    }
}

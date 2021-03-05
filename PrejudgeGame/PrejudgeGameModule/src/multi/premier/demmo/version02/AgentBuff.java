package multi.premier.demmo.version02;

public class AgentBuff extends Buff {
    public AgentBuff(int code,GameSystem gameSystem){
        super.gameSystem=gameSystem;
        isActive=true;
        sufferer= gameSystem.players.get(code-1);
        name="agentbuff";
        appearTime= gameSystem.round;
    }

    @Override
    public void account() throws GameIsEndException {
        if(!gameSystem.isEnd()){
            isActive=false;
            gameSystem.finalAccount();
            throw new GameIsEndException();
        }else{
            isActive=false;
        }

    }
}

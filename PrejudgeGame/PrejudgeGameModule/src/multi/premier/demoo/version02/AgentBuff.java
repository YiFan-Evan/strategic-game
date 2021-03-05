package multi.premier.demoo.version02;

public class AgentBuff extends Buff {
    public AgentBuff(int code){
        isActive=true;
        sufferer= GameSystem.players.get(code-1);
        name="agentbuff";
        appearTime= GameSystem.round;
    }
    @Override
    public void account() throws GameIsEndException {
        if(!GameSystem.isEnd()){
            isActive=false;
            GameSystem.finalAccount();
            throw new GameIsEndException();
        }else{
            isActive=false;
        }

    }
}

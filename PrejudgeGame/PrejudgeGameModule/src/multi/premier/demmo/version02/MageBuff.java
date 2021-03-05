package multi.premier.demmo.version02;

public class MageBuff extends Buff {
    public MageBuff(int code,int target,GameSystem gameSystem){
        super.gameSystem=gameSystem;
        isActive=true;
        sufferer= gameSystem.players.get(code-1);
        name="magebuff";
        appearTime= gameSystem.round;
        super.target=target;
    }

    @Override
    public void account() {
        int temp;
        temp=sufferer.hp;
        sufferer.hp= gameSystem.players.get(target-1).hp;
        gameSystem.players.get(target-1).hp=temp;
        isActive=false;
    }
}

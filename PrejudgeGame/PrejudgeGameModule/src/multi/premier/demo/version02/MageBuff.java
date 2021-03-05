package multi.premier.demo.version02;

public class MageBuff extends Buff {
    public MageBuff(int code,int target){
        isActive=true;
        sufferer= GameSystem.players.get(code-1);
        name="magebuff";
        appearTime= GameSystem.round;
        super.target=target;
    }
    @Override
    public void account() {
        int temp;
        temp=sufferer.hp;
        sufferer.hp= GameSystem.players.get(target-1).hp;
        GameSystem.players.get(target-1).hp=temp;
        isActive=false;
    }
}

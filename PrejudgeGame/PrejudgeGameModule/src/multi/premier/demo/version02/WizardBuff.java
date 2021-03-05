package multi.premier.demo.version02;

public class WizardBuff extends Buff {
    public WizardBuff(int code){
        isActive=true;
        sufferer=GameSystem.players.get(code-1);
        name="wizardbuff";
        appearTime=GameSystem.round;
    }
    @Override
    public void account() {
        if(sufferer.hp<=0&&GameSystem.round!=appearTime){
            sufferer.hp=1;
            isActive=false;
        }
    }
}

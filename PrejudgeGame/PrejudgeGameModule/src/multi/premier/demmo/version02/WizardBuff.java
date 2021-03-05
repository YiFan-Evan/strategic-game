package multi.premier.demmo.version02;

public class WizardBuff extends Buff {
    public WizardBuff(int code,GameSystem gameSystem){
        super.gameSystem=gameSystem;
        isActive=true;
        sufferer= gameSystem.players.get(code-1);
        name="wizardbuff";
        appearTime= gameSystem.round;
    }

    @Override
    public void account() {
        if(sufferer.hp<=0&& gameSystem.round!=appearTime){
            sufferer.hp=1;
            isActive=false;
        }
    }
}

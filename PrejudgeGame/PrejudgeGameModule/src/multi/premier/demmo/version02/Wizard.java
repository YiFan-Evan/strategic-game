package multi.premier.demmo.version02;

/*
本回合后，受到一次必死伤害留1点血
 */
public class Wizard extends Occupation {
    public Wizard(GameSystem gameSystem) {
        name="wizard";
        super.gameSystem=gameSystem;
    }

    @Override
    void skill(int code) {
        gameSystem.buffs.add(new WizardBuff(code,gameSystem));
    }
}

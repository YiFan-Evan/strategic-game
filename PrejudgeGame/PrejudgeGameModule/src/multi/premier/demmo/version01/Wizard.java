package multi.premier.demmo.version01;
/*
本回合后，受到一次必死伤害留1点血
 */
public class Wizard extends Occupation {
    public Wizard() {
        name="wizard";
    }

    @Override
    void skill(int code) {
        GameSystem.buffs.add(new WizardBuff(code));
    }
}

package multi.premier.demoo.version02;

public class Wizard extends Occupation {
    public Wizard() {
        name="wizard";
    }

    @Override
    void skill(int code) {
        GameSystem.buffs.add(new WizardBuff(code));
    }
}

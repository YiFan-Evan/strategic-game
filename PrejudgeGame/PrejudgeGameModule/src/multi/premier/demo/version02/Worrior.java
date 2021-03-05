package multi.premier.demo.version02;

public class Worrior extends Occupation {
    public Worrior(){
        name="worrior";
    }

    @Override
    void skill(int code) {
        GameSystem.buffs.add(new WorriorBuff(code));
    }
}

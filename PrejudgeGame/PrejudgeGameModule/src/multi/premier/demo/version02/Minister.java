package multi.premier.demo.version02;

public class Minister extends Occupation{
    public Minister(){
        name="minister";
    }

    @Override
    void skill(int code) {
        GameSystem.players.get(code-1).hp+=2;
        GameSystem.buffs.add(new MinisterBuff(code, GameSystem.players.get(code-1).hp));
    }
}

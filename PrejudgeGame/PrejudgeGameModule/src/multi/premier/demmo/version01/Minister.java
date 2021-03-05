package multi.premier.demmo.version01;
/*
回复2点生命值，若本回合生命值下降且未死，回到6点生命值
 */
public class Minister extends Occupation {
    public Minister(){
        name="minister";
    }

    @Override
    void skill(int code) {
        GameSystem.players.get(code-1).hp+=2;
        GameSystem.buffs.add(new MinisterBuff(code, GameSystem.players.get(code-1).hp));
    }
}

package multi.premier.demmo.version02;

/*
回复2点生命值，若本回合生命值下降且未死，回到6点生命值
 */
public class Minister extends Occupation {
    public Minister(GameSystem gameSystem){
        name="minister";
        super.gameSystem=gameSystem;
    }

    @Override
    void skill(int code) {
        gameSystem.players.get(code-1).hp+=2;
        gameSystem.buffs.add(new MinisterBuff(code, gameSystem.players.get(code-1).hp,gameSystem));
    }
}

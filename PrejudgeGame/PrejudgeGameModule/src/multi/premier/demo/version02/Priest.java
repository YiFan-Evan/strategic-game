package multi.premier.demo.version02;

public class Priest extends Occupation {
    public Priest() {
        name="priest";
    }

    @Override
    void skill(int code) {
        GameSystem.players.get(code-1).hp-=2;
        GameSystem.players.get(code-1).mp+=8;
    }
}

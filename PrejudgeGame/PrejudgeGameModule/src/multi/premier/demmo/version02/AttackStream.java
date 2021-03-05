package multi.premier.demmo.version02;

public class AttackStream extends GameStream {
    public AttackStream(int varpara, Player frompara, Player topara) {
        var=varpara;
        from=frompara;
        to=topara;
        name="attackstream";
    }

    @Override
    void account() {
        if(!to.isdefence){
            to.hp=to.hp-var;
        }
    }
}

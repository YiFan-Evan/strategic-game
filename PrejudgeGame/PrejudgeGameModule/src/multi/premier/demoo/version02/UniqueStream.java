package multi.premier.demoo.version02;

public class UniqueStream extends GameStream {
    public UniqueStream(Player frompara, Player topara) {
        var=999;
        from=frompara;
        to=topara;
        name="uniquestream";
    }

    @Override
    void account() {
        if(to.isdefence){
            to.hp=to.hp-var;
        }else{
            from.hp=from.hp-var;
        }
    }
}

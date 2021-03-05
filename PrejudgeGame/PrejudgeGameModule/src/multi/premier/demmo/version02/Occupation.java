package multi.premier.demmo.version02;

import java.io.IOException;

public abstract class Occupation {
    String name;
    GameSystem gameSystem;

    abstract void skill(int code) throws IOException;
}

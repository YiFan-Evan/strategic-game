package multi.premier.demo.version02;

import java.io.IOException;

public abstract class Occupation {
    String name;
    abstract void skill(int code) throws IOException;

}

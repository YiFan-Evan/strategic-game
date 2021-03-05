package multi.premier.demoo.version01;

import java.util.Scanner;

public class Warlock extends Occupation {
    public Warlock() {
        name="warlock";
    }

    @Override
    void skill(int code) {
        Scanner scan =new Scanner(System.in);
        System.out.println("what's your target");
        int target=scan.nextInt();
        GameSystem.buffs.add(new WarlockBuff(code,target));
    }
}


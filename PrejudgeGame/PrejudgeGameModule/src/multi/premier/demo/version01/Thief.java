package multi.premier.demo.version01;

import java.util.Scanner;

public class Thief extends Occupation {
    public Thief() {
        name="thief";
    }

    @Override
    void skill(int code) {
        Scanner scan =new Scanner(System.in);
        System.out.println("what's your target");
        int target=scan.nextInt();
        GameSystem.buffs.add(new ThiefBuff(code,target));
    }
}


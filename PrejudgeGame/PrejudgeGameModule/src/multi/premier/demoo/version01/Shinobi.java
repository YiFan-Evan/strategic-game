package multi.premier.demoo.version01;

import java.util.Scanner;

public class Shinobi extends Occupation {
    public Shinobi(){
        name="shinobi";
    }

    @Override
    void skill(int code) {
        Scanner scan =new Scanner(System.in);
        System.out.println("what's your target");
        int target=scan.nextInt();
        GameSystem.buffs.add(new NinjaBuff(code,target));
    }
}

package multi.premier.demoo.version01;

import java.util.Scanner;

public class Summoner extends Occupation {
    public Summoner() {
        name="summoner";
    }

    @Override
    void skill(int code) {
        Scanner scan =new Scanner(System.in);
        System.out.println("what's your target");
        int target=scan.nextInt();
        System.out.println("what's your targettarget");
        int targettarget=scan.nextInt();
        GameSystem.buffs.add(new CheaterBuff(code,target,targettarget));
    }
}


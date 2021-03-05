package multi.premier.demo.version01;

import java.util.Scanner;

public class Ranger extends Occupation{
    public Ranger() {
        name="ranger";
    }

    @Override
    void skill(int code) {
        Scanner scan =new Scanner(System.in);
        System.out.println("what's your target");
        int target=scan.nextInt();
        GameSystem.buffs.add(new RangerBuff(code,target));
    }
}

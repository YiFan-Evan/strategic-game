package multi.premier.demoo.version01;

import java.util.Scanner;

public class Mage extends Occupation {
    public Mage() {
        name="mage";
    }

    @Override
    void skill(int code) {
        System.out.println("what's your target:");
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        GameSystem.buffs.add(new MageBuff(code,target));
    }
}


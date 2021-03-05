package multi.premier.demo.version01;

import java.util.Scanner;

public class Killer extends Occupation {
    public Killer() {
        name="killer";
    }

    @Override
    void skill(int code) {
        Scanner scan =new Scanner(System.in);
        System.out.println("what's your target");
        int target=scan.nextInt();
        GameSystem.streams.add(new AttackStream(GameSystem.round,GameSystem.players.get(code-1),GameSystem.players.get(target-1)));
    }
}

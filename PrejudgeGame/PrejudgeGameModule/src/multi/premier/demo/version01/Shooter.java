package multi.premier.demo.version01;

import java.util.Scanner;

public class Shooter extends Occupation{
    public Shooter() {
        name="shooter";
    }

    @Override
    void skill(int code) {
        Scanner scan =new Scanner(System.in);
        System.out.println("what's your target");
        int target=scan.nextInt();
        for(Player p:GameSystem.players){
            if(p.code==target){
                p.hp=p.hp-2;
            }
        }
    }
}

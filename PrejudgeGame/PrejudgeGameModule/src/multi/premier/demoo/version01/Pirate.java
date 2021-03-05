package multi.premier.demoo.version01;

import java.util.Random;
import java.util.Scanner;

public class Pirate extends Occupation {
    public Pirate() {
        name = "Pirate";
    }

    @Override
    void skill(int code) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        int num = random.nextInt(14);
        if (num == 0) {
            System.out.println("Congratulations! agentbuff");
            GameSystem.buffs.add(new AgentBuff(code));
        } else if (num == 1) {
            System.out.println("Congratulations! assassinbuff");
            GameSystem.buffs.add(new AssassinBuff(code));
        } else if (num == 2) {
            System.out.println("Congratulations! cheaterbuff");
            System.out.println("what's your target");
            int target = scan.nextInt();
            System.out.println("what's your targettarget");
            int targettarget = scan.nextInt();
            GameSystem.buffs.add(new CheaterBuff(code, target, targettarget));
        } else if (num == 3) {
            System.out.println("Congratulations! knightbuff");
            GameSystem.buffs.add(new KnightBuff(code, GameSystem.players.get(code - 1).mp));
        } else if (num == 4) {
            System.out.println("Congratulations! magebuff");
            System.out.println("what's your target:");
            int target = scan.nextInt();
            GameSystem.buffs.add(new MageBuff(code, target));
        } else if (num == 5) {
            System.out.println("Congratulations! ministerbuff");
            GameSystem.buffs.add(new MinisterBuff(code, GameSystem.players.get(code - 1).hp));
        } else if (num == 6) {
            System.out.println("Congratulations! ninjabuff");
            System.out.println("what's your target");
            int target=scan.nextInt();
            GameSystem.buffs.add(new NinjaBuff(code,target));
        } else if (num==7){
            System.out.println("Congratulations! paladinbuff");
            GameSystem.buffs.add(new PaladinBuff(code));
        } else if (num==8){
            System.out.println("Congratulations! rangerbuff");
            System.out.println("what's your target");
            int target=scan.nextInt();
            GameSystem.buffs.add(new RangerBuff(code,target));
        } else if (num==9){
            System.out.println("Congratulations! sameralbuff");
            GameSystem.buffs.add(new SameralBuff(code, GameSystem.players.get(code-1).hp));
        } else if (num==10){
            System.out.println("Congratulations! thiefbuff");
            System.out.println("what's your target");
            int target=scan.nextInt();
            GameSystem.buffs.add(new ThiefBuff(code,target));
        } else if (num==11){
            System.out.println("Congratulations! warlockbuff");
            System.out.println("what's your target");
            int target=scan.nextInt();
            GameSystem.buffs.add(new WarlockBuff(code,target));
        } else if (num==12){
            System.out.println("Congratulations! wizardbuff");
            GameSystem.buffs.add(new WizardBuff(code));
        } else if (num==13){
            System.out.println("Congratulations! worriorbuff");
            GameSystem.buffs.add(new WorriorBuff(code));
        }
    }
}

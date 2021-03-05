package multi.premier.demmo.version01;

import java.io.IOException;
import java.util.Random;

/*
随机给自己挂一个buff，对面目标可选
 */
public class Pirate extends Occupation {
    public Pirate() {
        name = "Pirate";
    }

    @Override
    void skill(int code) throws IOException {
        Random random = new Random();
        int num = random.nextInt(15);
        if (num == 0) {
            GameSystem.send("Congratulations! agentbuff",code);
            GameSystem.buffs.add(new AgentBuff(code));
        } else if (num == 1) {
            GameSystem.send("Congratulations! assassinbuff",code);
            GameSystem.buffs.add(new AssassinBuff(code));
        } else if (num == 2) {
            GameSystem.send("Congratulations! cheaterbuff",code);
            GameSystem.send("what's your target",code);
            int target=GameSystem.getNumber(code);
            GameSystem.send("what's your targettarget",code);
            int targettarget=GameSystem.getNumber(code);
            GameSystem.buffs.add(new CheaterBuff(code, target, targettarget));
        } else if (num == 3) {
            GameSystem.send("Congratulations! knightbuff",code);
            GameSystem.buffs.add(new KnightBuff(code, GameSystem.players.get(code - 1).mp));
        } else if (num == 4) {
            GameSystem.send("Congratulations! magebuff",code);
            GameSystem.send("what's your target:",code);
            int target=GameSystem.getNumber(code);
            GameSystem.buffs.add(new MageBuff(code, target));
        } else if (num == 5) {
            GameSystem.send("Congratulations! ministerbuff",code);
            GameSystem.buffs.add(new MinisterBuff(code, GameSystem.players.get(code - 1).hp));
        } else if (num == 6) {
            GameSystem.send("Congratulations! ninjabuff",code);
            GameSystem.send("what's your target",code);
            int target=GameSystem.getNumber(code);
            GameSystem.buffs.add(new NinjaBuff(code,target));
        } else if (num==7){
            GameSystem.send("Congratulations! paladinbuff",code);
            GameSystem.buffs.add(new PaladinBuff(code));
        } else if (num==8){
            GameSystem.send("Congratulations! rangerbuff",code);
            GameSystem.send("what's your target",code);
            int target=GameSystem.getNumber(code);
            GameSystem.buffs.add(new RangerBuff(code,target));
        } else if (num==9){
            GameSystem.send("Congratulations! sameralbuff",code);
            GameSystem.buffs.add(new SameralBuff(code, GameSystem.players.get(code-1).hp));
        } else if (num==10){
            GameSystem.send("Congratulations! thiefbuff",code);
            GameSystem.send("what's your target",code);
            int target=GameSystem.getNumber(code);
            GameSystem.buffs.add(new ThiefBuff(code,target));
        } else if (num==11){
            GameSystem.send("Congratulations! warlockbuff",code);
            GameSystem.send("what's your target",code);
            int target=GameSystem.getNumber(code);
            GameSystem.buffs.add(new WarlockBuff(code,target,GameSystem.players.get(code-1).hp));
        } else if (num==12){
            GameSystem.send("Congratulations! wizardbuff",code);
            GameSystem.buffs.add(new WizardBuff(code));
        } else if (num==13){
            GameSystem.send("Congratulations! worriorbuff",code);
            GameSystem.buffs.add(new WorriorBuff(code));
        }
    }
}

package multi.premier.demmo.version02;

import java.io.IOException;
import java.util.Random;

/*
随机给自己挂一个buff，对面目标可选
 */
public class Pirate extends Occupation {
    public Pirate(GameSystem gameSystem) {
        name = "Pirate";
        super.gameSystem=gameSystem;
    }

    @Override
    void skill(int code) throws IOException {
        Random random = new Random();
        int num = random.nextInt(15);
        if (num == 0) {
            gameSystem.send("Congratulations! agentbuff",code);
            gameSystem.buffs.add(new AgentBuff(code,gameSystem));
        } else if (num == 1) {
            gameSystem.send("Congratulations! assassinbuff",code);
            gameSystem.buffs.add(new AssassinBuff(code,gameSystem));
        } else if (num == 2) {
            gameSystem.send("Congratulations! cheaterbuff",code);
            gameSystem.send("what's your target",code);
            int target=gameSystem.getNumber(code);
            gameSystem.send("what's your targettarget",code);
            int targettarget=gameSystem.getNumber(code);
            gameSystem.buffs.add(new CheaterBuff(code, target, targettarget,gameSystem));
        } else if (num == 3) {
            gameSystem.send("Congratulations! knightbuff",code);
            gameSystem.buffs.add(new KnightBuff(code, gameSystem.players.get(code - 1).mp,gameSystem));
        } else if (num == 4) {
            gameSystem.send("Congratulations! magebuff",code);
            gameSystem.send("what's your target:",code);
            int target=gameSystem.getNumber(code);
            gameSystem.buffs.add(new MageBuff(code, target,gameSystem));
        } else if (num == 5) {
            gameSystem.send("Congratulations! ministerbuff",code);
            gameSystem.buffs.add(new MinisterBuff(code, gameSystem.players.get(code - 1).hp,gameSystem));
        } else if (num == 6) {
            gameSystem.send("Congratulations! ninjabuff",code);
            gameSystem.send("what's your target",code);
            int target=gameSystem.getNumber(code);
            gameSystem.buffs.add(new NinjaBuff(code,target,gameSystem));
        } else if (num==7){
            gameSystem.send("Congratulations! paladinbuff",code);
            gameSystem.buffs.add(new PaladinBuff(code,gameSystem));
        } else if (num==8){
            gameSystem.send("Congratulations! rangerbuff",code);
            gameSystem.send("what's your target",code);
            int target=gameSystem.getNumber(code);
            gameSystem.buffs.add(new RangerBuff(code,target,gameSystem));
        } else if (num==9){
            gameSystem.send("Congratulations! sameralbuff",code);
            gameSystem.buffs.add(new SameralBuff(code, gameSystem.players.get(code-1).hp,gameSystem));
        } else if (num==10){
            gameSystem.send("Congratulations! thiefbuff",code);
            gameSystem.send("what's your target",code);
            int target=gameSystem.getNumber(code);
            gameSystem.buffs.add(new ThiefBuff(code,target,gameSystem));
        } else if (num==11){
            gameSystem.send("Congratulations! warlockbuff",code);
            gameSystem.send("what's your target",code);
            int target=gameSystem.getNumber(code);
            gameSystem.buffs.add(new WarlockBuff(code,target,gameSystem.players.get(code-1).hp,gameSystem));
        } else if (num==12){
            gameSystem.send("Congratulations! wizardbuff",code);
            gameSystem.buffs.add(new WizardBuff(code,gameSystem));
        } else if (num==13){
            gameSystem.send("Congratulations! worriorbuff",code);
            gameSystem.buffs.add(new WorriorBuff(code,gameSystem));
        }
    }
}

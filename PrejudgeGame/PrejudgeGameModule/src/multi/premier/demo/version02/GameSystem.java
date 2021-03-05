package multi.premier.demo.version02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GameSystem {
    static int round=1;
    static int streamnumber=0;
    static int playernumber=0;
    static ArrayList<Player> players=new ArrayList<>();
    static ArrayList<GameStream> streams=new ArrayList<>();
    static ArrayList<Buff> buffs =new ArrayList<>();
    static int[] hpdata;
    static int[] mpdata;
    static PrintWriter out;
    static BufferedReader in;
    static BufferedReader reader;

    static void initialize(PrintWriter pwout,BufferedReader brin, BufferedReader brre){
        out=pwout;
        in=brin;
        reader=brre;
    }
    static int getNumber(int code) throws IOException {
        int num=0;
        if(code==1){
            num=Integer.parseInt(in.readLine());
        }else if(code==2){
            num=Integer.parseInt(reader.readLine());
        }
        return num;
    }
    static void send(String message, int code){
        if(code==1){
            System.out.println(message);
        }else if(code==2){
            out.println(message);
            out.flush();
        }
    }
    static void sendToAll(String message){
        System.out.println(message);
        out.println(message);
        out.flush();
    }
    static void createPlayers () throws OccupationOutOfRangeException, NumberInvalidException, IOException {
        send("player1:"+" select occupation",1);
        int i=getNumber(1);
        players.add(new Player(select(i),1));
        playernumber+=1;
        send("player2:"+" select occupation",2);
        int j=getNumber(2);
        players.add(new Player(select(j),2));
        playernumber+=1;
    }
    static Occupation select(int i) throws OccupationOutOfRangeException{
        if (i == 0) {
            return new Commoner();
        } else if (i == 1) {
            return new Worrior();
        } else if (i == 2) {
            return new Shooter();
        } else if (i == 3) {
            return new Wizard();
        } else if (i == 4) {
            return new Minister();
        } else if (i == 5) {
            return new Mage();
        } else if (i == 6) {
            return new Priest();
        } else if (i == 7) {
            return new Warlock();
        } else if (i == 8) {
            return new Ranger();
        } else if (i == 9) {
            return new Shinobi();
        } else if (i == 10) {
            return new Killer();
        } else if (i == 11) {
            return new Paladin();
        } else if (i == 12) {
            return new Sameral();
        } else if (i == 13) {
            return new Assassin();
        } else if (i == 14) {
            return new Agent();
        } else if (i == 15) {
            return new Knight();
        } else if (i == 16) {
            return new Thief();
        } else if (i == 36) {
            return new Summoner();
        } else if (i == 64) {
            return new Pirate();
        }else{
            throw new OccupationOutOfRangeException();
        }
    }
    static void start() throws ActionInvalidException, MPUnderZeroException, BeatSelfException, MultibuffException, IOException {
        load();
        send(display()+" player"+2+": what do you want",2);
        int i=getNumber(2);
        if (i == 1) {
            send("what's your target",2);
            int j =getNumber(2);
            if(j==2){
                throw new BeatSelfException();
            }
            send("what's your power",2);
            int l =getNumber(2);
            players.get(1).attack(GameSystem.players.get(j-1),l);
        } else if (i == 2) {
            players.get(1).defence();
        } else if (i == 3) {
            send("what's your target",2);
            int j=getNumber(2);
            if(j==2){
                throw new BeatSelfException();
            }
            players.get(1).unique(GameSystem.players.get(j-1));
        } else if (i == 4) {
            players.get(1).skill();
        }else{
            throw new ActionInvalidException();
        }
        send(display()+" player"+1+": what do you want",1);
        int a=getNumber(1);
        if (a == 1) {
            send("what's your target",1);
            int b =getNumber(1);
            if(b==1){
                throw new BeatSelfException();
            }
            send("what's your power",1);
            int c =getNumber(1);
            players.get(0).attack(GameSystem.players.get(b-1),c);
        } else if (a == 2) {
            players.get(0).defence();
        } else if (a == 3) {
            send("what's your target",1);
            int b=getNumber(1);
            if(b==1){
                throw new BeatSelfException();
            }
            players.get(0).unique(GameSystem.players.get(b-1));
        } else if (a == 4) {
            players.get(0).skill();
        }else{
            throw new ActionInvalidException();
        }
        checkBuff();
    }
    static void checkBuff() throws MultibuffException {
        for(Buff b1:buffs){
            for (Buff b2:buffs){
                if(b1.sufferer.code==b2.sufferer.code&&b1.appearTime!=b2.appearTime&&b1.isActive&&b2.isActive){
                    throw new MultibuffException();
                }
            }
        }
    }
    static void account() throws GameIsEndException {
        for (Buff b:buffs){
            if(b.isActive&&b.name=="cheaterbuff"){
                b.account();
            }
        }
        for (Buff b:buffs){
            if(b.isActive&&b.name=="thiefbuff"){
                b.account();
            }
        }
        for (Buff b:buffs){
            if(b.isActive&&b.name=="knightbuff"){
                b.account();
            }
        }
        for (Buff b:buffs){
            if(b.isActive&&b.name=="worriorbuff"){
                b.account();
            }
        }
        for (Buff b:buffs){
            if(b.isActive&&b.name=="ninjabuff"){
                b.account();
            }
        }
        for (Buff b:buffs){
            if(b.isActive&&b.name=="assassinbuff"){
                b.account();
            }
        }
        for (Buff b:buffs){
            if(b.isActive&&b.name=="paladinbuff"){
                b.account();
            }
        }
        if(streamnumber!=0) {
            for (GameStream s : streams) {
                s.account();
            }
        }
        streams.clear();
        streamnumber=0;
        for (Buff b:buffs){
            if(b.isActive&&b.name=="warlockbuff"){
                b.account();
            }
        }
        for (Buff b:buffs){
            if(b.isActive&&(b.name=="wizardbuff"||b.name=="ministerbuff")){
                b.account();
            }
        }
        for (Buff b:buffs){
            if(b.isActive&&b.name=="magebuff"){
                b.account();
            }
        }
        for (Buff b:buffs){
            if(b.isActive&&(b.name=="sameralbuff")){
                b.account();
            }
        }
        for (Buff b:buffs){
            if(b.isActive&&b.name=="rangerbuff"){
                b.account();
            }
        }
        for (Player p:players){
            p.isdefence=false;
        }
        for (Buff b:buffs){
            if(b.isActive&&(b.name=="agentbuff")){
                b.account();
            }
        }
        round++;
    }
    static void load(){
        hpdata=new int[playernumber];
        mpdata=new int[playernumber];
        for (Player p:players){
            hpdata[p.code-1]=p.hp;
            mpdata[p.code-1]=p.mp;
        }
    }
    static String display(){
        String gamedata="";
        gamedata=gamedata+"[round:"+round+"]";
        for(Player p:players){
            gamedata=gamedata+" player"+p.code+":";
            for (Buff b:buffs){
                if(b.sufferer.code==p.code&&b.isActive&&b.appearTime!=round){
                    gamedata=gamedata+" buff:"+b.name;
                }
            }
            gamedata=gamedata+" occupation:"+p.occupation.name;
            gamedata=gamedata+" HP:"+hpdata[p.code-1];
            gamedata=gamedata+" MP:"+mpdata[p.code-1]+" ";
        }
        return gamedata;
    }
    static boolean isEnd(){
        for(Player p:players){
            if(p.hp<=0){
                return true;
            }
        }
        return false;
    }
    static void regenerate() throws GameIsEndException {
        for (Player p : players) {
            p.mp+=2;
        }
    }
    static void finalAccount(){
        String message="";
        message=message+"GameOver";
        ArrayList<Player> alives=new ArrayList<>();
        ArrayList<Player> deads=new ArrayList<>();
        for (Player p : players) {
            if(p.hp<=0){
                deads.add(p);
            }else{
                alives.add(p);
            }
        }
        int bigwinner=-99;
        int bigloser=99;
        for (Player p:alives){
            if (p.hp+p.mp>bigwinner){
                bigwinner=p.hp+p.mp;
            }
        }
        for (Player p:alives){
            if (p.hp+p.mp==bigwinner){
                message=message+" bigwinner: player"+p.code;
            }
        }
        for (Player p:alives){
            if (p.hp+p.mp!=bigwinner){
                message=message+" winner: player"+p.code;
            }
        }
        for (Player p:deads){
            if (p.hp+p.mp<bigloser){
                bigloser=p.hp+p.mp;
            }
        }
        for(Player p:deads){
            if (p.hp+p.mp==bigloser){
                message=message+(" bigloser: player"+p.code);
            }
        }
        for(Player p:deads){
            if (p.hp+p.mp!=bigloser){
                message=message+(" loser: player"+p.code);
            }
        }
        sendToAll(message);
    }
}

package multi.premier.demoo.version01;

import java.util.ArrayList;
import java.util.Scanner;

public class GameSystem {
    static int round=1;
    static int streamnumber=0;
    static int playernumber=0;
    static ArrayList<Player> players=new ArrayList<>();
    static ArrayList<GameStream> streams=new ArrayList<>();
    static ArrayList<Buff> buffs =new ArrayList<>();
    static int[] hpdata;
    static int[] mpdata;

    static void createPlayers () throws OccupationOutOfRangeException,NumberInvalidException{
        System.out.println("player number:");
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        if(n<=1){
            throw new NumberInvalidException();
        }
        for (int i = 1; i < n+1; i++) {
            System.out.println("player"+i+" select occupation");
            players.add(new Player(select(),i));
            playernumber+=1;
        }
    }
    static Occupation select() throws OccupationOutOfRangeException{
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
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
    static void start() throws ActionInvalidException, MPUnderZeroException, BeatSelfException, MultibuffException {
        load();
        for(Player p:players){
            display();
            System.out.println("player"+p.code+": what do you want");
            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt();
            if (i == 1) {
                System.out.println("what's your target");
                int j =sc.nextInt();
                if(j==p.code){
                    throw new BeatSelfException();
                }
                System.out.println("what's your power");
                int l =sc.nextInt();
                p.attack(GameSystem.players.get(j-1),l);
            } else if (i == 2) {
                p.defence();
            } else if (i == 3) {
                System.out.println("what's your target");
                int j =sc.nextInt();
                p.unique(GameSystem.players.get(j-1));
            } else if (i == 4) {
                p.skill();
            }else{
                throw new ActionInvalidException();
            }
            for(int j=0;j<20;j++){
                System.out.println();
            }
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
    static void display(){
        for(Player p:players){
            System.out.println("player"+p.code+":");
            for (Buff b:buffs){
                if(b.sufferer.code==p.code&&b.isActive&&b.appearTime!=round){
                    System.out.println("buff:"+b.name);
                }
            }
            System.out.println("occupation:"+p.occupation.name);
            System.out.println("HP:"+hpdata[p.code-1]);
            System.out.println("MP:"+mpdata[p.code-1]);
        }
    }
    static boolean isEnd(){
        int i=0;
        for(Player p:players){
            if(p.hp>0){
                i++;
            }
        }
        if(i<=1){
            return true;
        }else{
            return false;
        }
    }
    static void regenerate() throws GameIsEndException {
        for (Player p : players) {
            p.mp+=2;
        }
    }
    static void finalAccount(){
        int i=0;
        int j=-99999;
        System.out.println("GameOver");
        for (Player p:players){
            if(p.hp>0){
                System.out.println("final winner:player"+p.code);
                i++;
            }
        }
        if(i==0){
            for(Player p:players){
                if (p.hp+p.mp>=j){
                    j=p.hp+p.mp;
                }
            }
            for(Player p:players){
                if (p.hp+p.mp==j){
                    System.out.println("final winner:player"+p.code);
                }
            }
        }
    }
}

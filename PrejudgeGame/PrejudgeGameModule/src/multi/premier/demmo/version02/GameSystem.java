package multi.premier.demmo.version02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GameSystem {
    int round = 1;
    int streamnumber = 0;
    int playernumber = 0;
    int number = 0;
    ArrayList<Player> players = new ArrayList<>();
    ArrayList<GameStream> streams = new ArrayList<>();
    ArrayList<Buff> buffs = new ArrayList<>();
    int[] hpdata;
    int[] mpdata;
    ArrayList<PrintWriter> outs = new ArrayList<>();
    BufferedReader in;
    ArrayList<BufferedReader> readers = new ArrayList<>();

    int getNumber(int code) throws IOException {
        return Integer.parseInt(readers.get(code - 1).readLine());
    }

    void send(String message, int code) {
        outs.get(code - 1).println(message);
        outs.get(code - 1).flush();
    }

    void sendToAll(String message) {
        outs.forEach(out -> {
            out.println(message);
            out.flush();
        });
    }

    void createPlayers() throws OccupationOutOfRangeException, IOException {
        for (int code = 1; code <= number; code++) {
            send("player" + (code) + ":" + " select occupation", code);
            int i = getNumber(code);
            players.add(new Player(select(i), code,this));
            playernumber += 1;
        }
    }

    Occupation select(int i) throws OccupationOutOfRangeException {
        if (i == 0) {
            return new Commoner();//可怜的平民，没有任何技能 平民
        } else if (i == 1) {
            return new Worrior(this);//下一次攻击伤害必杀 战士
        } else if (i == 2) {
            return new Shooter(this);//对目标强制扣除两血 射手
        } else if (i == 3) {
            return new Wizard(this);//本回合后，受到一次必死伤害留1点血 法师
        } else if (i == 4) {
            return new Minister(this);//回复2点生命值，若本回合生命值下降且未死，回到6点生命值 牧师
        } else if (i == 5) {
            return new Mage(this);//交换与目标的hp 术士
        } else if (i == 6) {
            return new Priest(this);//掉2血加8mp 祭司
        } else if (i == 7) {
            return new Warlock(this);//若下两回合自己血量未变动，则目标被必杀 巫师
        } else if (i == 8) {
            return new Ranger(this);//目标防御之前不回mp 队员
        } else if (i == 9) {
            return new Shinobi(this);//此过后的第三回合对目标造成6点威力的攻击 忍者
        } else if (i == 10) {
            return new Killer(this);//发动一次威力等于回合数的攻击 杀手
        } else if (i == 11) {
            return new Paladin(this);//当回合以后免除一次对自己的stream伤害 骑士
        } else if (i == 12) {
            return new Sameral(this);//用1血分身抵挡本回合伤害 武士
        } else if (i == 13) {
            return new Assassin(this);//反弹当回合所有对自己释放的stream 刺客
        } else if (i == 14) {
            return new Agent(this);//强制结算 管理
        } else if (i == 15) {
            return new Knight(this);//3回合内mp无限 爵士
        } else if (i == 16) {
            return new Thief(this);//若本回合目标使用了技能，目标被必杀 小偷
        } else if (i == 36) {
            return new Summoner(this);//将target身上附着的buff换到自己身上，可指定此buff的target为哪一位角色 召唤
        } else if (i == 64) {
            return new Pirate(this);//随机给自己挂一个buff，对面目标可选 海盗
        } else {
            throw new OccupationOutOfRangeException();
        }
    }

    void start() throws ActionInvalidException, MPUnderZeroException, BeatSelfException, MultibuffException, IOException {
        load();
        sendToAll(display());
        for (int code = 1; code <= number; code++) {
            sendToAll("wait for player"+code);
            send("player" + code + ": what do you want", code);
            int i = getNumber(code);
            if (i == 1) {
                send("what's your target", code);
                int j = getNumber(code);
                if (j == code) {
                    throw new BeatSelfException();
                }
                send("what's your power", code);
                int l = getNumber(code);
                players.get(code - 1).attack(players.get(j - 1), l);
            } else if (i == 2) {
                players.get(code - 1).defence();
            } else if (i == 3) {
                send("what's your target", code);
                int j = getNumber(code);
                if (j == code) {
                    throw new BeatSelfException();
                }
                players.get(code - 1).unique(players.get(j - 1));
            } else if (i == 4) {
                players.get(code - 1).skill();
            } else {
                throw new ActionInvalidException();
            }
        }
        checkBuff();
    }

    void checkBuff() throws MultibuffException {
        for (Buff b1 : buffs) {
            for (Buff b2 : buffs) {
                if (b1.sufferer.code == b2.sufferer.code && b1.appearTime != b2.appearTime && b1.isActive && b2.isActive) {
                    throw new MultibuffException();
                }
            }
        }
    }

    void account() throws GameIsEndException {
        for (Buff b : buffs) {
            if (b.isActive && b.name == "cheaterbuff") {
                b.account();
            }
        }
        for (Buff b : buffs) {
            if (b.isActive && b.name == "thiefbuff") {
                b.account();
            }
        }
        for (Buff b : buffs) {
            if (b.isActive && b.name == "knightbuff") {
                b.account();
            }
        }
        for (Buff b : buffs) {
            if (b.isActive && b.name == "worriorbuff") {
                b.account();
            }
        }
        for (Buff b : buffs) {
            if (b.isActive && b.name == "ninjabuff") {
                b.account();
            }
        }
        for (Buff b : buffs) {
            if (b.isActive && b.name == "assassinbuff") {
                b.account();
            }
        }
        for (Buff b : buffs) {
            if (b.isActive && b.name == "paladinbuff") {
                b.account();
            }
        }
        if (streamnumber != 0) {
            for (GameStream s : streams) {
                s.account();
            }
        }
        streams.clear();
        streamnumber = 0;
        for (Buff b : buffs) {
            if (b.isActive && b.name == "warlockbuff") {
                b.account();
            }
        }
        for (Buff b : buffs) {
            if (b.isActive && (b.name == "wizardbuff" || b.name == "ministerbuff")) {
                b.account();
            }
        }
        for (Buff b : buffs) {
            if (b.isActive && b.name == "magebuff") {
                b.account();
            }
        }
        for (Buff b : buffs) {
            if (b.isActive && (b.name == "sameralbuff")) {
                b.account();
            }
        }
        for (Buff b : buffs) {
            if (b.isActive && b.name == "rangerbuff") {
                b.account();
            }
        }
        for (Player p : players) {
            p.isdefence = false;
        }
        for (Buff b : buffs) {
            if (b.isActive && (b.name == "agentbuff")) {
                b.account();
            }
        }
        round++;
    }

    void load() {
        hpdata = new int[playernumber];
        mpdata = new int[playernumber];
        for (Player p : players) {
            hpdata[p.code - 1] = p.hp;
            mpdata[p.code - 1] = p.mp;
        }
    }

    String display() {
        String gamedata = "";
        gamedata = gamedata + "[round:" + round + "]"+"\n";
        for (Player p : players) {
            gamedata = gamedata + " player" + p.code + ":"+"\n";
            for (Buff b : buffs) {
                if (b.sufferer.code == p.code && b.isActive && b.appearTime != round) {
                    gamedata = gamedata + " buff:" + b.name+"\n";
                }
            }
            gamedata = gamedata + " occupation:" + p.occupation.name+"\n";
            gamedata = gamedata + " HP:" + hpdata[p.code - 1]+"\n";
            gamedata = gamedata + " MP:" + mpdata[p.code - 1]+"\n";
        }
        return gamedata;
    }

    boolean isEnd() {
        for (Player p : players) {
            if (p.hp <= 0) {
                return true;
            }
        }
        return false;
    }

    void regenerate() throws GameIsEndException {
        for (Player p : players) {
            p.mp += 2;
        }
    }

    void finalAccount() {
        String message = "";
        message = message + "GameOver"+"\n";
        ArrayList<Player> alives = new ArrayList<>();
        ArrayList<Player> deads = new ArrayList<>();
        for (Player p : players) {
            if (p.hp <= 0) {
                deads.add(p);
            } else {
                alives.add(p);
            }
        }
        int bigwinner = -99;
        int bigloser = 99;
        for (Player p : alives) {
            if (p.hp + p.mp > bigwinner) {
                bigwinner = p.hp + p.mp;
            }
        }
        for (Player p : alives) {
            if (p.hp + p.mp == bigwinner) {
                message = message + " bigwinner: player" + p.code+"\n";
            }
        }
        for (Player p : alives) {
            if (p.hp + p.mp != bigwinner) {
                message = message + " winner: player" + p.code+"\n";
            }
        }
        for (Player p : deads) {
            if (p.hp + p.mp < bigloser) {
                bigloser = p.hp + p.mp;
            }
        }
        for (Player p : deads) {
            if (p.hp + p.mp == bigloser) {
                message = message + (" bigloser: player" + p.code)+"\n";
            }
        }
        for (Player p : deads) {
            if (p.hp + p.mp != bigloser) {
                message = message + (" loser: player" + p.code)+"\n";
            }
        }
        sendToAll(message);
    }
}

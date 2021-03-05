package multi.premier.demoo.version01;

public class Origin {
    public static void main(String[] args) throws OccupationOutOfRangeException, ActionInvalidException, MPUnderZeroException, BeatSelfException, MultibuffException, NumberInvalidException, GameIsEndException {
        GameSystem.createPlayers();
        while (!GameSystem.isEnd()){
            GameSystem.regenerate();
            GameSystem.start();
            GameSystem.account();
        }
        GameSystem.finalAccount();
    }
}

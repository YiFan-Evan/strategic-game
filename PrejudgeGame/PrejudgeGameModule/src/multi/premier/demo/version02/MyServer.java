package multi.premier.demo.version02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) throws OccupationOutOfRangeException, NumberInvalidException, GameIsEndException, MPUnderZeroException, MultibuffException, ActionInvalidException, BeatSelfException {
        try{
            ServerSocket server=new ServerSocket(8888);
            System.out.println("service open............");
            Socket socket = server.accept();
            System.out.println("------have guest------");
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
            GameSystem.initialize(pw,br2,br);
            GameSystem.createPlayers();
            while(!GameSystem.isEnd()){
                GameSystem.regenerate();
                GameSystem.start();
                GameSystem.account();
            }
            GameSystem.finalAccount();
            socket.close();
            server.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

package multi.premier.demoo.version02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MyServer {

    public static void main(String[] args) throws OccupationOutOfRangeException, NumberInvalidException, GameIsEndException, MPUnderZeroException, MultibuffException, ActionInvalidException, BeatSelfException {
        try{
            ArrayList<Socket> sockets=new ArrayList<>();
            GameSystem.in= new BufferedReader(new InputStreamReader(System.in));
            System.out.println("players number");
            GameSystem.number=Integer.parseInt(GameSystem.in.readLine());
            ServerSocket server=new ServerSocket(8888);
            System.out.println("service open............");
            for (int i = 0; i <GameSystem.number; i++) {
                Socket socket = server.accept();
                sockets.add(socket);
                System.out.println("------have guest------");
                InputStream is = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                OutputStream os = socket.getOutputStream();
                PrintWriter pw = new PrintWriter(os);
                GameSystem.readers.add(br);
                GameSystem.outs.add(pw);
            }
            GameSystem.createPlayers();
            while(!GameSystem.isEnd()){
                GameSystem.regenerate();
                GameSystem.start();
                GameSystem.account();
            }
            GameSystem.finalAccount();
            Thread.sleep(10000000);
            sockets.forEach(socket -> {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            server.close();
        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }
}

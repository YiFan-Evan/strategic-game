package multi.premier.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) {
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
            while(true){
                String msg=br.readLine();
                System.out.println("Client:"+msg);
                System.out.println("please input your message:");
                msg=br2.readLine();
                pw.println(msg);
                pw.flush();
                if("88".equals(msg)){
                    break;
                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

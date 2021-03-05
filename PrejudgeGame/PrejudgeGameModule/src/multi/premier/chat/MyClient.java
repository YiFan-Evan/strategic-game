package multi.premier.chat;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyClient {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("127.0.0.1", 8888);
            System.out.println("------connect with server------");
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
            while(true){
                System.out.println("please input your message:");
                String msg = br2.readLine();
                pw.println(msg);
                pw.flush();
                if("88".equals(msg)){
                    break;
                }
                msg=br.readLine();
                System.out.println("Server:"+msg);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

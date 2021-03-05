package multi.premier.demo.version02;

import java.io.*;
import java.net.Socket;

public class MyClient {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("192.168.1.105", 8888);
            System.out.println("------connect with server------");
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
            while(true){
                String msg=br.readLine();
                System.out.println("Server->"+msg);
                if(msg.charAt(0)=='G'){
                    break;
                }
                String reply = br2.readLine();
                pw.println(reply);
                pw.flush();
            }
            socket.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

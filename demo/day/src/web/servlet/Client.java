package web.servlet;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    public ArrayList<String> message;
    public int current;
    Socket socket;
    BufferedReader br;
    PrintWriter pw;
    Thread thread;
    InputStream is;
    InputStreamReader isr;
    OutputStream os;
    public ArrayList<Integer> length;
    public void run() throws IOException {
        socket = new Socket("127.0.0.1",8888);
        is = socket.getInputStream();
        isr = new InputStreamReader(is);
        br = new BufferedReader(isr);
        os = socket.getOutputStream();
        pw = new PrintWriter(os);
        message=new ArrayList<>();
        current=0;
        length=new ArrayList<>();
        thread = new Thread(() -> {
            boolean b=true;
            while(b){
                try {
                    char[] ch=new char[1024];
                    int len = br.read(ch, 0, 1024);
                    String str = new String(ch, 0, 1024);
                    if(str.charAt(0)=='q'){
                        b=false;
                    }else {
                        message.add(str);
                        length.add(len);
                        current++;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                is.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }
    public void answer(String str){
        pw.println(str);
        pw.flush();
    }
    public void shutdown() throws IOException {
        os.close();
        socket.close();
    }
}

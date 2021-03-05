package multi.premier.test;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("正在链接中......");
        Socket socket = new Socket("127.0.0.1",8888);
        System.out.println("链接成功");
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        OutputStream os = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(os);
        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
        Thread thread = new Thread(() -> {
            boolean b=true;
            while(b){
                try {
                    char[] ch=new char[1024];
                    int len = br.read(ch, 0, 1024);
                    String str = new String(ch, 0, 1024);
                    if(str.charAt(0)=='q'){
                        b=false;
                    }else {
                        System.out.print(str);
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
        boolean a=true;
        while(a){
            String str = br2.readLine();
            if(str.charAt(0)=='q'){     //回车结束
                a=false;
            }
            pw.println(str);
            pw.flush();
        }
        os.close();
        socket.close();
    }
}

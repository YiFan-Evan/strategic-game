package multi.premier.demmo.version02;

//import javafx.concurrent.Task;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MultiServer {
    static int num;
    static ArrayList<Task> pool;
    static BufferedReader input;
    public static void main(String[] args) throws IOException {
        System.out.println("players number:");
        input = new BufferedReader(new InputStreamReader(System.in));
        num=Integer.parseInt(input.readLine());
        pool = new ArrayList<>(1000);
        //创建客户端池
        ServerSocket server = new ServerSocket(8888);
        //初始化服务器
        System.out.println("service open............");
        //等待连接
        int count=1;
        //客户端计数器
        while(count<=1000){
            ArrayList<Socket> clients = new ArrayList<>();
            for (int i=0;i<num;i++){
                clients.add(server.accept());
                System.out.println("------have guest------");
            }
            System.out.println("match completed, game start......");
            Task socket=new Task(clients,server,count);
            pool.add(socket);
            count++;
            new Thread(socket).start();
        }
        //阻塞式创建服务器线程添加并跑动
        server.close();
        //关闭服务器
    }

    static class Task implements Runnable{
        public ArrayList<Socket> clients;
        public ServerSocket server;
        public int name;
        public GameSystem gameSystem;

        public Task(ArrayList<Socket> sockets,ServerSocket server,int name) throws IOException {
            this.clients=sockets;
            this.server=server;
            this.name=name;
            this.gameSystem=new GameSystem();
            initialize();
        }

        public void initialize() {
            gameSystem.in= input;
            gameSystem.number=num;
            clients.forEach(client -> {
                InputStream is = null;
                try {
                    is = client.getInputStream();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                assert is != null;
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                OutputStream os = null;
                try {
                    os = client.getOutputStream();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                assert os != null;
                PrintWriter pw = new PrintWriter(os);
                gameSystem.readers.add(br);
                gameSystem.outs.add(pw);
            });
        }

        @Override
        public void run() {
            try{
                gameSystem.createPlayers();
                while(!gameSystem.isEnd()){
                    gameSystem.regenerate();
                    gameSystem.start();
                    gameSystem.account();
                }
                gameSystem.finalAccount();
                gameSystem.sendToAll("quit");
                //Thread.sleep(10000000);
                clients.forEach(socket -> {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

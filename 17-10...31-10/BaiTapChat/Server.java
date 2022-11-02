package BaiTapChat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class Server {
    ServerSocket ss;
    Socket s;
    boolean stop = false;

    List<ServerThread> listOfServerThreads = new LinkedList<>();

    public Server(int port) throws IOException {
        ss = new ServerSocket(port);
        while(!stop) run();
        ss.close();
    }

    public void test(String content) {
        System.out.println(content);
    }

    public void sendMsg(String fromUser, String toUser, String msg) throws IOException {
        String send = fromUser + ": " + msg;
        for (ServerThread serverThread : listOfServerThreads) {
            if (serverThread.user.equals(toUser)) {
                serverThread.fromServer.add(send);
            }
        }
    }

    public void sendFile(String fromUser, String toUser, String filename) {
        String send = "File from " + fromUser + ": " + filename;
        String file = "./" + filename; // /home/manhtv/Desktop/BKAV/
        for (ServerThread serverThread : listOfServerThreads) {
            if (serverThread.user.equals(toUser)) {
                serverThread.fromServer.add(send);
                serverThread.fromServer.add(file);
            }
        }
    }
    
    public void run() throws IOException {
        s = ss.accept();
        ServerThread st = new ServerThread(s, this);
        listOfServerThreads.add(st);
    }

    public void remove(ServerThread st) {
        listOfServerThreads.remove(st);
    }

    public static void main(String[] args) throws IOException {
        new Server(1234);
    }
}

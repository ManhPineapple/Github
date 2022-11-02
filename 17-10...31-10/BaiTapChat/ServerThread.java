package BaiTapChat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class ServerThread implements Runnable {
    Socket s;
    Server ss;
    String user = "";

    PrintWriter output;
    BufferedReader input;

    List<String> fromServer;
    FileWriter fw;

    Thread thread;
    boolean stop = false;

    public ServerThread(Socket s, Server ss) throws IOException {
        this.s = s;
        this.ss = ss;

        output = new PrintWriter(s.getOutputStream(), true);
        input = new BufferedReader(new InputStreamReader(s.getInputStream()));
        fromServer = new LinkedList<>();
        fw = new FileWriter("History.txt", true);
        
        thread = new Thread(this);
        thread.start();
    }

    void loginCheck() throws IOException {
        String username = input.readLine();
        String password = input.readLine();

        if((username.equals("user1") || username.equals("user2")) && password.equals("admin")){
            this.user = username;
            output.println("Welcome, " + username);
            output.flush();
        } else {
            output.println("Fail");
            output.flush();
            loginCheck();
        }
    }

    private void sendFile(String path) throws Exception {
        int bytes = 0;

        File file = new File(path);
        FileInputStream fileInputStream = new FileInputStream(file);
 
        DataOutputStream dataOutputStream = new DataOutputStream(s.getOutputStream());
        dataOutputStream.writeLong(file.length());

        byte[] buffer = new byte[4 * 1024];
        while ((bytes = fileInputStream.read(buffer)) != -1) {
            dataOutputStream.write(buffer, 0, bytes);
            dataOutputStream.flush();
        }
        fileInputStream.close();
    }

    private void receiveFile(String fileName) throws Exception {
        int bytes = 0;
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        DataInputStream dataInputStream = new DataInputStream(s.getInputStream());

        long size = dataInputStream.readLong();
        byte[] buffer = new byte[4 * 1024];
        while (size > 0 && (bytes = dataInputStream.read(buffer, 0,(int)Math.min(buffer.length, size)))!= -1) {
            fileOutputStream.write(buffer, 0, bytes);
            size -= bytes;
        }

        fileOutputStream.close();
    }


    public void run() {
        try {
            loginCheck();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        while (!stop) {
            try {
                if (input.ready()) {
                    String str = input.readLine();
                    if (str.equals("Check online user")) output.println("Online: " + ss.listOfServerThreads.size());
                    if (str.equals("logout")) {stop = false; ss.remove(this); fw.close();}
                    String arr[] = str.split(" ");
                    if (arr[0].equals("Chat")) {
                        String history = this.user + " to " + arr[1] + ": " + arr[2];
                        fw.write(history + "\n");
                        ss.sendMsg(this.user, arr[1], arr[2]);
                    }
                    if (arr[0].equals("File")) {
                        receiveFile(arr[3]);
                        ss.sendFile(this.user, arr[1], arr[3]);
                    }
                }
                if (!fromServer.isEmpty()) {
                    for (String string : fromServer) {
                        if (string.charAt(0) != '/') output.println(string); else sendFile(string);
                        fromServer.remove(string);     
                        output.flush();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

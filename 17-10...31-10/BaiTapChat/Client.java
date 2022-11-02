package BaiTapChat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    Socket s;
    boolean stop = false;
    
    BufferedReader command;
    BufferedReader input;
    PrintWriter output;

    public Client(int port) throws Exception {
        s = new Socket("localhost", port);
        output = new PrintWriter(s.getOutputStream(), true);
        input = new BufferedReader(new InputStreamReader(s.getInputStream()));
        command = new BufferedReader(new InputStreamReader(System.in));

        String loginInfo = "Fail";
        System.out.println("Login info:");

        while (loginInfo == "Fail") {
            login();
            loginInfo = input.readLine();
            System.out.println(loginInfo);
        }
        running();
    }

    public void login() throws IOException {   
        String username = command.readLine();
        output.println(username);
        output.flush();

        String password = command.readLine();
        output.println(password);
        output.flush();
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

    public void running() throws Exception {
        while (!stop) {
            if (!input.ready()) {
                if (command.ready()) {
                    String str = command.readLine();
                    String arr[] = str.split(" ");
                    if (str.equals("logout")) {
                        output.println("logout");
                        break;
                    }
                    output.println(str);
                    output.flush();
                    if (arr[0].equals("File")) { // File toUser path nameOnRcvClient
                        sendFile(arr[2]); // "/home/manhtv/Desktop/BKAV/tutorial.py"
                    }
                }
            } else {
                String str = input.readLine();
                System.out.println(str);
                String arr[] = str.split(" ");
                if (arr[0].equals("File")) receiveFile("hi" + arr[3]);
            }
        }
        System.out.println("Logged out!");;
    }

    public static void main(String[] args) throws Exception {
        new Client(1234);
    }
}

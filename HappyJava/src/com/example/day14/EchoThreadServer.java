package com.example.day14;

import java.io.*;
import java.net.*;

public class EchoThreadServer {
    public static void main(String[] args) {
        // ServerSocket 생성 :: 1개
        try(ServerSocket serverSocket = new ServerSocket(9999);
        )
        {
            while(true){
                Socket cli = serverSocket.accept(); // 클라이언트 수만큼 반복
                // 클라이언트마다 각자 실행 할 수 있도록 만들어야 함 .. 쓰레드
                EchoThread echoThread = new EchoThread(cli);
                echoThread.start();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class EchoThread extends Thread{
    private Socket socket;
    EchoThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println(socket.getInetAddress().getHostAddress() +"로 부터 연결되었습니다.");

        try(PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            String line = null;
            while((line = in.readLine()) != null){
                System.out.println("클라이언트로 부터 받은 메시지 : " + line);
                out.println(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
package com.example.day15;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static final int PORT = 9999;

    public static void main(String[] args) {
        // 1. 서버 소켓을 새성
        try (ServerSocket serverSocket = new ServerSocket(PORT);
        ){
            System.out.println("Server listening on port " + PORT);
            // 여러명의 클라이언트의 정보를 기억할 공간
            Map<String, PrintWriter> chatClients = new HashMap<>();

            while (true) {
                // 2. accept() 를 통해 소켓을 얻어옴 (여러 클라이언트와 접속할 수 있도록)
                Socket socket = serverSocket.accept();

                // Thread 이용
                // 여러 클라이언트의 정보를 기억할 공간
                new chatThread(socket, chatClients).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class chatThread extends Thread {
    // 생성자를 통해서 클라이언트 소켓을 얻어옴
    private Socket socket;
    private String id;
    private Map<String, PrintWriter> chatClients;

    private BufferedReader br;
    private PrintWriter pw;

    public chatThread(Socket socket, Map<String, PrintWriter> chatClients) {
        this.socket = socket;
        this.chatClients = chatClients;

        // 클라이언트가 생성될 때 클라이언트로부터 아이디를 얻어오고 싶을 경우
        try{
            pw = new PrintWriter(socket.getOutputStream(), true);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // Client가 접속하자 마자 id를 보낸다는 약속
            id = br.readLine();
            //이때.. 모든 사용자에게 <id>님이 채팅에 입장했다는 정보를 알림
            broadcast(id + "님이 채팅방에 입장하셨습니다.");
            System.out.println(id + "님이 새로 채팅방에 합류했습니다.");

            // 동시에 일어날 수도 있다.
            // 동기화 사용 필요(Syncronized)
            synchronized (chatClients) {
                chatClients.put(this.id, pw);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        // run
        // 연결된 클라이언트가 메시지를 전송하면,
        // 그 메시지를 받아서 다른 사용자들에게 보내줌
        String msg = null;
        try {
            while((msg = br.readLine()) != null) {
                if("/quit".equalsIgnoreCase(msg.trim()))
                    break;
                if(msg.startsWith("/to")) {
                    whisper(msg);
                }
                else
                    broadcast(id + " : " + msg);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            synchronized (chatClients) {
                chatClients.remove(id);
            }
            broadcast(id + "님이 채팅방을 떠났습니다.");

            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            if(socket != null) {
                try{
                    socket.close();
                }catch (IOException e){
                    throw new RuntimeException(e);
                }
            }
        }
    }
    // 메시지를 특정 사용자에게만 보내는 메소드
    public void whisper(String msg) {
        int firstSpaceIndex = msg.indexOf(" "); // 첫번째 공백
        if (firstSpaceIndex == -1) return; //공백이 없다면....

        int secondSpaceIndex = msg.indexOf(" ", firstSpaceIndex + 1);   // 두번째 공백
        if (secondSpaceIndex == -1) return; //두번째 공백이 없다는 것도 메시지가 잘못된거니까..

        String to = msg.substring(firstSpaceIndex + 1, secondSpaceIndex);   // 수신자
        String message = msg.substring(secondSpaceIndex + 1);   // 메시지

        //to(수신자)에게 메시지 전송.
        PrintWriter pw = chatClients.get(to);
        if (pw != null) {
            pw.println(id + "님으로부터 귓속말 : " + message);
        } else {
            System.out.println("오류 : 수신자 " + to + " 님을 찾을 수 없습니다.");
        }
    }

    // 전체 사용자에게 알려주는 메소드
    public void broadcast(String message) {
        // 각각 클라이언트와 통신 할 수 있는 통로 얻어옴
        // 모든 클라이언트에게 전송하기 위해 사용해야 할 것 --> ??
        /*for(PrintWriter pw : chatClients.values()) {
            pw.println(message);
        }*/

        Iterator<PrintWriter> it = chatClients.values().iterator();
        while(it.hasNext()) {
            PrintWriter pw = it.next();
            try{
                pw.println(message);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

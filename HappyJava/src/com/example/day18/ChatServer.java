package com.example.day18;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Handler;

public class ChatServer {
    private static final int PORT = 12345;
    private static Set<PrintWriter> allClients = new HashSet<>();

    public static void main(String[] args) throws Exception {
        System.out.println("채팅 서버가 시작되었습니다.");

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
                new Handler(socket, chatClients).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class Handler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;
        private Map<String, PrintWriter> chatClients;
        private Map<Boolean, Integer> chatRooms = new HashMap<>();

        public Handler(Socket socket,Map<String, PrintWriter> chatClients) {
            this.socket = socket;
            this.chatClients = chatClients;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                String nickname = in.readLine();
                chatClients.put(nickname, out);

                synchronized (allClients) {
                    for(PrintWriter anoun : allClients) {
                        anoun.println(nickname + " 님이 입장하셨습니다.");
                    }
                    allClients.add(out);
                }

                String input;
                while ((input = in.readLine()) != null) {
                    synchronized (allClients) {
                        for (PrintWriter writer : allClients) {
                            if (input.startsWith("/create ")) {
                                // 입력에서 방 번호 추출
                                String[] parts = input.split(" ");
                                if (parts.length != 2) {
                                    out.println("올바른 명령 형식이 아닙니다. '/create [방번호]' 형식으로 입력하세요.");
                                    continue;
                                }
                                Integer roomNumber = Integer.parseInt(parts[1]);

                                if(!chatRooms.containsValue(roomNumber)){
                                    chatRooms.put(true, roomNumber);
                                    out.println("방이 생성되었습니다. 방 번호 : " + roomNumber);
                                }else {
                                    out.println("이미 존재하는 방입니다.");
                                }
                                continue;
                            }
                            else if("/bye".equals(input)) {
                                writer.println(nickname + " 님이 퇴장하셨습니다.");
                                continue;
                            }
                            writer.println(nickname + " : " + input);
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } finally {
                if (out != null) {
                    synchronized (allClients) {
                        allClients.remove(out);
                    }
                }
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
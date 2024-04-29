package com.example.day18;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Handler;

public class ChatServer {
    private static final int PORT = 12345;
    private static Set<PrintWriter> allClients = new HashSet<>();
    private static Map<String, ChatRoom> chatRooms = new HashMap<>();

    public static void main(String[] args) throws Exception {
        System.out.println("채팅 서버가 시작되었습니다.");

        try (ServerSocket serverSocket = new ServerSocket(PORT);
        ) {
            System.out.println("Server listening on port " + PORT);
            // 여러명의 클라이언트의 정보를 기억할 공간
            Map<String, PrintWriter> chatClients = new HashMap<>();

            while (true) {
                // accept() 를 통해 소켓을 얻어옴 (여러 클라이언트와 접속할 수 있도록)
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

        public Handler(Socket socket, Map<String, PrintWriter> chatClients) {
            this.socket = socket;
            this.chatClients = chatClients;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                System.out.println("신규 IP 접속 : " + socket.getInetAddress());
                String nickname = in.readLine();
                chatClients.put(nickname, out);

                synchronized (allClients) {
                    for (PrintWriter anoun : allClients) {
                        anoun.println("[ To All ] " + nickname + " 님이 서버에 입장하셨습니다.");
                    }
                    allClients.add(out);
                }

                String input;
                Lobby:
                while ((input = in.readLine()) != null) {
                    synchronized (allClients) {
                        // 방 관련 명령어는 여기에
                        synchronized (chatRooms) {
                            // 방 생성
                            if (input.startsWith("/create ")) {
                                // 입력에서 방 번호 추출
                                String[] parts = input.split(" ");
                                if (parts.length != 2) {
                                    out.println("올바른 명령 형식이 아닙니다. '/create [방 이름]' 형식으로 입력하세요.");
                                    continue;
                                }
                                try {
                                    String roomName = parts[1];
                                    if (!chatRooms.containsKey(roomName)) {
                                        ChatRoom room = new ChatRoom(roomName);
//                                        room = new ChatRoom(roomName);
                                        chatRooms.put(roomName, room);
                                        out.println("방이 생성되었습니다. 방 이름 : " + roomName);
                                    } else {
                                        out.println("이미 존재하는 방입니다.");
                                    }
                                    continue;
                                } catch (NumberFormatException e) {
                                    out.println("올바른 형식이 아닙니다. '/create [방 이름]' 형식으로 입력하세요.");
                                    continue;
                                }
                            }

                            // 방 리스트 확인
                            else if ("/list".equals(input)) {
                                StringBuilder roomList = new StringBuilder("==현재 존재하는 방 목록=======\n");
                                if (chatRooms.isEmpty())
                                    roomList.append("생성된 방이 없습니다.");
                                else {
                                    for (Map.Entry<String, ChatRoom> entry : chatRooms.entrySet()) {
                                        roomList.append("방 이름: ").append(entry.getKey()).append("\n");
                                    }
                                }
                                out.println(roomList);
                                continue;
                            }

                        }

                        // 모두를 대상으로 할 명령어는 여기에
                        if ("/bye".equals(input)) {
                            for (PrintWriter writer : allClients) {
                                writer.println("[ To All ] " + nickname + " 님이 서버에서 퇴장하셨습니다.");

                            }
                        }
                    }

                    // 동기화 밖에 선언..
                    // 동시 접속이 안되는 이슈
                    // 방 접속
                    if(input.startsWith("/join")){
                        String[] parts = input.split(" ");
                        if(parts.length != 2) {
                            out.println("올바른 명령 형식이 아닙니다. '/join [방 이름]' 형식으로 입력하세요.");
                            continue;
                        }
                        try{
                            if(!chatRooms.containsKey(parts[1])) {
                                out.println("해당 채팅방이 존재하지 않습니다.");
                                continue;
                            }
                            // 방에 접속해야 함
                            ChatRoom room = chatRooms.get(parts[1]);
                            room.addClient(nickname, out);
                            room.broadcastMessage(nickname + " 님이 채팅방에 입장하셨습니다.");
                            while((input = in.readLine()) != null){
                                if("/history".equals(input)){
                                    // 개인한테만 출력
                                    out.println("==Chat History==========");
                                    out.println(room.getChatHistory());
                                    out.println("========================");
                                    continue;
                                }
                                if("/exit".equals(input)){
                                    out.println("채팅방 [" + parts[1] + "] 에서 퇴장했습니다.");
                                    room.removeClient(nickname);
                                    room.broadcastMessage(nickname + " 님이 채팅방에서 퇴장하셨습니다.");
                                    if(room.getOnline() == 0) {
                                        chatRooms.remove(parts[1]);
                                        System.out.println("채팅방 [" + parts[1] + "] 이 더이상 사용자가 없어 삭제되었습니다.");
                                    }
                                    continue Lobby; // lobby 루프로 나가기
                                }else {
                                    try {
                                        room.broadcastMessage(nickname + " : " + input);
                                        room.addChat(nickname + " : " + input);
                                    } catch (NullPointerException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }catch (NumberFormatException e){
                            out.println("올바른 형식이 아닙니다. '/join [방 이름]' 형식으로 입력하세요.");
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
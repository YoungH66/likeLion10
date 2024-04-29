package com.example.day18;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Handler;

public class ChatServer {
    private static final int PORT = 12345;
    private static Set<PrintWriter> allClients = new HashSet<>();
    private static Map<String, ChatRoom> chatRooms = new HashMap<>();
    private static Set<String> userList = new HashSet<>();

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
                userList.add(nickname);

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
                        // 요구사항에 귓속말은 같은 방 내부에서만 동작하지만,
                        // 실 사용에 있어 서버에 접속 후 서버 내 유저목록을 확인할 수 있는만큼
                        // 어느곳에서든 사용할 수 있는게 적합하다고 판단.
                        if(input.startsWith("/whisper")){
                            String[] parts = input.split(" ");
                            if(parts.length < 3){
                                out.println("올바른 명령 형식이 아닙니다. '/whisper [닉네임] [메시지]' 형식으로 입력하세요.");
                                continue;
                            }
                            try{
                                String tgNickname = parts[1];
                                String msg = String.join(" ", Arrays.copyOfRange(parts, 2, parts.length));

                                PrintWriter writer = chatClients.get(tgNickname);
                                if(writer != null && !nickname.equals(tgNickname)){
                                    out.println("[" + tgNickname + "] 님에게 귓속말을 보냈습니다.");
                                    writer.println("[" + nickname + "] 님으로 부터 귓속말 : " + msg);
                                }else if(nickname.equals(tgNickname)){
                                    out.println("본인에게는 귓속말을 보낼 수 없습니다.");
                                }else{
                                    out.println("대상을 찾을 수 없습니다.");
                                }
                            }catch (NullPointerException e){
                                out.println("양식이 비어있습니다.");
                            }
                        }
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
                                roomList.append("=====================");
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
                    if("/users".equals(input)) {
                        out.println("== 서버 유저 목록======");
                        for(String nick : userList){
                            out.println(nick);
                        }
                        out.println("=====================");
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

                                // 요구사항에 귓속말은 같은 방 내부에서만 동작하지만,
                                // 실 사용에 있어 서버에 접속 후 서버 내 유저목록을 확인할 수 있는만큼
                                // 어느곳에서든 사용할 수 있는게 적합하다고 판단.
                                if(input.startsWith("/whisper")){
                                    try{
                                        parts = input.split(" ");
                                        if(parts.length < 3) {
                                            out.println("올바른 명령 형식이 아닙니다. '/join [방 이름]' 형식으로 입력하세요.");
                                            continue;
                                        }
                                        String tgNickname = parts[1];
                                        // 귓속말에서 띄어쓰기가 포함되게 수정
                                        String msg = String.join(" ", Arrays.copyOfRange(parts, 2, parts.length));

                                        PrintWriter writer = chatClients.get(tgNickname);
                                        if(writer != null && !nickname.equals(tgNickname)){
                                            out.println("[" + tgNickname + "] 님에게 귓속말을 보냈습니다.");
                                            writer.println("[" + nickname + "] 님으로 부터 귓속말 : " + msg);
                                        }else if(nickname.equals(tgNickname)){
                                            out.println("본인에게는 귓속말을 보낼 수 없습니다.");
                                        }else{
                                            out.println("대상을 찾을 수 없습니다.");
                                        }
                                    }catch (NullPointerException e){
                                        out.println("양식이 비어있습니다.");
                                    }
                                }
                                if("/roomusers".equals(input)) {
                                    // 개인한테만 출력
                                    out.println("==Chat History==========");
                                    out.println(room.getRoomUsers());
                                    out.println("========================");
                                    continue;
                                }
                                if("/history".equals(input)){
                                    // 개인한테만 출력
                                    out.println("==채팅방 유저 목록==========");
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
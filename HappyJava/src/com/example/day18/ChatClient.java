package com.example.day18;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {
        String hostName = "localhost"; // 서버가 실행 중인 호스트의 이름 또는 IP 주소
        int portNumber = 12345; // 서버와 동일한 포트 번호 사용

        Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            socket = new Socket(hostName, portNumber);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner stdIn = new Scanner(System.in);

            System.out.print("Enter your nickname: ");
            String nickname = stdIn.nextLine();
            out.println(nickname); // 서버에 닉네임을 전송

            // 서버로부터 메시지를 읽어 화면에 출력하는 별도의 스레드
            Thread readThread = new Thread(new ServerMessageReader(in));
            readThread.start(); // 메시지 읽기 스레드 시작

            // 위치 로비
            System.out.println("\nWelcome " + nickname);
            System.out.println("현재 위치는 로비입니다. 메뉴를 선택해 주세요.\n");
            // 메뉴얼 출력
            printManual();

            // 사용자 입력 처리
            String userInput;
            while (true) {
                userInput = stdIn.nextLine();
                if (userInput.startsWith("/")) {
                    String[] commnad = userInput.split(" ", 2);
                    switch (commnad[0]) {
                        case "/list":
                            out.println(userInput);
                            break;
                        case "/create":
                            out.println(userInput);
                            break;
                        case "/join":
                            out.println(userInput);
                            break;
                        case "/exit":
                            out.println(userInput);
                            printManual();
                            break;
                        case "/bye":
                            out.println(userInput);
                            stdIn.close();
                            socket.close();
                            return;
                        default:
                            System.out.println("잘못된 명령어 입니다. 다시 입력해주세요.");
                            break;
                    }
                } else
                    // 서버에 메시지를 전송합니다.
                    out.println(userInput);
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to connect to " + hostName + " on port " + portNumber);
            e.printStackTrace();
        } finally {
            try {
                // 클라이언트와 서버는 명시적으로 close를 합니다. close를 할 경우 상대방쪽의 readLine()이 null을 반환됩니다. 이 값을 이용하여 접속이 종료된 것을 알 수 있습니다.
                if (in != null) in.close();
                if (out != null) out.close();
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void printManual(){
        System.out.println("방 목록 보기 : /list");
        System.out.println("방 생성 : /create");
        System.out.println("방 입장 : /join [방번호]");
        System.out.println("방 나가기 : /exit");
        System.out.println("접속 종료 : /bye\n");
    }
}


package com.example.day14;

import java.io.*;
import java.net.*;

public class EchoServerExam {
    public static void main(String[] args) throws Exception {
        // ServerSocket 생성
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("Server started");

        // 클라이언트 연결 수락
        Socket socket = serverSocket.accept();  // 클라이언트 소켓 얻어옴
        System.out.println(socket.getInetAddress().getHostAddress() +" 로부터 연결");

        // 데이터 읽고 쓰기
        // 입력통로
        // 클라이언트의 출력이 서버의 입력이 된다.
        // socket.getOutputStream();    <- 클라이언트의 출력
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // 출력통로
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

        String line =null;
        while ((line = br.readLine()) != null) {
            pw.println(line);
            pw.flush();
        }
        br.close();
        pw.close();
        socket.close();
    }
}

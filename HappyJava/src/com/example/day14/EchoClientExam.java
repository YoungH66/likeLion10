package com.example.day14;

import java.io.*;
import java.net.Socket;

public class EchoClientExam {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("127.0.0.1", 9999);
        System.out.println("connected to server. Port: 9999");

        // 데이터 읽고 쓰기
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // 클라이언트가 키보드를 통해 입력하기 위한 종료
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        String line = null;
        while((line = keyboard.readLine()) != null){
            // equalsIgnoreCase는 대소문자 구별을 하지 않는다.
            if(line.equalsIgnoreCase("quit"))
                break;
            // 서버에게 보냄
            pw.println(line);
            pw.flush();

            // 서버에서 받음
            String echo = br.readLine();
            System.out.println("서버로부터 받은 응답 메시지 : " + echo);
        }

        // 연결종료
        pw.close();
        br.close();
        keyboard.close();
    }
}

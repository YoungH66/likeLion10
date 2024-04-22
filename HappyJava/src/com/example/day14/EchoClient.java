package com.example.day14;

import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) {
        try (
                Socket socket = new Socket("127.0.0.1", 9999);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
                )
        {
            String input;
            while((input = stdin.readLine()) != null){
                // 문자열 비교일경우 앞부분에 쓰면 방어적 코딩이 가능해진다. 절대 null이 오지 않기 때문
                // trim으로 사용자 입력에 공백이 있으면 제외하고 고려하도록
                if("exit".equalsIgnoreCase(input.trim())){
                    System.out.println("메시지 전송을 종료합니다.");
                    break;
                }
                out.println(input);
                System.out.println("echo: " + in.readLine());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

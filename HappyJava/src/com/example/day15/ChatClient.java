package com.example.day15;

import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) {
        // id가 첫 입력이 되게하기 위해 args[0] 에서 받아오도록 한다.
        if(args.length != 1) {
            System.out.println("Usage: java ChatClient id");
            // exit의 값은 int로 받는데, 이는 개발환경에 따른 변수이고 숫자마자 가지는 특별한 의미는 기본적으로 없다
            System.exit(1);
        }

        try(Socket socket = new Socket("localhost", 9999);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        )
        {
            // 접속에 성공하면 id를 서버에 보낸다. (서버와의 약속)
            out.println(args[0]);

            // 네트워크에서 입력된 내요을 담당하는 부분을 Thread로
            new InputThread(socket, in).start();

            // 키보드로부터 입력받은 내용을 서버에 보내는 코드
            String msg = null;
            while((msg = stdin.readLine()) != null) {
                //System.out.println(msg);
                out.println(msg);
                if("/quit".equalsIgnoreCase(msg.trim()))
                    break;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class InputThread extends Thread {
    private Socket socket;
    private BufferedReader in;

    InputThread(Socket socket, BufferedReader in) {
        this.socket = socket;
        this.in = in;
    }

    @Override
    public void run() {
        try
        {
            String msg = null;
            while((msg = in.readLine()) != null) {
                System.out.println(msg);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(in != null) {
                try {
                    in.close();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
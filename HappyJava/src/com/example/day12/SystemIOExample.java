package com.example.day12;

import java.io.*;

public class SystemIOExample {
    public static void main(String[] args) {
        // 키보드로부터 한 줄 입력을 받기 위함
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){
            System.out.println("문자열을 입력하시오...");
            String userinput = br.readLine();
            System.out.println(userinput);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

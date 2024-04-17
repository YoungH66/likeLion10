package com.example.day12;

import java.io.*;

public class IOExam03 {
    public static void main(String[] args) {
        // 파일에서 한 줄 씩 입력받아서 입력받는 문자뒤에 hi를 추가해서
        // 파일에 출력하는 프로그램
        // "test.txt", "testhi.txt"
        try(BufferedReader br = new BufferedReader(new FileReader("test.txt"));
            PrintWriter pw = new PrintWriter("testhi.txt"))
        {
                String str;
                while((str = br.readLine()) != null){
                    pw.println(str + "hi");
                }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

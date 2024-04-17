package com.example.day12;

import java.io.*;

public class BufferedExam {

    public static void main(String[] args) {
        // 키보드로부터 한줄씩 5번 입력 받아서 팔일에 출력하는 프로그램을 작성
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//            FileOutputStream fo = new FileOutputStream("fileOutput.txt")
            // printwirter가 가자 사용하기 쉽다.
            PrintWriter pw = new PrintWriter("fileOutput.txt");
        ){

            int cnt = 0;
            while(cnt < 5){
//                bw.write(br.readLine() + "\n");
                pw.println(br.readLine());
                cnt++;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

package com.example.day12;

import java.io.*;
import java.util.*;

public class IOExam02 {
    public static void main(String[] args) throws IOException {
        // 키보드로부터 한줄씩 입력 받아서 콘솔에 출력하고 싶다.

        // 키보드 System.in
        // 한줄씩 읽기 위해서 bufferedReader
        // bufferedReader는 주인격 클래스가 아닌 장식을 하는 클래스
        // 제대로 동작하기 위해선 inputStreamReader와 같이 주인격 클래스가 필요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader br2 = new BufferedReader(new FileReader("a.txt"));
        // readLine으로 한줄로 받을 수 있다
        String str = br.readLine();
        System.out.println(str);

        System.out.println(br2.readLine());
    }
}

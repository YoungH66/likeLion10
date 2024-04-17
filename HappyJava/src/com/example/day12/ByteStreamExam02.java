package com.example.day12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamExam02 {
    public static void main(String[] args) {
        // 파일로부터 읽어서 -> 입력 통로가 필요
        // 파일에 쓴다 -> 출력 통로가 필요
        try{
            // try 블럭 내부에서 선언된것들은 블럭이 끝나면 알아서 close되도록 할 수 있다.
            // 단 closeable을 구현하고 있는 인터페이스를 구현하고 있는것들만 가능하다.
            FileInputStream fis = new FileInputStream("src/com/example/day12/ReadFile.java");
            FileOutputStream fos = new FileOutputStream("outputFile.txt");
            int c;
            // endOfFile까지 마지막에 -1를 반환하기에 이렇게 함
            while((c=fis.read()) != -1) {
                fos.write(c);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

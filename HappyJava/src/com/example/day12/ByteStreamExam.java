package com.example.day12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamExam {
    public static void main(String[] args) {
        // 파일로부터 읽어서 -> 입력 통로가 필요
        // 파일에 쓴다 -> 출력 통로가 필요
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try{
            fis = new FileInputStream("src/com/example/day12/ReadFile.java");
            fos = new FileOutputStream("outputFile.txt");

            int c;
            // endOfFile까지 마지막에 -1를 반환하기에 이렇게 함
            while((c=fis.read()) != -1) {
                fos.write(c);
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            //close도 throws 하기 때문에 try-catch 필요
            // 만약 I/O가 열리지 않았다면, close할때 nullpointException이 발생하기 때문에 조치 필요
            if(fis != null && fos != null){
                try{
                    fis.close();
                    fos.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}

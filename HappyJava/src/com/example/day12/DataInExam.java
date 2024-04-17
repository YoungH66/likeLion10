package com.example.day12;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInExam {
    public static void main(String[] args) {
        try(DataInputStream di = new DataInputStream(new FileInputStream("data.txt"))
        ){
            // 쓰여진 순서대로 읽어야 한다!
            boolean b = di.readBoolean();
            System.out.println(b);
            System.out.println(di.readByte());
            System.out.println(di.readChar());
            System.out.println(di.readDouble());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

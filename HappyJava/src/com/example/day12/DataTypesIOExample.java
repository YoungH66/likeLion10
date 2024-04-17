package com.example.day12;

import java.io.*;

public class DataTypesIOExample {
    // 입출력시 데이터는 모두 바이트이거나 캐릭터로 다뤄진다.
    // 자바의 데이터타입으로 읽고 쓰고 싶다. -> DataInputStream / DataOutputStream
    public static void main(String[] args) {
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.bin"));
            DataInputStream dis = new DataInputStream(new FileInputStream("data.bin"))
        ){
            // 데이터 쓰기
            dos.writeInt(123);
            dos.writeDouble(1.234);
            dos.writeBoolean(true);
            dos.writeUTF("Hello JAVA");

            // 데이터 읽기
            int intData = dis.readInt();
            double doubleData = dis.readDouble();
            boolean booleanData = dis.readBoolean();
            String stringData = dis.readUTF();

            // 출력
            System.out.println("int: " + intData);
            System.out.println("double: " + doubleData);
            System.out.println("boolean: " + booleanData);
            System.out.println("string: " + stringData);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}

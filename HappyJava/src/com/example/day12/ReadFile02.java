package com.example.day12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadFile02 {
    public static void main(String[] args) throws IOException {
        // 현재 위치하고 있는 dir를 반환한다.
//        System.out.println(System.getProperty("user.dir"));

        // 그냥 쓰면 예외, throws 던져야함
        FileInputStream fis = new FileInputStream("a.txt");
        // output으로 출력을 콘솔 이외에 할 수 있다.
        FileOutputStream fos = new FileOutputStream("b.txt");
        int n;
        int cnt = 0;

        // byte 배열을 이용하면 배열만큼 한번에 받아올수 있다.
        byte[] b = new byte[1024];
        // fileinputstream fis의 read를 byte배열 b로 받는다.
//        while((n = fis.read(b)) != -1){
//            // System.out.println(n);
//            String str = new String(b);
//            System.out.println(str);
////            fos.write(b);
//            cnt++;
//        }
//        System.out.println(cnt);
        while((n = fis.read(b)) != -1) {
            System.out.println((char)n);
            cnt++;
            fos.write(b);
        }

        fos.close();
        fis.close();
    }
}

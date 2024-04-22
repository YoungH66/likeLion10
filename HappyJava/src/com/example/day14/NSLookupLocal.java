package com.example.day14;

import java.net.*;

public class NSLookupLocal {
    public static void main(String[] args) {
        try {
            InetAddress addr = InetAddress.getByName("www.google.com");
            InetAddress addr2 = InetAddress.getByName("www.naver.com");
            InetAddress addr3 = InetAddress.getByName("www.youtube.com");

            // 특정 호스트의 IP 주소 조회
            System.out.println("Google IP Address : " + addr.getHostAddress());
            System.out.println("Naver IP Address : " + addr2.getHostAddress());
            System.out.println("Youtube IP Address : " + addr3.getHostAddress());

            // 로컬 호스트의 IP주소와 이름 조회
            InetAddress local = InetAddress.getLocalHost();
            System.out.println("Local IP Address : " + local.getHostAddress());
            System.out.println("Local Host Name : " + local.getHostName());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\n========");

        try{
            InetAddress localAddress = InetAddress.getLocalHost();
            System.out.println(localAddress.getHostName());
            System.out.println(localAddress.getHostAddress());

            System.out.println("byte[] 형식의 ip 주소 변환 ");
            byte[] ip = localAddress.getAddress();
            for (int i = 0; i < ip.length; i++) {
                System.out.println(ip[i] & 0xFF);
                if (i != ip.length - 1)
                    System.out.println(".");
            }
        }catch (UnknownHostException e){
            e.printStackTrace();
        }
    }
}

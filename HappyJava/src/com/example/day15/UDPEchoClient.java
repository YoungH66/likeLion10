package com.example.day15;

import java.io.*;
import java.net.*;

public class UDPEchoClient {
    public static void main(String[] args) {
        try(DatagramSocket socket = new DatagramSocket();
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ){
            // 서버의 주소 설정
            InetAddress ipAddress = InetAddress.getByName("localHost");
            byte[] receiveData = new byte[1024];
            byte[] sendData;

            // 키보드로 입력 받아서
            System.out.println("input message to send...");
            String msg = in.readLine();

            // 서버로 보내기
            DatagramPacket sendPacket = new DatagramPacket(msg.getBytes(), msg.getBytes().length, ipAddress, 8888);
            socket.send(sendPacket);

            // 서버로부터 받기
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);
            String recivedMsg = new String(receivePacket.getData()).trim();

            System.out.println(recivedMsg);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

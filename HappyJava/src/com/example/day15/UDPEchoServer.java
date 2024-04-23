package com.example.day15;

import java.net.*;

public class UDPEchoServer {
    public static void main(String[] args) {
        // UDP 통신 특정 port에 DatagramSocket 생성
        try(DatagramSocket socket = new DatagramSocket(8888);
        )
        {
            while(true) {
                byte[] receiveData = new byte[1024];
                byte[] sendData;
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);  // 클라로부터 받기위해 데이터 보냄

                String msg = new String(receivePacket.getData()).trim();

                InetAddress cliAddr = receivePacket.getAddress();
                int port = receivePacket.getPort();

                DatagramPacket sendPacket = new DatagramPacket(msg.getBytes(), msg.getBytes().length, cliAddr, port);
                socket.send(sendPacket);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

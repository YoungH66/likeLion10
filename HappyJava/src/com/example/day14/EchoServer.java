package com.example.day14;

import java.io.*;
import java.net.*;

public class EchoServer {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9999);
             Socket socket = server.accept();
             BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);)
        {
            String line = null;
            while((line = br.readLine()) != null){
                pw.println(line);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

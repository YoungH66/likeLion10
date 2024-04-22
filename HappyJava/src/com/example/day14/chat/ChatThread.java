package com.example.day14.chat;

import java.io.*;
import java.net.*;

public class ChatThread extends Thread{
    private Socket socket;

    public ChatThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // buffer
        // printwriter
        try(PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        )
            {

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

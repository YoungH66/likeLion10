package com.example.day18;

import java.io.*;
import java.util.*;
import java.net.*;

public class ChatRoom {
    private String name;
    private List<String> chatHistory;
    private Map<String, PrintWriter> clients = new HashMap<>();

    public ChatRoom(String name) {
        this.name = name;
    }

    public void addClient(String clientName, PrintWriter out) {
        clients.put(clientName, out);
    }

    public void broadcastMessage(String message) {
        for (PrintWriter out : clients.values()) {
            out.println(message);
        }
    }

    public List<String> getChatHistory() {
        return chatHistory;
    }

    public void addChat(String chatHistory) {
        this.chatHistory.add(chatHistory+"\n");
    }
}

package com.example.day18;

import java.io.*;
import java.util.*;
import java.net.*;

public class ChatRoom {
    private String roomName;
    private List<String> clients;
    private List<String> chatHistory;

    public ChatRoom(String roomName) {
        this.roomName = roomName;
        this.clients = new ArrayList<>();
        this.chatHistory = new ArrayList<>();
    }

    public synchronized void addClient(String client) {
        clients.add(client);
    }
    public synchronized void removeClient(String client) {
        clients.remove(client);
    }
    public void addMessage(String message) {
        chatHistory.add(message);
    }
    public List<String> getChatHistory() {
        return chatHistory;
    }
    public String getRoomName() {
        return roomName;
    }
}

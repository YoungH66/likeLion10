package com.example.day18;

import java.io.*;
import java.util.*;
import java.net.*;
import java.util.stream.Collectors;

public class ChatRoom {
    private int numOfConnect = -1;
    private String name;
    private List<String> chatHistory = new ArrayList<>();
    private Map<String, PrintWriter> clients = new HashMap<>();
    private List<String> roomUsers = new ArrayList<>();

    public ChatRoom(String name) {
        this.name = name;
        chatHistory.add("채팅방 [" + name + "] 의 채팅 내역입니다.\n");
        numOfConnect = 0;
    }

    public void addClient(String clientName, PrintWriter out) {
        clients.put(clientName, out);
        roomUsers.add(clientName);
        numOfConnect++;
    }

    public void removeClient(String clientName) {
        clients.remove(clientName);
        roomUsers.remove(clientName);
        numOfConnect--;
    }

    public void broadcastMessage(String message) {
        for (PrintWriter out : clients.values()) {
            out.println(message);
        }
    }

    public String getChatHistory() {
        return chatHistory.stream().collect(Collectors.joining("\n"));
    }

    public void addChat(String chatHistory) {
        this.chatHistory.add(chatHistory);
    }

    public Map<String, PrintWriter> getClients() {
        return clients;
    }

    public int getOnline() {
        return numOfConnect;
    }

    public String getRoomUsers() {
        return roomUsers.stream().collect(Collectors.joining("\n"));
    }

}

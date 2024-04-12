package com.example.day09;

public class EventProcessor {
    public void processEvent(String event) {
        class EventHandler {
            public void handle() {
                System.out.println("Processing event: " + event);
            }
        }

        EventHandler handler = new EventHandler();
        handler.handle();
    }

    public static void main(String[] args) {
        EventProcessor ep = new EventProcessor();
        ep.processEvent("Data Update");
    }
}

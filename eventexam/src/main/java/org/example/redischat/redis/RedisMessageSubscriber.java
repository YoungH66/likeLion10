package org.example.redischat.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Component
public class RedisMessageSubscriber implements MessageListener {
    private static final Set<WebSocketSession> sessions = Collections.synchronizedSet(new HashSet<>());
    @Autowired
    private RedisTemplate<String, Objects> redisTemplate;

    public static void addSession(WebSocketSession session) {
        sessions.add(session);
    }
    public static void removeSession(WebSocketSession session) {
        sessions.remove(session);
    }
    @Override
    public void onMessage(Message message, byte[] pattern) {
        String msg = (String) redisTemplate.getValueSerializer().deserialize(message.getBody());

        for(WebSocketSession session : sessions) {
            if(session.isOpen()) {
                // intelliJ try catch문 단축키 ctrl + alt + t
                try {
                    session.sendMessage(new TextMessage(msg));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

package org.example.websocket;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class MyWebSocketHandler extends TextWebSocketHandler {
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("세션 연결 성공 :: "+ session.getId());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();  // 실제 메시지 ( 헤더, 메타정보 와 같은 정보를 제외한 메시지)
        System.out.println("수신된 메시지 :: " + payload);
        // 채팅만들때.. echo
        session.sendMessage(new TextMessage("Echo : " + payload));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("세션 연결 종료 :: "+ session.getId());
    }
}

package org.example.redischat.config;

import lombok.RequiredArgsConstructor;
import org.example.redischat.websocket.CustomHandshakeInterceptor;
import org.example.redischat.websocket.MyWebSocketHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketConfigurer {
    private final CustomHandshakeInterceptor customHandshakeInterceptor;
    private final MyWebSocketHandler myWebSocketHandler;
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(myWebSocketHandler, "/ws").setAllowedOrigins("*")
                .addInterceptors(customHandshakeInterceptor);
    }
}
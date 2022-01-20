package com.gringrape.websocketexample;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

public class TestHandler extends TextWebSocketHandler {
    String lastMessage;

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        this.lastMessage = message.getPayload();
    }
}

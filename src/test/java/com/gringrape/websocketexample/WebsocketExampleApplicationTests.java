package com.gringrape.websocketexample;

import org.junit.jupiter.api.Test;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

import javax.websocket.DeploymentException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutionException;

import static org.assertj.core.api.Assertions.assertThat;

class WebsocketExampleApplicationTests {

    @Test
    void connection() throws DeploymentException, IOException, ExecutionException, InterruptedException {
        StandardWebSocketClient client = new StandardWebSocketClient();

        TestHandler handler = new TestHandler();
        WebSocketSession socketSession = client
                .doHandshake(handler, "ws://localhost:8080")
                .get();

        assertThat(socketSession.isOpen()).isTrue();

        socketSession.sendMessage(new TextMessage("Jin".getBytes(StandardCharsets.UTF_8)));

        Thread.sleep(300);

        assertThat(handler.lastMessage).isEqualTo("Hello, Jin!");
    }
}

package com.janita.websocket.one;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

/**
 * Created by Janita on 2017-04-09 19:54
 */
public class MyWebSocketHandler extends AbstractWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession socketSession, TextMessage textMessage) throws  Exception{
        System.out.println("*****收到消息 : "+ textMessage.getPayload());
        Thread.sleep(2000);
        System.out.println("*****发送消息 : "+ "hello world");
        socketSession.sendMessage(new TextMessage("hello world !"));
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession socketSession){
        System.out.println("*****建立连接");

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("*****关闭连接");
    }
}

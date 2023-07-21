package com.bs.hello.boot.websocket;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

@Component//bean으로등록
@Slf4j
public class ChattingServer extends TextWebSocketHandler{
	
	private Map<String,WebSocketSession> clients=new HashMap<>();
	
	
	//접속 할때 실행
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
	log.debug("접속완료");
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		// TODO Auto-generated method stub
		super.handleMessage(session, message);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// TODO Auto-generated method stub
		super.afterConnectionClosed(session, status);
	}

}

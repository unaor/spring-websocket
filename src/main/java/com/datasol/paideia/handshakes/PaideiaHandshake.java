package com.datasol.paideia.handshakes;

import java.security.Principal;
import java.util.Map;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

public class PaideiaHandshake extends DefaultHandshakeHandler implements WebSocketHandler {

	@Override
	protected Principal determineUser(ServerHttpRequest request,
			WebSocketHandler wsHandler, Map<String, Object> attributes) {
		System.out.println("fired handshake");
		return super.determineUser(request, wsHandler, attributes);
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session)
			throws Exception {
	System.out.println("after connection established");
		
	}

	@Override
	public void handleMessage(WebSocketSession session,
			WebSocketMessage<?> message) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleTransportError(WebSocketSession session,
			Throwable exception) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session,
			CloseStatus closeStatus) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return false;
	}

	

	
}

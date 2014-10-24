package com.datasol.paideia.handshakes;

import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class SimpleHandler extends TextWebSocketHandler{

	@Override
	protected void handleBinaryMessage(WebSocketSession session,
			BinaryMessage message) {
		System.out.println("help me");
		super.handleBinaryMessage(session, message);
	}

}

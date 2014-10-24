package com.datasol.paideia.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.datasol.paideia.handshakes.PaideiaHandshake;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration extends AbstractWebSocketMessageBrokerConfigurer implements WebSocketConfigurer {

	@Override  
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.enableSimpleBroker("/topic","/data");  //where do i subscribe too
		config.setApplicationDestinationPrefixes("/calcApp");  //where do i send to
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/add","/random").setHandshakeHandler(paideiaHandler()).withSockJS();  //where do i expose endpoint
	}

	@Override
	public void configureClientOutboundChannel(ChannelRegistration registration) {
		registration.taskExecutor().corePoolSize(4).maxPoolSize(10);
	}

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		//registry.addHandler(paideiaHandler(), "/random").withSockJS();//.addInterceptors(new HttpSessionHandshakeInterceptor());
		
	}	
	
	
	
	@Bean
	public PaideiaHandshake paideiaHandler(){
		return new PaideiaHandshake();
	}
}

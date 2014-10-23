package com.datasol.paideia.configuration;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.handler.invocation.HandlerMethodArgumentResolver;
import org.springframework.messaging.handler.invocation.HandlerMethodReturnValueHandler;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

	 @Override
	 public void registerStompEndpoints(final StompEndpointRegistry registry) {
	 registry.addEndpoint("/random").withSockJS();
	 }
	 @Override
	 public void configureClientInboundChannel(
	 final ChannelRegistration registration) {
	 }
	 @Override
	 public void configureClientOutboundChannel(
	 final ChannelRegistration registration) {
	 }
	 @Override
	 public void configureMessageBroker(final MessageBrokerRegistry registry) {
		 registry.setApplicationDestinationPrefixes("/paideia").enableSimpleBroker("/data","/test","/uri");
		 
	 }
	@Override
	public void configureWebSocketTransport(
			WebSocketTransportRegistration registry) {
		registry.setSendTimeLimit(15*1000).setSendBufferSizeLimit(512*1024);
		
	}
	@Override
	public void addArgumentResolvers(
			List<HandlerMethodArgumentResolver> argumentResolvers) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addReturnValueHandlers(
			List<HandlerMethodReturnValueHandler> returnValueHandlers) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean configureMessageConverters(
			List<MessageConverter> messageConverters) {
		// TODO Auto-generated method stub
		return true;
	}

}

package com.Hi5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


@Configuration
@EnableWebSocketMessageBroker 
@ComponentScan(basePackages="com.Hi5")
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer

{
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		System.out.println(">>>>>>Register Stomp Endpoints<<<<<<<<");
		registry.addEndpoint("/chatmodule").withSockJS();
	}

	
	public void configureMessageBroker(MessageBrokerRegistry  registry) {
		System.out.println(">>>>>>CONFIGURE MESSAGE BROKER REGISTRY<<<<<<<<");
		registry.setApplicationDestinationPrefixes("/app");
		registry.enableSimpleBroker("/topic/","/queue/");
	}

	
	public void configureClientInboundChannel(ChannelRegistration registration) {
		// TODO Auto-generated method stub
		
	}


	public void configureClientOutboundChannel(ChannelRegistration registration) {
		// TODO Auto-generated method stub
		
	}}
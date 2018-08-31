package com.robotrade.mocktrader.rabbitMQ;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

@Configuration
public class ampqConfig {

	@Bean
	public ConnectionFactory setupCloudAmpFactory(){
		System.out.println("--- Running Connection Factory ---");
		try {
			String uri = "amqp://jkkhhmwu:6rLuxEU_z6N6VTMgJggcEL_qMpaW6B2S@wolverine.rmq.cloudamqp.com/jkkhhmwu";
			if (uri == null) uri = "amqp://guest:guest@localhost";

			ConnectionFactory factory = new ConnectionFactory();
			factory.setUri("amqp://jkkhhmwu:6rLuxEU_z6N6VTMgJggcEL_qMpaW6B2S@wolverine.rmq.cloudamqp.com/jkkhhmwu");

			return factory;
		} catch (KeyManagementException | NoSuchAlgorithmException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Bean
	public Channel setupCloudAmpChannel(ConnectionFactory connectionFactory){
		Connection connection;
		try {
			connection = (Connection) connectionFactory.newConnection();
			Channel channel = ((com.rabbitmq.client.Connection) connection).createChannel();
			return channel;
		} catch (IOException | TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

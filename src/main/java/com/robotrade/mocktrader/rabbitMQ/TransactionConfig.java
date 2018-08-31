package com.robotrade.mocktrader.rabbitMQ;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransactionConfig {

	@Bean
	public TopicExchange roboExchange() {
		return new TopicExchange(RabbitConstants.ROBO_TOPIC_EXCHANGE_NAME);
	}

	@Bean
	public TransactionSender transactionSender() {
		return new TransactionSender();
	}

	@Bean
	public void setupHerokuRabbitConnection() {
		CachingConnectionFactory connectionFactory=new CachingConnectionFactory("wolverine-01.rmq.cloudamqp.com");
		connectionFactory.setUsername("jkkhhmwu");
		connectionFactory.setPassword("6rLuxEU_z6N6VTMgJggcEL_qMpaW6B2S");
		connectionFactory.setVirtualHost("jkkhhmwu");

		// Recommended settings
		connectionFactory.setRequestedHeartBeat(30);
		connectionFactory.setConnectionTimeout(30000);
	}

}

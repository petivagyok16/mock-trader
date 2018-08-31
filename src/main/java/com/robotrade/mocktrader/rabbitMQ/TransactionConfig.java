package com.robotrade.mocktrader.rabbitMQ;

import org.springframework.amqp.core.TopicExchange;
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

}

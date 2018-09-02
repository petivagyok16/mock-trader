package com.robotrade.mocktrader.rabbitMQ.transactions;

import com.robotrade.mocktrader.rabbitMQ.RabbitConstants;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransactionConfig {

	@Autowired
	private final RabbitAdmin cloudAMPQAdmin;

	public TransactionConfig(RabbitAdmin cloudAMPQAdmin) {
		this.cloudAMPQAdmin = cloudAMPQAdmin;
	}

	@Bean
	public TopicExchange roboExchange() {
		TopicExchange topicExchange = new TopicExchange(RabbitConstants.ROBO_TRANSACTION_EXCHANGE_NAME);
		this.cloudAMPQAdmin.declareExchange(topicExchange);
		return topicExchange;
	}

	@Bean
	public TransactionSender transactionSender() {
		return new TransactionSender();
	}

}

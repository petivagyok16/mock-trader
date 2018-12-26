package com.robotrade.mocktrader.rabbitMQ.dev.transactions;

import com.robotrade.mocktrader.rabbitMQ.RabbitConstants;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class TransactionConfig {

	@Bean
	public TopicExchange transactionExchange() {
		return new TopicExchange(RabbitConstants.ROBO_TRANSACTION_EXCHANGE_NAME);
	}

	@Bean
	public TransactionSender transactionSender() {
		return new TransactionSender();
	}

}

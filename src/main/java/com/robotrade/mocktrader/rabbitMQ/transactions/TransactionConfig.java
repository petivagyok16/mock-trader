package com.robotrade.mocktrader.rabbitMQ.transactions;

import com.robotrade.mocktrader.rabbitMQ.RabbitConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
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
		TopicExchange topicExchange = new TopicExchange(RabbitConstants.ROBO_TOPIC_EXCHANGE_NAME);
		this.cloudAMPQAdmin.declareExchange(topicExchange);
		return topicExchange;
	}

	@Bean
	public TransactionSender transactionSender() {
		return new TransactionSender();
	}


	// These two can be deleted if api is configured
	@Bean
	public Queue roboTransactionQueue() {
		Queue roboQueue = new Queue("roboTransactionQueue");
		this.cloudAMPQAdmin.declareQueue(roboQueue);
		return roboQueue;
	}

	@Bean
	public Binding roboTransactionBinding(TopicExchange roboExchange,
																				Queue roboTransactionQueue) {
		Binding transactionBinding = BindingBuilder.bind(roboTransactionQueue)
						.to(roboExchange)
						.with("roboTrade.transaction");
		this.cloudAMPQAdmin.declareBinding(transactionBinding);
		return transactionBinding;
	}

}

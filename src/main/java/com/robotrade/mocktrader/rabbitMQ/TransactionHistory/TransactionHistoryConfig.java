package com.robotrade.mocktrader.rabbitMQ.TransactionHistory;

import com.robotrade.mocktrader.rabbitMQ.RabbitConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransactionHistoryConfig {

	@Autowired
	private final RabbitAdmin cloudAMPQAdmin;

	public TransactionHistoryConfig(RabbitAdmin cloudAMPQAdmin) {
		this.cloudAMPQAdmin = cloudAMPQAdmin;
	}

	public class ServerConfig {

		@Bean
		public Queue transactionHistoryQueue() {
			Queue transactionHistoryQueue = new Queue(RabbitConstants.TRANSACTION_HISTORY_QUEUE_REQUEST_NAME);
			TransactionHistoryConfig.this.cloudAMPQAdmin.declareQueue(transactionHistoryQueue);
			return transactionHistoryQueue;
		}

		@Bean
		public DirectExchange transactionHistoryExchange() {
			DirectExchange transactionHistoryExchange = new DirectExchange(RabbitConstants.TRANSACTION_HISTORY_EXCHANGE_NAME);
			TransactionHistoryConfig.this.cloudAMPQAdmin.declareExchange(transactionHistoryExchange);
			return transactionHistoryExchange;
		}

		@Bean
		public Binding transactionHistoryBinding(DirectExchange transactionHistoryExchange, Queue transactionHistoryQueue) {
			Binding transactionHistoryBinding = BindingBuilder.bind(transactionHistoryQueue)
							.to(transactionHistoryExchange)
							.with(RabbitConstants.TRANSACTION_HISTORY_REQUEST_ROUTING_KEY);
			TransactionHistoryConfig.this.cloudAMPQAdmin.declareBinding(transactionHistoryBinding);
			return transactionHistoryBinding;
		}

		@Bean
		public TransactionHistoryServer server() {
			return new TransactionHistoryServer();
		}
	}

}

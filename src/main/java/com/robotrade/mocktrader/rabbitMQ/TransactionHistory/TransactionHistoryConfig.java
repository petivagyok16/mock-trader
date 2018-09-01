package com.robotrade.mocktrader.rabbitMQ.TransactionHistory;

import com.robotrade.mocktrader.rabbitMQ.RabbitConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransactionHistoryConfig {

	public static class ServerConfig {

		@Bean
		public Queue queue() {
			return new Queue(RabbitConstants.TRANSACTION_HISTORY_QUEUE_REQUEST_NAME);
		}

		@Bean
		public DirectExchange exchange() {
			return new DirectExchange(RabbitConstants.TRANSACTION_HISTORY_EXCHANGE_NAME);
		}

		@Bean
		public Binding binding(DirectExchange exchange,
													 Queue queue) {
			return BindingBuilder.bind(queue)
							.to(exchange)
							.with(RabbitConstants.TRANSACTION_HISTORY_REQUEST_ROUTING_KEY);
		}

		@Bean
		public TransactionHistoryServer server() {
			return new TransactionHistoryServer();
		}
	}

}

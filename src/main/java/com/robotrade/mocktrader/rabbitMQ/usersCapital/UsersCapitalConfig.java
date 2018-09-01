package com.robotrade.mocktrader.rabbitMQ.usersCapital;

import com.robotrade.mocktrader.rabbitMQ.RabbitConstants;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsersCapitalConfig {

	public static class ClientConfig {

		@Bean
		public DirectExchange exchange() {
			return new DirectExchange(RabbitConstants.USER_CAPITAL_EXCHANGE_NAME);
		}

		@Bean
		public UsersCapitalClient client() {
			return new UsersCapitalClient();
		}
	}
}

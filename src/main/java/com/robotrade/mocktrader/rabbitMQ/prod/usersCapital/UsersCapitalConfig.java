package com.robotrade.mocktrader.rabbitMQ.prod.usersCapital;

import com.robotrade.mocktrader.rabbitMQ.RabbitConstants;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class UsersCapitalConfig {

	@Autowired
	private final RabbitAdmin cloudAMPQAdmin;

	public UsersCapitalConfig(RabbitAdmin cloudAMPQAdmin) {
		this.cloudAMPQAdmin = cloudAMPQAdmin;
	}

	@Bean
	public DirectExchange usersCapitalExchange() {
		DirectExchange usersCapitalExchange = new DirectExchange(RabbitConstants.USER_CAPITAL_EXCHANGE_NAME);
		this.cloudAMPQAdmin.declareExchange(usersCapitalExchange);
		return usersCapitalExchange;
	}

	@Bean
	public UsersCapitalClient client() {
		return new UsersCapitalClient();
	}
}

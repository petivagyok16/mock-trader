package com.robotrade.mocktrader.rabbitMQ;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudAMQPConfig {

	@Bean
	public CachingConnectionFactory cloudAMPQConnection() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory("wolverine-01.rmq.cloudamqp.com");
		connectionFactory.setUsername("jkkhhmwu");
		connectionFactory.setPassword("6rLuxEU_z6N6VTMgJggcEL_qMpaW6B2S");
		connectionFactory.setVirtualHost("jkkhhmwu");

		// Recommended settings
		connectionFactory.setRequestedHeartBeat(30);
		connectionFactory.setConnectionTimeout(30000);

		return connectionFactory;
	}

	@Bean
	public RabbitAdmin cloudAMPQAdmin() {
		return new RabbitAdmin(this.cloudAMPQConnection());
	}

	@Bean
	public RabbitTemplate cloudRabbitTemplate() {
		return new RabbitTemplate(this.cloudAMPQConnection());
	}
}

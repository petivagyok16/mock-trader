package com.robotrade.mocktrader.rabbitMQ.prod;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@EnableRabbit
@Profile("prod")
public class CloudAMQPConfig {

	@Value("${CLOUDAMQP_HOSTNAME}")
	private String hostName;

	@Value("${CLOUDAMQP_PASSWORD}")
	private String password;

	@Value("${CLOUDAMQP_USERNAME}")
	private String username;

	@Value("${CLOUDAMQP_VIRTUALHOST}")
	private String virtualhost;


	private final CachingConnectionFactory cloudAMPQConnection;

	public CloudAMQPConfig() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory(this.hostName);
		connectionFactory.setUsername(this.username);
		connectionFactory.setPassword(this.password);
		connectionFactory.setVirtualHost(this.virtualhost);

		// Recommended settings
		connectionFactory.setRequestedHeartBeat(30);
		connectionFactory.setConnectionTimeout(30000);

		this.cloudAMPQConnection = connectionFactory;
	}

	@Bean
	public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() {
		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		factory.setConcurrentConsumers(2);
		factory.setConnectionFactory(this.cloudAMPQConnection);
		return factory;
	}

	@Bean
	public RabbitAdmin cloudAMPQAdmin() {
		return new RabbitAdmin(this.cloudAMPQConnection);
	}

	@Bean
	public RabbitTemplate cloudRabbitTemplate() {
		return new RabbitTemplate(this.cloudAMPQConnection);
	}
}

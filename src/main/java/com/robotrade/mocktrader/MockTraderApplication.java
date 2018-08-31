package com.robotrade.mocktrader;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MockTraderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MockTraderApplication.class, args);

//		CachingConnectionFactory connectionFactory=new CachingConnectionFactory("amqp://jkkhhmwu:6rLuxEU_z6N6VTMgJggcEL_qMpaW6B2S@wolverine.rmq.cloudamqp.com/jkkhhmwu");
//		connectionFactory.setUsername("jkkhhmwu");
//		connectionFactory.setPassword("6rLuxEU_z6N6VTMgJggcEL_qMpaW6B2S");
//		connectionFactory.setVirtualHost("jkkhhmwu");
//
//		// Recommended settings
//		connectionFactory.setRequestedHeartBeat(30);
//		connectionFactory.setConnectionTimeout(30000);
	}
}

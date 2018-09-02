package com.robotrade.mocktrader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MockTraderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MockTraderApplication.class, args);
	}
}

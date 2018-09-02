package com.robotrade.mocktrader.rabbitMQ.usersCapital;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.robotrade.mocktrader.rabbitMQ.RabbitConstants;
import com.robotrade.mocktrader.rabbitMQ.models.AllUsersCapital;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

@NoArgsConstructor
@Slf4j
public class UsersCapitalClient {

	@Autowired
	private RabbitTemplate template;

	@Autowired
	private DirectExchange exchange;

	public UsersCapitalClient(RabbitTemplate cloudRabbitTemplate, DirectExchange usersCapitalExchange) {
		this.template = cloudRabbitTemplate;
		this.exchange = usersCapitalExchange;
	}

//	@Scheduled(fixedDelay = 5000, initialDelay = 500)
	public void requestAllUsersCapital() {
		ObjectMapper mapper = new ObjectMapper();
		String response = (String) template.convertSendAndReceive(this.exchange.getName(), RabbitConstants.USER_CAPITAL_REQUEST_ROUTING_KEY, "Requesting users capital!");
		log.info(" *** USERS CAPITAL RECEIVED: *** ");
		log.info(response);

		try {
			AllUsersCapital allUsersCapital = mapper.readValue(response, AllUsersCapital.class);
		} catch (Exception e) {
			log.info("An error occurred while trying to read JSON!");
			e.printStackTrace();
		}
	}

}

package com.robotrade.mocktrader.rabbitMQ.dev.transactions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.robotrade.mocktrader.rabbitMQ.RabbitConstants;
import com.robotrade.mocktrader.rabbitMQ.models.Transaction;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.Instant;
import java.util.Random;

@Slf4j
@NoArgsConstructor
public class TransactionSender {

	@Autowired
	private RabbitTemplate template;

	private Random random = new Random();

	@Scheduled(initialDelay = 500, fixedDelay = 60000)
	public void send() {
		Transaction transaction = new Transaction(this.random.nextInt(3-1)+1, 5000.0*this.random.nextDouble()+200.0, 800.0*this.random.nextDouble()+30.0, Instant.now().getEpochSecond());
//		Transaction transaction = new Transaction(this.random.nextInt(3-1)+1, 600.00, 300.00, Instant.now().getEpochSecond());
		log.info("*** TRANSACTION TO SEND: *** ");
		log.info(transaction.toString());

		ObjectMapper mapper = new ObjectMapper();

		try {
			String marshaledTransaction = mapper.writeValueAsString(transaction);
			template.convertAndSend(RabbitConstants.ROBO_TRANSACTION_EXCHANGE_NAME, RabbitConstants.TRANSACTION_ROUTING_KEY, marshaledTransaction);
		} catch (JsonProcessingException e) {
			log.info(" --- Error during converting POJO to JSON --- ");
			e.printStackTrace();
		}
	}
}
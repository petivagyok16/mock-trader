package com.robotrade.mocktrader.rabbitMQ.TransactionHistory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.robotrade.mocktrader.rabbitMQ.RabbitConstants;
import com.robotrade.mocktrader.rabbitMQ.mock.TransactionHistoryMock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.util.Collections;

@Slf4j
class TransactionHistoryServer {

	@RabbitListener(queues = RabbitConstants.TRANSACTION_HISTORY_QUEUE_REQUEST_NAME, containerFactory = "rabbitListenerContainerFactory")
	private String sendTransactionHistory(String message) {
		TransactionHistoryMock mock = new TransactionHistoryMock();
		log.info("Sending Transaction History!");

		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(mock.getTransactionHistory());
		} catch (Exception e) {
			log.info("An error occurred while trying to convert POJO to JSON");
			e.printStackTrace();
		}

		return Collections.emptyList().toString();
	}
}

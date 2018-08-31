package com.robotrade.mocktrader.controllers;

import com.robotrade.mocktrader.rabbitMQ.TransactionSender;
import com.robotrade.mocktrader.rabbitMQ.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	TransactionSender transactionSender;

	public TransactionController(TransactionSender transactionSender) {
		this.transactionSender = transactionSender;
	}

	@PostMapping("/send")
	public Mono<ResponseEntity> sendTransactionData(@RequestBody Transaction transaction) {
		// TODO: put transaction inside send()
		this.transactionSender.send();
		return Mono.just(ResponseEntity.ok().build());
	}
}

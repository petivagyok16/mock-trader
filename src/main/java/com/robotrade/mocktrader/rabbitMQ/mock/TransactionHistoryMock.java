package com.robotrade.mocktrader.rabbitMQ.mock;

import com.robotrade.mocktrader.rabbitMQ.models.TransactionHistory;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class TransactionHistoryMock {
	private List<TransactionHistory> transactionHistoryList = new ArrayList<>();

	public List<TransactionHistory> getTransactionHistory() {
		Instant instant = Instant.now();
		TransactionHistory transaction1 = new TransactionHistory(1, 100.00, 50.00, instant.getEpochSecond());
		TransactionHistory transaction2 = new TransactionHistory(2, 50.00, 20.00, instant.getEpochSecond());
		TransactionHistory transaction3 = new TransactionHistory(1, 33.00, 10.00, instant.getEpochSecond());
		TransactionHistory transaction4 = new TransactionHistory(2, 10.00, 50.00, instant.getEpochSecond());

		this.transactionHistoryList.add(transaction1);
		this.transactionHistoryList.add(transaction2);
		this.transactionHistoryList.add(transaction3);
		this.transactionHistoryList.add(transaction4);

		return this.transactionHistoryList;
	}

}

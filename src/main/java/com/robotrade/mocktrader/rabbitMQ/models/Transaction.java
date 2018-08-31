package com.robotrade.mocktrader.rabbitMQ.models;

import lombok.Data;

@Data
public class Transaction {

	private Number type;
	private Double cash;
	private Double stock;
	private Number date;

	public Transaction(Number type, Double cash, Double stock, Number date) {
		this.type = type;
		this.cash = cash;
		this.stock = stock;
		this.date = date;
	}
}

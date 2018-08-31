package com.robotrade.mocktrader.rabbitMQ.models;

import lombok.Data;

@Data
public class AllUsersCapital {
	private Double capital;

	public AllUsersCapital() {};

	public AllUsersCapital(Double capital) {
		this.capital = capital;
	}
}

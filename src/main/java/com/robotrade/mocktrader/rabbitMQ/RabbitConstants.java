package com.robotrade.mocktrader.rabbitMQ;

public class RabbitConstants {
	public static final String TRANSACTION_ROUTING_KEY = "roboTrade.transaction";
	public static final String ROBO_TRANSACTION_EXCHANGE_NAME = "robo-transaction-exchange";

	public static final String TRANSACTION_HISTORY_REQUEST_ROUTING_KEY = "roboTrade.transaction-history-request";
	public static final String TRANSACTION_HISTORY_EXCHANGE_NAME = "robo-transaction-history-exchange";
	public static final String TRANSACTION_HISTORY_QUEUE_REQUEST_NAME = "robo-transaction-history-queue";

	public static final String USER_CAPITAL_REQUEST_ROUTING_KEY = "roboTrade.users-capital";
	public static final String USER_CAPITAL_EXCHANGE_NAME= "robo-users-capital-exchange";
}

package com.robotrade.mocktrader.rabbitMQ;

public class RabbitConstants {
	public static final String TRANSACTION_ROUTING_KEY = "roboTrade.transaction";
	public static final String ROBO_TOPIC_EXCHANGE_NAME = "roboExchange";
	public static final String TRANSACTION_HISTORY_REQUEST_ROUTING_KEY = "roboTransactionHistoryRequest";
	public static final String TRANSACTION_HISTORY_EXCHANGE_NAME = "roboTransactionHistoryExchange";
	public static final String TRANSACTION_HISTORY_QUEUE_REQUEST_NAME = "roboTransactionHistoryRequest";

	public static final String USER_CAPITAL_REQUEST_ROUTING_KEY = "roboUserCapitalRequest";
	public static final String USER_CAPITAL_EXCHANGE_NAME= "roboUserCapitalExchange";
}

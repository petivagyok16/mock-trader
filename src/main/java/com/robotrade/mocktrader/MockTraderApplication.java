package com.robotrade.mocktrader;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class MockTraderApplication {

	static RabbitTemplate rabbitTemplate;

	public static void main(String[] args) {
		SpringApplication.run(MockTraderApplication.class, args);

		CachingConnectionFactory connectionFactory=new CachingConnectionFactory("wolverine-01.rmq.cloudamqp.com");
		connectionFactory.setUsername("jkkhhmwu");
		connectionFactory.setPassword("6rLuxEU_z6N6VTMgJggcEL_qMpaW6B2S");
		connectionFactory.setVirtualHost("jkkhhmwu");

		// Recommended settings
		connectionFactory.setRequestedHeartBeat(30);
		connectionFactory.setConnectionTimeout(30000);

		//Set up queue, exchanges and bindings
		RabbitAdmin admin = new RabbitAdmin(connectionFactory);
		Queue queue = new Queue("myQueue");
		admin.declareQueue(queue);
		TopicExchange exchange = new TopicExchange("myEExchange");
		admin.declareExchange(exchange);
		admin.declareBinding(
						BindingBuilder.bind(queue).to(exchange).with("foo.*"));

		//Set up the listener
		SimpleMessageListenerContainer container =
						new SimpleMessageListenerContainer(connectionFactory);

		Object listener = new Object() {
			public void handleMessage(String foo) {
				System.out.println(foo);
			}
		};

		//Send a message
		MessageListenerAdapter adapter = new MessageListenerAdapter(listener);
		container.setMessageListener(adapter);
		container.setQueueNames("myQueue");
		container.start();

		MockTraderApplication.rabbitTemplate = new RabbitTemplate(connectionFactory);

//		try{
//			Thread.sleep(1000);
//		} catch(InterruptedException e) {
//			Thread.currentThread().interrupt();
//		}
//		container.stop();
	}

	@Scheduled(initialDelay = 1000, fixedDelay = 5000)
	public void sendMessages() {
		MockTraderApplication.rabbitTemplate.convertAndSend("myExchange", "foo.bar", "Hello CloudAMQP!");
	}
}

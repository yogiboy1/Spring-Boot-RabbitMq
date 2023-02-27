package com.yohan.lil.rabbitmqamqptutorials.tut2;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;


public class Tut2Sender {

	@Autowired
	private Queue queue;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void sendMsg(final Integer number) {
		rabbitTemplate.convertAndSend(queue.getName(), number);
		System.out.println("Sent: " + number);
	}

}
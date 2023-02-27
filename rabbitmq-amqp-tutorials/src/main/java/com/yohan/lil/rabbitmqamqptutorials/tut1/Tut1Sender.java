// Sender
package com.yohan.lil.rabbitmqamqptutorials.tut1;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

public class Tut1Sender {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;
    
    public void sendmessage(String message) {
		template.convertAndSend(queue.getName(),message);
	}
}
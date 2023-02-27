package com.yohan.learnrabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yohan.learnrabbit.sender.User;

@Service
public class jsonProducer {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void jsonsend(User user) {
		rabbitTemplate.convertAndSend(LearnrabbitApplication.topicExchangeName,"foo.bar.json",user);
	}
}

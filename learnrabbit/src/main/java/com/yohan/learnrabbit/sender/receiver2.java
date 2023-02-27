package com.yohan.learnrabbit.sender;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class receiver2 {

	@RabbitListener(queues = {"spring-boot-json"} )
	public void receive2Message(User user) throws JsonMappingException, JsonProcessingException {
		/*ObjectMapper mapper = new ObjectMapper();
		  User user = mapper.readValue(json, User.class);*/
		   System.out.println("hello user:"+user);
	  }
	
}

package com.yohan.lil.rabbitmqamqptutorials.tut2;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Profile({"tut2","hello"})
@Configuration
public class Tut2Config {


	@Bean
	public Queue queue() {
		return new Queue("hello");
	}

	@Bean
	public Tut2Sender producer() {
		return new Tut2Sender();
	}
	
	@Bean
	public Tut2Receiver consumer1() {
		return new Tut2Receiver(1);
	}
	
	@Bean
	public Tut2Receiver consumer2() {
		return new Tut2Receiver(2);
	}

}
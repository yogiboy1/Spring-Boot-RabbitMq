package com.yohan.lil.rabbitmqamqptutorials.tut1;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"tut1","hello-world"})
@Configuration
public class Tut1Config {
	
	@Bean
    Queue hello() {
        return new Queue("hello");
    }

    @Profile("receiver")
    @Bean
    Tut1Receiver receiver() {
        return new Tut1Receiver();
    }

    @Profile("sender")
    @Bean
    Tut1Sender sender() {
        return new Tut1Sender();
    }
}
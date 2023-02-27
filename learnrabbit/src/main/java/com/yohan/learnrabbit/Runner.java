package com.yohan.learnrabbit;

import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.yohan.learnrabbit.sender.Receiver;

@Component
public class Runner implements CommandLineRunner {

  private final RabbitTemplate rabbitTemplate;
  private final Receiver receiver;

  public Runner(Receiver receiver, RabbitTemplate rabbitTemplate) {
    this.receiver = receiver;
    this.rabbitTemplate = rabbitTemplate;
  }
  
  public void sendmessage(String message) {
	  rabbitTemplate.convertAndSend(LearnrabbitApplication.topicExchangeName,"foo.bar.uu",message );
  }
  
  @Override
  public void run(String... args) throws Exception {
    System.out.println("Sending message...");
    
  }

}
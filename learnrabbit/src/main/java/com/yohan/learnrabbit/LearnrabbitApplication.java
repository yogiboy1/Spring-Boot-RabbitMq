package com.yohan.learnrabbit;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.yohan.learnrabbit.sender.Receiver;

@SpringBootApplication
public class LearnrabbitApplication {
	
	static final String topicExchangeName = "spring-boot-exchange";

	  static final String queueName = "spring-boot";
	  static final String queueNam = "spring-boot-json";

	  
	  @Bean
	  Queue queue() {
	    return new Queue(queueName,false);
	  }
	
	  @Bean
	  Queue jsQueue(){
		  return new Queue(queueNam,false);
	  }
	  
	  @Bean
	  TopicExchange exchange() {
	    return new TopicExchange(topicExchangeName);
	  }

	  @Bean
	  Binding jsonbinding(Queue jsQueue, TopicExchange exchange) {
	    return BindingBuilder.bind(jsQueue).to(exchange).with("foo.bar.json");
	  }
	  
	  @Bean
	  Binding binding(Queue queue, TopicExchange exchange) {
	    return BindingBuilder.bind(queue).to(exchange).with("foo.bar.#");
	  }

	  /*@Bean
	  SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
	      MessageListenerAdapter listenerAdapter) {
	    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
	    container.setConnectionFactory(connectionFactory);
	    container.setQueueNames(queueName);
	    container.setMessageListener(listenerAdapter);
	    return container;
	  }

	  @Bean
	  MessageListenerAdapter listenerAdapter(Receiver receiver) {
	    return new MessageListenerAdapter(receiver, "receiveMessage");
	  }*/
	  
	  @Bean
	  public MessageConverter messageConverter() {
		  return new Jackson2JsonMessageConverter();
	  }
	  
	  @Bean
	  public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
		  RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		  rabbitTemplate.setMessageConverter(messageConverter());
		  return rabbitTemplate;
	  }
	  
	
	public static void main(String[] args) {
		SpringApplication.run(LearnrabbitApplication.class, args);
	}

}

package com.yohan.learnrabbit.sender;

import java.util.concurrent.CountDownLatch;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

  private CountDownLatch latch = new CountDownLatch(2);
  
  
  public void receiveMessage(String user) {
    System.out.println("Received <" + user + ">");
    latch.countDown();
  }

  public CountDownLatch getLatch() {
    return latch;
  }

}
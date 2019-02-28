
package com.iluwatar.poison.pill;

import com.iluwatar.poison.pill.Message.Headers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class responsible for receiving and handling submitted to the queue messages
 */
public class Consumer {
  
  private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

  private final MqSubscribePoint queue;
  private final String name;

  public Consumer(String name, MqSubscribePoint queue) {
    this.name = name;
    this.queue = queue;
  }

  /**
   * Consume message
   */
  public void consume() {
    while (true) {
      Message msg;
      try {
        msg = queue.take();
        if (Message.POISON_PILL.equals(msg)) {
          LOGGER.info("Consumer {} receive request to terminate.", name);
          break;
        }
      } catch (InterruptedException e) {
        // allow thread to exit
        LOGGER.error("Exception caught.", e);
        return;
      }

      String sender = msg.getHeader(Headers.SENDER);
      String body = msg.getBody();
      LOGGER.info("Message [{}] from [{}] received by [{}]", body, sender, name);
    }
  }
}

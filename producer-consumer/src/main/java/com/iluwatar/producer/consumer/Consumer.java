
package com.iluwatar.producer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class responsible for consume the {@link Item} produced by {@link Producer}
 */
public class Consumer {

  private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

  private final ItemQueue queue;

  private final String name;

  public Consumer(String name, ItemQueue queue) {
    this.name = name;
    this.queue = queue;
  }

  /**
   * Consume item from the queue
   */
  public void consume() throws InterruptedException {

    Item item = queue.take();
    LOGGER.info("Consumer [{}] consume item [{}] produced by [{}]", name, item.getId(), item.getProducer());

  }
}

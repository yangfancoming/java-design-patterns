
package com.iluwatar.producer.consumer;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Date: 12/27/15 - 11:01 PM
 *
 * @author Jeroen Meulemeester
 */
public class ConsumerTest {

  private static final int ITEM_COUNT = 5;

  @Test
  public void testConsume() throws Exception {
    final ItemQueue queue = spy(new ItemQueue());
    for (int id = 0; id < ITEM_COUNT; id++) {
      queue.put(new Item("producer", id));
    }

    reset(queue); // Don't count the preparation above as interactions with the queue
    final Consumer consumer = new Consumer("consumer", queue);

    for (int id = 0; id < ITEM_COUNT; id++) {
      consumer.consume();
    }

    verify(queue, times(ITEM_COUNT)).take();
  }

}

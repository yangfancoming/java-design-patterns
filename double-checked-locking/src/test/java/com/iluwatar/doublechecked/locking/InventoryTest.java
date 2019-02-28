
package com.iluwatar.doublechecked.locking;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Date: 12/10/15 - 9:34 PM
 *
 * @author Jeroen Meulemeester
 */
public class InventoryTest {

  private InMemoryAppender appender;

  @BeforeEach
  public void setUp() {
    appender = new InMemoryAppender(Inventory.class);
  }

  @AfterEach
  public void tearDown() {
    appender.stop();
  }

  /**
   * The number of threads used to stress test the locking of the {@link Inventory#addItem(Item)}
   * method
   */
  private static final int THREAD_COUNT = 8;

  /**
   * The maximum number of {@link Item}s allowed in the {@link Inventory}
   */
  private static final int INVENTORY_SIZE = 1000;

  /**
   * Concurrently add multiple items to the inventory, and check if the items were added in order by
   * checking the stdOut for continuous growth of the inventory. When 'items.size()=xx' shows up out
   * of order, it means that the locking is not ok, increasing the risk of going over the inventory
   * item limit.
   */
  @Test
  public void testAddItem() throws Exception {
    assertTimeout(ofMillis(10000), () -> {
      // Create a new inventory with a limit of 1000 items and put some load on the add method
      final Inventory inventory = new Inventory(INVENTORY_SIZE);
      final ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
      for (int i = 0; i < THREAD_COUNT; i++) {
        executorService.execute(() -> {
          while (inventory.addItem(new Item())) {};
        });
      }

      // Wait until all threads have finished
      executorService.shutdown();
      executorService.awaitTermination(5, TimeUnit.SECONDS);

      // Check the number of items in the inventory. It should not have exceeded the allowed maximum
      final List<Item> items = inventory.getItems();
      assertNotNull(items);
      assertEquals(INVENTORY_SIZE, items.size());

      assertEquals(INVENTORY_SIZE, appender.getLogSize());

      // ... and check if the inventory size is increasing continuously
      for (int i = 0; i < items.size(); i++) {
        assertTrue(appender.log.get(i).getFormattedMessage().contains("items.size()=" + (i + 1)));
      }
    });
  }



  private class InMemoryAppender extends AppenderBase<ILoggingEvent> {
    private List<ILoggingEvent> log = new LinkedList<>();

    public InMemoryAppender(Class clazz) {
      ((Logger) LoggerFactory.getLogger(clazz)).addAppender(this);
      start();
    }

    @Override
    protected void append(ILoggingEvent eventObject) {
      log.add(eventObject);
    }

    public int getLogSize() {
      return log.size();
    }
  }

}

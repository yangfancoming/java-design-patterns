
package com.iluwatar.reactor.app;

import com.iluwatar.reactor.framework.SameThreadDispatcher;
import com.iluwatar.reactor.framework.ThreadPoolDispatcher;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * 
 * This class tests the Distributed Logging service by starting a Reactor and then sending it
 * concurrent logging requests using multiple clients.
 */
public class ReactorTest {

  private static final Logger LOGGER = LoggerFactory.getLogger(ReactorTest.class);

  /**
   * Test the application using pooled thread dispatcher.
   * 
   * @throws IOException if any I/O error occurs.
   * @throws InterruptedException if interrupted while stopping the application.
   */
  @Test
  public void testAppUsingThreadPoolDispatcher() throws IOException, InterruptedException {
    LOGGER.info("testAppUsingThreadPoolDispatcher start");
    App app = new App(new ThreadPoolDispatcher(2));
    app.start();

    AppClient client = new AppClient();
    client.start();

    // allow clients to send requests. Artificial delay.
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      LOGGER.error("sleep interrupted", e);
    }

    client.stop();

    app.stop();
    LOGGER.info("testAppUsingThreadPoolDispatcher stop");
  }

  /**
   * Test the application using same thread dispatcher.
   * 
   * @throws IOException if any I/O error occurs.
   * @throws InterruptedException if interrupted while stopping the application.
   */
  @Test
  public void testAppUsingSameThreadDispatcher() throws IOException, InterruptedException {
    LOGGER.info("testAppUsingSameThreadDispatcher start");
    App app = new App(new SameThreadDispatcher());
    app.start();

    AppClient client = new AppClient();
    client.start();

    // allow clients to send requests. Artificial delay.
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      LOGGER.error("sleep interrupted", e);
    }

    client.stop();

    app.stop();
    LOGGER.info("testAppUsingSameThreadDispatcher stop");
  }
}


package com.iluwatar.resource.acquisition.is.initialization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * SlidingDoor resource
 *
 */
public class SlidingDoor implements AutoCloseable {

  private static final Logger LOGGER = LoggerFactory.getLogger(SlidingDoor.class);

  public SlidingDoor() {
    LOGGER.info("Sliding door opens.");
  }

  @Override
  public void close() throws Exception {
    LOGGER.info("Sliding door closes.");
  }
}

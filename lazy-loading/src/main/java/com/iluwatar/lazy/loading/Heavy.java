
package com.iluwatar.lazy.loading;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * Heavy objects are expensive to create.
 *
 */
public class Heavy {

  private static final Logger LOGGER = LoggerFactory.getLogger(Heavy.class);

  /**
   * Constructor
   */
  public Heavy() {
    LOGGER.info("Creating Heavy ...");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      LOGGER.error("Exception caught.", e);
    }
    LOGGER.info("... Heavy created");
  }
}

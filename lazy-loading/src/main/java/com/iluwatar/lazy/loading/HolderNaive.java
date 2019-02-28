
package com.iluwatar.lazy.loading;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * Simple implementation of the lazy loading idiom. However, this is not thread safe.
 *
 */
public class HolderNaive {

  private static final Logger LOGGER = LoggerFactory.getLogger(HolderNaive.class);

  private Heavy heavy;

  /**
   * Constructor
   */
  public HolderNaive() {
    LOGGER.info("HolderNaive created");
  }

  /**
   * Get heavy object
   */
  public Heavy getHeavy() {
    if (heavy == null) {
      heavy = new Heavy();
    }
    return heavy;
  }
}

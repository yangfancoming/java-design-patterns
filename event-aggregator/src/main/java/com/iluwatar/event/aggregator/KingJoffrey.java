
package com.iluwatar.event.aggregator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * KingJoffrey observes events from {@link KingsHand}.
 *
 */
public class KingJoffrey implements EventObserver {

  private static final Logger LOGGER = LoggerFactory.getLogger(KingJoffrey.class);

  @Override
  public void onEvent(Event e) {
    LOGGER.info("Received event from the King's Hand: {}", e.toString());
  }
}

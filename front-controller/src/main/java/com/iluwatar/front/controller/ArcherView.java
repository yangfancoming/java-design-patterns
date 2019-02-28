
package com.iluwatar.front.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * View for archers.
 *
 */
public class ArcherView implements View {
  
  private static final Logger LOGGER = LoggerFactory.getLogger(ArcherView.class);

  @Override
  public void display() {
    LOGGER.info("Displaying archers");
  }
}


package com.iluwatar.front.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * View for errors.
 *
 */
public class ErrorView implements View {

  private static final Logger LOGGER = LoggerFactory.getLogger(ErrorView.class);

  @Override
  public void display() {
    LOGGER.error("Error 500");
  }
}

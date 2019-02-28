
package com.iluwatar.ambassador;

import org.slf4j.LoggerFactory;

import org.slf4j.Logger;

/**
 * A simple Client
 */
public class Client {

  private static final Logger LOGGER = LoggerFactory.getLogger(Client.class);
  private final ServiceAmbassador serviceAmbassador = new ServiceAmbassador();

  long useService(int value) {
    long result = serviceAmbassador.doRemoteFunction(value);
    LOGGER.info("Service result: " + result);
    return result;
  }
}

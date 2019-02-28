
package com.iluwatar.servicelocator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * For JNDI lookup of services from the web.xml. Will match name of the service name that is being
 * requested and return a newly created service object with the name
 *
 * @author saifasif
 */
public class InitContext {

  private static final Logger LOGGER = LoggerFactory.getLogger(InitContext.class);

  /**
   * Perform the lookup based on the service name. The returned object will need to be casted into a
   * {@link Service}
   *
   * @param serviceName a string
   * @return an {@link Object}
   */
  public Object lookup(String serviceName) {
    if (serviceName.equals("jndi/serviceA")) {
      LOGGER.info("Looking up service A and creating new service for A");
      return new ServiceImpl("jndi/serviceA");
    } else if (serviceName.equals("jndi/serviceB")) {
      LOGGER.info("Looking up service B and creating new service for B");
      return new ServiceImpl("jndi/serviceB");
    } else {
      return null;
    }
  }
}

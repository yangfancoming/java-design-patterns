
package com.iluwatar.servicelocator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Date: 12/29/15 - 19:07 PM
 *
 * @author Jeroen Meulemeester
 */
public class ServiceLocatorTest {

  /**
   * Verify if we just receive 'null' when requesting a non-existing service
   */
  @Test
  public void testGetNonExistentService() {
    assertNull(ServiceLocator.getService("fantastic/unicorn/service"));
    assertNull(ServiceLocator.getService("another/fantastic/unicorn/service"));
  }

  /**
   * Verify if we get the same cached instance when requesting the same service twice
   */
  @Test
  public void testServiceCache() {
    final String[] serviceNames = new String[]{
        "jndi/serviceA", "jndi/serviceB"
    };

    for (final String serviceName : serviceNames) {
      final Service service = ServiceLocator.getService(serviceName);
      assertNotNull(service);
      assertEquals(serviceName, service.getName());
      assertTrue(service.getId() > 0); // The id is generated randomly, but the minimum value is '1'
      assertSame(service, ServiceLocator.getService(serviceName));
    }

  }

}
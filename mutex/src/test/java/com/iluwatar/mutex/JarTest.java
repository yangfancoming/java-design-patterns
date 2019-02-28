
package com.iluwatar.mutex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test case for taking beans from a Jar
 */
public class JarTest {

  @Test
  public void testTakeBeans() {
    Mutex mutex = new Mutex();
    Jar jar = new Jar(10, mutex);
    for (int i = 0; i < 10; i++) {
      assertTrue(jar.takeBean());
    }
    assertFalse(jar.takeBean());
  }

}
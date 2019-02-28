
package com.iluwatar.semaphore;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Test case for acquiring and releasing a Semaphore
 */
public class SemaphoreTest {

  @Test
  public void acquireReleaseTest() {
    Semaphore sphore = new Semaphore(3);

    assertEquals(3, sphore.getAvailableLicenses());

    for (int i = 2; i >= 0; i--) {
      try {
        sphore.acquire();
        assertEquals(i, sphore.getAvailableLicenses());
      } catch (InterruptedException e) {
        fail(e.toString());
      }
    }
  
    for (int i = 1; i <= 3; i++) {
      sphore.release();
      assertEquals(i, sphore.getAvailableLicenses());
    }

    sphore.release();
    assertEquals(3, sphore.getAvailableLicenses());
  }
}

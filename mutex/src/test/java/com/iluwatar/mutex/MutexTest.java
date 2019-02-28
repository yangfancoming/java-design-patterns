
package com.iluwatar.mutex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Test case for acquiring and releasing a Mutex
 */
public class MutexTest {

  @Test
  public void acquireReleaseTest() {
    Mutex mutex = new Mutex();
    assertNull(mutex.getOwner());
    try {
      mutex.acquire();
      assertEquals(mutex.getOwner(), Thread.currentThread());
    } catch (InterruptedException e) {
      fail(e.toString());
    }
    mutex.release();
    assertNull(mutex.getOwner());
  }

}
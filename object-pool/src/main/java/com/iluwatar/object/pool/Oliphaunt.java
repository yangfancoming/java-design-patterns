
package com.iluwatar.object.pool;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * Oliphaunts are expensive to create
 *
 */
public class Oliphaunt {

  private static AtomicInteger counter = new AtomicInteger(0);

  private final int id;

  /**
   * Constructor
   */
  public Oliphaunt() {
    id = counter.incrementAndGet();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    return String.format("Oliphaunt id=%d", id);
  }
}


package com.iluwatar.semaphore;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Test taking from and putting Fruit into a FruitBowl
 */
public class FruitBowlTest {

  @Test
  public void fruitBowlTest() {
    FruitBowl fbowl = new FruitBowl();
    
    assertEquals(0, fbowl.countFruit());
    
    for (int i = 1; i <= 10; i++) {
      fbowl.put(new Fruit(Fruit.FruitType.LEMON));
      assertEquals(i, fbowl.countFruit());
    }

    for (int i = 9; i >= 0; i--) {
      assertNotNull(fbowl.take());
      assertEquals(i, fbowl.countFruit());
    }

    assertNull(fbowl.take());
  }
}

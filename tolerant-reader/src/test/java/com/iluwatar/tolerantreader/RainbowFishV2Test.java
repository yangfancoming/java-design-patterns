
package com.iluwatar.tolerantreader;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Date: 12/30/15 - 18:35 PM
 *
 * @author Jeroen Meulemeester
 */
public class RainbowFishV2Test {

  /**
   * Verify if the getters of a {@link RainbowFish} return the expected values
   */
  @Test
  public void testValues() {
    final RainbowFishV2 fish = new RainbowFishV2("name", 1, 2, 3, false, true, false);
    assertEquals("name", fish.getName());
    assertEquals(1, fish.getAge());
    assertEquals(2, fish.getLengthMeters());
    assertEquals(3, fish.getWeightTons());
    assertFalse(fish.getSleeping());
    assertTrue(fish.getHungry());
    assertFalse(fish.getAngry());
  }

}
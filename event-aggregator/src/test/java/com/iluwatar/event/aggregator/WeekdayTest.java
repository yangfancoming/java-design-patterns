
package com.iluwatar.event.aggregator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Date: 12/12/15 - 2:12 PM
 *
 * @author Jeroen Meulemeester
 */
public class WeekdayTest {

  @Test
  public void testToString() {
    for (final Weekday weekday : Weekday.values()) {
      final String toString = weekday.toString();
      assertNotNull(toString);
      assertEquals(weekday.name(), toString.toUpperCase());
    }
  }

}

package com.iluwatar.event.aggregator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Date: 12/12/15 - 2:52 PM
 *
 * @author Jeroen Meulemeester
 */
public class EventTest {

  /**
   * Verify if every event has a non-null, non-empty description
   */
  @Test
  public void testToString() {
    for (final Event event : Event.values()) {
      final String toString = event.toString();
      assertNotNull(toString);
      assertFalse(toString.trim().isEmpty());
    }
  }

}
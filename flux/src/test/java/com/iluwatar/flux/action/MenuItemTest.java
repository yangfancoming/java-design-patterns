
package com.iluwatar.flux.action;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Date: 12/12/15 - 10:15 PM
 *
 * @author Jeroen Meulemeester
 */
public class MenuItemTest {

  @Test
  public void testToString() throws Exception {
    for (final MenuItem menuItem : MenuItem.values()) {
      final String toString = menuItem.toString();
      assertNotNull(toString);
      assertFalse(toString.trim().isEmpty());
    }
  }

}

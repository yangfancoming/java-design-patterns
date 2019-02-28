
package com.iluwatar.multiton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * Date: 12/22/15 - 22:28 AM
 *
 * @author Jeroen Meulemeester
 */
public class NazgulTest {

  /**
   * Verify if {@link Nazgul#getInstance(NazgulName)} returns the correct Nazgul multiton instance
   */
  @Test
  public void testGetInstance() {
    for (final NazgulName name : NazgulName.values()) {
      final Nazgul nazgul = Nazgul.getInstance(name);
      assertNotNull(nazgul);
      assertSame(nazgul, Nazgul.getInstance(name));
      assertEquals(name, nazgul.getName());
    }
  }

}


package com.iluwatar.lazy.loading;

import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTimeout;

/**
 * Date: 12/19/15 - 11:58 AM
 *
 * @author Jeroen Meulemeester
 */
public abstract class AbstractHolderTest {

  /**
   * Get the internal state of the holder value
   *
   * @return The internal value
   */
  abstract Heavy getInternalHeavyValue() throws Exception;

  /**
   * Request a lazy loaded {@link Heavy} object from the holder.
   *
   * @return The lazy loaded {@link Heavy} object
   */
  abstract Heavy getHeavy() throws Exception;

  /**
   * This test shows that the heavy field is not instantiated until the method getHeavy is called
   */
  @Test
  public void testGetHeavy() throws Exception {
    assertTimeout(ofMillis(3000), () -> {
      assertNull(getInternalHeavyValue());
      assertNotNull(getHeavy());
      assertNotNull(getInternalHeavyValue());
      assertSame(getHeavy(), getInternalHeavyValue());
    });
  }

}

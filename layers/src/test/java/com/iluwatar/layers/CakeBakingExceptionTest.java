
package com.iluwatar.layers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Date: 12/15/15 - 7:57 PM
 *
 * @author Jeroen Meulemeester
 */
public class CakeBakingExceptionTest {

  @Test
  public void testConstructor() {
    final CakeBakingException exception = new CakeBakingException();
    assertNull(exception.getMessage());
    assertNull(exception.getCause());
  }

  @Test
  public void testConstructorWithMessage() {
    final String expectedMessage = "message";
    final CakeBakingException exception = new CakeBakingException(expectedMessage);
    assertEquals(expectedMessage, exception.getMessage());
    assertNull(exception.getCause());
  }

}


package com.iluwatar.poison.pill;

import org.junit.jupiter.api.Test;

import static com.iluwatar.poison.pill.Message.Headers;
import static com.iluwatar.poison.pill.Message.POISON_PILL;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Date: 12/27/15 - 10:30 PM
 *
 * @author Jeroen Meulemeester
 */
public class PoisonMessageTest {

  @Test
  public void testAddHeader() {
    assertThrows(UnsupportedOperationException.class, () -> {
      POISON_PILL.addHeader(Headers.SENDER, "sender");
    });
  }

  @Test
  public void testGetHeader() {
    assertThrows(UnsupportedOperationException.class, () -> {
      POISON_PILL.getHeader(Headers.SENDER);
    });
  }

  @Test
  public void testGetHeaders() {
    assertThrows(UnsupportedOperationException.class, POISON_PILL::getHeaders);
  }

  @Test
  public void testSetBody() {
    assertThrows(UnsupportedOperationException.class, () -> {
      POISON_PILL.setBody("Test message.");
    });
  }

  @Test
  public void testGetBody() {
    assertThrows(UnsupportedOperationException.class, POISON_PILL::getBody);
  }

}


package com.iluwatar.privateclassdata;

import com.iluwatar.privateclassdata.utils.InMemoryAppender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Date: 12/27/15 - 10:46 PM
 *
 * @author Jeroen Meulemeester
 */
public class ImmutableStewTest {

  private InMemoryAppender appender;

  @BeforeEach
  public void setUp() {
    appender = new InMemoryAppender();
  }

  @AfterEach
  public void tearDown() {
    appender.stop();
  }

  /**
   * Verify if mixing the stew doesn't change the internal state
   */
  @Test
  public void testMix() {
    final Stew stew = new Stew(1, 2, 3, 4);
    final String expectedMessage = "Mixing the stew we find: 1 potatoes, 2 carrots, 3 meat and 4 peppers";

    for (int i = 0; i < 20; i++) {
      stew.mix();
      assertEquals(expectedMessage, appender.getLastMessage());
    }

    assertEquals(20, appender.getLogSize());
  }

  /**
   * Verify if tasting the stew actually removes one of each ingredient
   */
  @Test
  public void testDrink() {
    final Stew stew = new Stew(1, 2, 3, 4);
    stew.mix();

    assertEquals("Mixing the stew we find: 1 potatoes, 2 carrots, 3 meat and 4 peppers",  appender.getLastMessage());

    stew.taste();
    assertEquals("Tasting the stew",  appender.getLastMessage());

    stew.mix();
    assertEquals("Mixing the stew we find: 0 potatoes, 1 carrots, 2 meat and 3 peppers",  appender.getLastMessage());
  }
}

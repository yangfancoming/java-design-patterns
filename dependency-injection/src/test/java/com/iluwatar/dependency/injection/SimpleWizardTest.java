
package com.iluwatar.dependency.injection;

import com.iluwatar.dependency.injection.utils.InMemoryAppender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Date: 12/10/15 - 8:26 PM
 *
 * @author Jeroen Meulemeester
 */
public class SimpleWizardTest {

  private InMemoryAppender appender;

  @BeforeEach
  public void setUp() {
    appender = new InMemoryAppender(Tobacco.class);
  }

  @AfterEach
  public void tearDown() {
    appender.stop();
  }

  /**
   * Test if the {@link SimpleWizard} does the only thing it can do: Smoke it's {@link
   * OldTobyTobacco}
   */
  @Test
  public void testSmoke() {
    final SimpleWizard simpleWizard = new SimpleWizard();
    simpleWizard.smoke();
    assertEquals("SimpleWizard smoking OldTobyTobacco", appender.getLastMessage());
    assertEquals(1, appender.getLogSize());
  }

}

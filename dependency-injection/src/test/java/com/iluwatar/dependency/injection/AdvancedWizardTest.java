
package com.iluwatar.dependency.injection;

import com.iluwatar.dependency.injection.utils.InMemoryAppender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Date: 12/10/15 - 8:40 PM
 *
 * @author Jeroen Meulemeester
 */
public class AdvancedWizardTest {

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
   * Test if the {@link AdvancedWizard} smokes whatever instance of {@link Tobacco} is passed to him
   * through the constructor parameter
   */
  @Test
  public void testSmokeEveryThing() throws Exception {

    final Tobacco[] tobaccos = {
        new OldTobyTobacco(), new RivendellTobacco(), new SecondBreakfastTobacco()
    };

    for (final Tobacco tobacco : tobaccos) {
      final AdvancedWizard advancedWizard = new AdvancedWizard(tobacco);
      advancedWizard.smoke();

      // Verify if the wizard is smoking the correct tobacco ...
      assertEquals("AdvancedWizard smoking " + tobacco.getClass().getSimpleName(), appender.getLastMessage());

    }

    // ... and nothing else is happening.
    assertEquals(tobaccos.length, appender.getLogSize());

  }

}


package com.iluwatar.dependency.injection;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.iluwatar.dependency.injection.utils.InMemoryAppender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Date: 12/10/15 - 8:57 PM
 *
 * @author Jeroen Meulemeester
 */
public class GuiceWizardTest {

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
   * Test if the {@link GuiceWizard} smokes whatever instance of {@link Tobacco} is passed to him
   * through the constructor parameter
   */
  @Test
  public void testSmokeEveryThingThroughConstructor() throws Exception {

    final Tobacco[] tobaccos = {
        new OldTobyTobacco(), new RivendellTobacco(), new SecondBreakfastTobacco()
    };

    for (final Tobacco tobacco : tobaccos) {
      final GuiceWizard guiceWizard = new GuiceWizard(tobacco);
      guiceWizard.smoke();

      // Verify if the wizard is smoking the correct tobacco ...
      assertEquals("GuiceWizard smoking " + tobacco.getClass().getSimpleName(), appender.getLastMessage());
    }

    // ... and nothing else is happening.
    assertEquals(tobaccos.length, appender.getLogSize());
  }

  /**
   * Test if the {@link GuiceWizard} smokes whatever instance of {@link Tobacco} is passed to him
   * through the Guice google inject framework
   */
  @Test
  public void testSmokeEveryThingThroughInjectionFramework() throws Exception {

    @SuppressWarnings("unchecked")
    final Class<? extends Tobacco>[] tobaccos = new Class[]{
        OldTobyTobacco.class, RivendellTobacco.class, SecondBreakfastTobacco.class
    };

    for (final Class<? extends Tobacco> tobaccoClass : tobaccos) {
      // Configure the tobacco in the injection framework ...
      final Injector injector = Guice.createInjector(new AbstractModule() {
        @Override
        protected void configure() {
          bind(Tobacco.class).to(tobaccoClass);
        }
      });

      // ... and create a new wizard with it
      final GuiceWizard guiceWizard = injector.getInstance(GuiceWizard.class);
      guiceWizard.smoke();

      // Verify if the wizard is smoking the correct tobacco ...
      assertEquals("GuiceWizard smoking " + tobaccoClass.getSimpleName(), appender.getLastMessage());
    }

    // ... and nothing else is happening.
    assertEquals(tobaccos.length, appender.getLogSize());
  }

}

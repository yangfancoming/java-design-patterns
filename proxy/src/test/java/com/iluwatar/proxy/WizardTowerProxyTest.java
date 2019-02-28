
package com.iluwatar.proxy;

import com.iluwatar.proxy.utils.InMemoryAppender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for {@link WizardTowerProxy}
 */
public class WizardTowerProxyTest {

  private InMemoryAppender appender;

  @BeforeEach
  public void setUp() {
    appender = new InMemoryAppender();
  }

  @AfterEach
  public void tearDown() {
    appender.stop();
  }

  @Test
  public void testEnter() throws Exception {
    final Wizard[] wizards = new Wizard[]{
        new Wizard("Gandalf"),
        new Wizard("Dumbledore"),
        new Wizard("Oz"),
        new Wizard("Merlin")
    };

    final WizardTowerProxy proxy = new WizardTowerProxy(new IvoryTower());
    for (Wizard wizard : wizards) {
      proxy.enter(wizard);
    }

    assertTrue(appender.logContains("Gandalf enters the tower."));
    assertTrue(appender.logContains("Dumbledore enters the tower."));
    assertTrue(appender.logContains("Oz enters the tower."));
    assertTrue(appender.logContains("Merlin is not allowed to enter!"));
    assertEquals(4, appender.getLogSize());
  }
}

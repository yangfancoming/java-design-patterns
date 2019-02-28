
package com.iluwatar.proxy;

import com.iluwatar.proxy.utils.InMemoryAppender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for {@link IvoryTower}
 */
public class IvoryTowerTest {

  private InMemoryAppender appender;

  @BeforeEach
  public void setUp() {
    appender = new InMemoryAppender(IvoryTower.class);
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

    IvoryTower tower = new IvoryTower();
    for (Wizard wizard : wizards) {
      tower.enter(wizard);
    }

    assertTrue(appender.logContains("Gandalf enters the tower."));
    assertTrue(appender.logContains("Dumbledore enters the tower."));
    assertTrue(appender.logContains("Oz enters the tower."));
    assertTrue(appender.logContains("Merlin enters the tower."));
    assertEquals(4, appender.getLogSize());
  }
}


package com.iluwatar.proxy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for {@link Wizard}
 */
public class WizardTest {

  @Test
  public void testToString() throws Exception {
    final String[] wizardNames = {"Gandalf", "Dumbledore", "Oz", "Merlin"};
    for (String name : wizardNames) {
      assertEquals(name, new Wizard(name).toString());
    }
  }
}
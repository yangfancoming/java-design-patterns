
package com.iluwatar.bridge;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

/**
 * Tests for hammer
 */
public class HammerTest extends WeaponTest {

  /**
   * Invoke all possible actions on the weapon and check if the actions are executed on the actual
   * underlying weapon implementation.
   */
  @Test
  public void testHammer() {
    final Hammer hammer = spy(new Hammer(mock(FlyingEnchantment.class)));
    testBasicWeaponActions(hammer);
  }
}
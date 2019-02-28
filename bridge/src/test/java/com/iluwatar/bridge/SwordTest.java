
package com.iluwatar.bridge;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

/**
 * Tests for sword
 */
public class SwordTest extends WeaponTest {

  /**
   * Invoke all possible actions on the weapon and check if the actions are executed on the actual
   * underlying weapon implementation.
   */
  @Test
  public void testSword() {
    final Sword sword = spy(new Sword(mock(FlyingEnchantment.class)));
    testBasicWeaponActions(sword);
  }
}

package com.iluwatar.multiton;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author anthony
 *
 */
class NazgulEnumTest {

  /**
   * Check that multiple calls to any one of the instances in the multiton returns 
   * only that one particular instance, and do that for all instances in multiton
   */
  @Test
  public void testTheSameObjectIsReturnedWithMultipleCalls() {
    for (int i = 0; i < NazgulEnum.values().length; i++) {
      NazgulEnum instance1 = NazgulEnum.values()[i];
      NazgulEnum instance2 = NazgulEnum.values()[i];
      NazgulEnum instance3 = NazgulEnum.values()[i];
      assertSame(instance1, instance2);
      assertSame(instance1, instance3);
      assertSame(instance2, instance3);
    }
  }
}

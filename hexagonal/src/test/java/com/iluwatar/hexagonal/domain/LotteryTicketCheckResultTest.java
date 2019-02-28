
package com.iluwatar.hexagonal.domain;

import com.iluwatar.hexagonal.domain.LotteryTicketCheckResult.CheckResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * 
 * Unit tests for {@link LotteryTicketCheckResult}
 *
 */
class LotteryTicketCheckResultTest {

  @Test
  void testEquals() {
    LotteryTicketCheckResult result1 = new LotteryTicketCheckResult(CheckResult.NO_PRIZE);
    LotteryTicketCheckResult result2 = new LotteryTicketCheckResult(CheckResult.NO_PRIZE);
    assertEquals(result1, result2);
    LotteryTicketCheckResult result3 = new LotteryTicketCheckResult(CheckResult.WIN_PRIZE, 300000);
    assertNotEquals(result1, result3);
  } 
}

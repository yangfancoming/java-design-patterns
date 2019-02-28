
package com.iluwatar.hexagonal.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Tests for lottery ticket id
 */
class LotteryTicketIdTest {

  @Test
  void testEquals() {
    LotteryTicketId ticketId1 = new LotteryTicketId();
    LotteryTicketId ticketId2 = new LotteryTicketId();
    LotteryTicketId ticketId3 = new LotteryTicketId();
    assertNotEquals(ticketId1, ticketId2);
    assertNotEquals(ticketId2, ticketId3);
    LotteryTicketId ticketId4 = new LotteryTicketId(ticketId1.getId());
    assertEquals(ticketId1, ticketId4);
  }
}

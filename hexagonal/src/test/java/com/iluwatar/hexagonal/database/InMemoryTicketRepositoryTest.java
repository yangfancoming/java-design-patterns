
package com.iluwatar.hexagonal.database;

import java.util.Optional;

import com.iluwatar.hexagonal.domain.LotteryTicket;
import com.iluwatar.hexagonal.domain.LotteryTicketId;
import com.iluwatar.hexagonal.test.LotteryTestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 
 * Tests for {@link LotteryTicketRepository}
 *
 */
class InMemoryTicketRepositoryTest {

  private final LotteryTicketRepository repository = new InMemoryTicketRepository();
  
  @BeforeEach
  void clear() {
    repository.deleteAll();
  }
  
  @Test
  void testCrudOperations() {
    LotteryTicketRepository repository = new InMemoryTicketRepository();
    assertTrue(repository.findAll().isEmpty());
    LotteryTicket ticket = LotteryTestUtils.createLotteryTicket();
    Optional<LotteryTicketId> id = repository.save(ticket);
    assertTrue(id.isPresent());
    assertEquals(1, repository.findAll().size());
    Optional<LotteryTicket> optionalTicket = repository.findById(id.get());
    assertTrue(optionalTicket.isPresent());
  }
}

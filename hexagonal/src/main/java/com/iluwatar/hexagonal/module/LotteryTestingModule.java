
package com.iluwatar.hexagonal.module;

import com.google.inject.AbstractModule;
import com.iluwatar.hexagonal.banking.InMemoryBank;
import com.iluwatar.hexagonal.banking.WireTransfers;
import com.iluwatar.hexagonal.database.InMemoryTicketRepository;
import com.iluwatar.hexagonal.database.LotteryTicketRepository;
import com.iluwatar.hexagonal.eventlog.LotteryEventLog;
import com.iluwatar.hexagonal.eventlog.StdOutEventLog;

/**
 * Guice module for testing dependencies
 */
public class LotteryTestingModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(LotteryTicketRepository.class).to(InMemoryTicketRepository.class);
    bind(LotteryEventLog.class).to(StdOutEventLog.class);
    bind(WireTransfers.class).to(InMemoryBank.class);
  }
}


package com.iluwatar.hexagonal.module;

import com.google.inject.AbstractModule;
import com.iluwatar.hexagonal.banking.MongoBank;
import com.iluwatar.hexagonal.banking.WireTransfers;
import com.iluwatar.hexagonal.database.LotteryTicketRepository;
import com.iluwatar.hexagonal.database.MongoTicketRepository;
import com.iluwatar.hexagonal.eventlog.LotteryEventLog;
import com.iluwatar.hexagonal.eventlog.MongoEventLog;

/**
 * Guice module for binding production dependencies
 */
public class LotteryModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(LotteryTicketRepository.class).to(MongoTicketRepository.class);
    bind(LotteryEventLog.class).to(MongoEventLog.class);
    bind(WireTransfers.class).to(MongoBank.class);
  }
}

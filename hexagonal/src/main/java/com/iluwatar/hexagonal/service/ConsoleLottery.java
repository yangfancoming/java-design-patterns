
package com.iluwatar.hexagonal.service;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.iluwatar.hexagonal.banking.WireTransfers;
import com.iluwatar.hexagonal.domain.LotteryService;
import com.iluwatar.hexagonal.module.LotteryModule;
import com.iluwatar.hexagonal.mongo.MongoConnectionPropertiesLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * Console interface for lottery players
 */
public class ConsoleLottery {

  private static final Logger LOGGER = LoggerFactory.getLogger(ConsoleLottery.class);

  /**
   * Program entry point
   */
  public static void main(String[] args) {
    MongoConnectionPropertiesLoader.load();
    Injector injector = Guice.createInjector(new LotteryModule());
    LotteryService service = injector.getInstance( LotteryService.class);
    WireTransfers bank = injector.getInstance(WireTransfers.class);
    try (final Scanner scanner = new Scanner(System.in)) {
      boolean exit = false;
      while (!exit) {
        printMainMenu();
        String cmd = readString(scanner);
        LotteryConsoleService lotteryConsoleService = new LotteryConsoleServiceImpl(LOGGER);
        if ("1".equals(cmd)) {
          lotteryConsoleService.queryLotteryAccountFunds(bank, scanner);
        } else if ("2".equals(cmd)) {
          lotteryConsoleService.addFundsToLotteryAccount(bank, scanner);
        } else if ("3".equals(cmd)) {
          lotteryConsoleService.submitTicket(service, scanner);
        } else if ("4".equals(cmd)) {
          lotteryConsoleService.checkTicket(service, scanner);
        } else if ("5".equals(cmd)) {
          exit = true;
        } else {
          LOGGER.info("Unknown command");
        }
      }
    }
  }

  private static void printMainMenu() {
    LOGGER.info("");
    LOGGER.info("### Lottery Service Console ###");
    LOGGER.info("(1) Query lottery account funds");
    LOGGER.info("(2) Add funds to lottery account");
    LOGGER.info("(3) Submit ticket");
    LOGGER.info("(4) Check ticket");
    LOGGER.info("(5) Exit");
  }

  private static String readString(Scanner scanner) {
    System.out.print("> ");
    return scanner.next();
  }
}

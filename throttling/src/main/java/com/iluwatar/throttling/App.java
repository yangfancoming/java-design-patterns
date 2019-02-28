

package com.iluwatar.throttling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iluwatar.throttling.timer.Throttler;
import com.iluwatar.throttling.timer.ThrottleTimerImpl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Throttling pattern is a design pattern to throttle or limit the use of resources or even a complete service by
 * users or a particular tenant. This can allow systems to continue to function and meet service level agreements,
 * even when an increase in demand places load on resources.
 * <p>
 *     In this example we have ({@link App}) as the initiating point of the service.
 *     This is a time based throttling, i.e. only a certain number of calls are allowed per second.
 * </p>
 * ({@link Tenant}) is the Tenant POJO class with which many tenants can be created
 * ({@link B2BService}) is the service which is consumed by the tenants and is throttled.
 */
public class App {

  private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

  /**
   * Application entry point
   * @param args main arguments
   */
  public static void main(String[] args) {
    CallsCount callsCount = new CallsCount();
    Tenant adidas = new Tenant("Adidas", 5, callsCount);
    Tenant nike = new Tenant("Nike", 6, callsCount);

    ExecutorService executorService = Executors.newFixedThreadPool(2);
    
    executorService.execute(() -> makeServiceCalls(adidas, callsCount));
    executorService.execute(() -> makeServiceCalls(nike, callsCount));
    
    executorService.shutdown();
    try {
      executorService.awaitTermination(10, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      LOGGER.error("Executor Service terminated: {}", e.getMessage());
    }
  }

  /**
   * Make calls to the B2BService dummy API
   */
  private static void makeServiceCalls(Tenant tenant, CallsCount callsCount) {
    Throttler timer = new ThrottleTimerImpl(10, callsCount);
    B2BService service = new B2BService(timer, callsCount);
    for (int i = 0; i < 20; i++) {
      service.dummyCustomerApi(tenant);
//    Sleep is introduced to keep the output in check and easy to view and analyze the results.
      try {
        Thread.sleep(1);
      } catch (InterruptedException e) {
        LOGGER.error("Thread interrupted: {}", e.getMessage());
      }
    }
  }
}

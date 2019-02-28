
package com.iluwatar.ambassador;

import com.iluwatar.ambassador.util.RandomProvider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test for {@link RemoteService}
 */
public class RemoteServiceTest {

  @Test
  public void testFailedCall() {
    RemoteService remoteService = new RemoteService(
        new StaticRandomProvider(0.21));
    long result = remoteService.doRemoteFunction(10);
    assertEquals(RemoteServiceInterface.FAILURE, result);
  }

  @Test
  public void testSuccessfulCall() {
    RemoteService remoteService = new RemoteService(
        new StaticRandomProvider(0.2));
    long result = remoteService.doRemoteFunction(10);
    assertEquals(100, result);
  }

  private class StaticRandomProvider implements RandomProvider {
    private double value;

    StaticRandomProvider(double value) {
      this.value = value;
    }

    @Override
    public double random() {
      return value;
    }
  }
}

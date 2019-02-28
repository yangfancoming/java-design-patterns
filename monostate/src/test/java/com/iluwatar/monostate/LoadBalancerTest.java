
package com.iluwatar.monostate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

/**
 * Date: 12/21/15 - 12:26 PM
 *
 * @author Jeroen Meulemeester
 */
public class LoadBalancerTest {

  @Test
  public void testSameStateAmongstAllInstances() {
    final LoadBalancer firstBalancer = new LoadBalancer();
    final LoadBalancer secondBalancer = new LoadBalancer();
    firstBalancer.addServer(new Server("localhost", 8085, 6));
    // Both should have the same number of servers.
    assertEquals(firstBalancer.getNoOfServers(), secondBalancer.getNoOfServers());
    // Both Should have the same LastServedId
    assertEquals(firstBalancer.getLastServedId(), secondBalancer.getLastServedId());
  }

  @Test
  public void testServe() {
    final Server server = mock(Server.class);
    when(server.getHost()).thenReturn("testhost");
    when(server.getPort()).thenReturn(1234);
    doNothing().when(server).serve(any(Request.class));

    final LoadBalancer loadBalancer = new LoadBalancer();
    loadBalancer.addServer(server);

    verifyZeroInteractions(server);

    final Request request = new Request("test");
    for (int i = 0; i < loadBalancer.getNoOfServers() * 2; i++) {
      loadBalancer.serverRequest(request);
    }

    verify(server, times(2)).serve(request);
    verifyNoMoreInteractions(server);

  }

}

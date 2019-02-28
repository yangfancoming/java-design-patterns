
package com.iluwatar.intercepting.filter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

/**
 * Date: 12/13/15 - 3:01 PM
 *
 * @author Jeroen Meulemeester
 */
public class FilterManagerTest {

  @Test
  public void testFilterRequest() {
    final Target target = mock(Target.class);
    final FilterManager filterManager = new FilterManager();
    assertEquals("RUNNING...", filterManager.filterRequest(mock(Order.class)));
    verifyZeroInteractions(target);
  }

  @Test
  public void testAddFilter() {
    final Target target = mock(Target.class);
    final FilterManager filterManager = new FilterManager();

    verifyZeroInteractions(target);

    final Filter filter = mock(Filter.class);
    when(filter.execute(any(Order.class))).thenReturn("filter");

    filterManager.addFilter(filter);

    final Order order = mock(Order.class);
    assertEquals("filter", filterManager.filterRequest(order));

    verify(filter, times(1)).execute(any(Order.class));
    verifyZeroInteractions(target, filter, order);
  }
}
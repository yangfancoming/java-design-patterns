
package com.iluwatar.intercepting.filter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Date: 12/13/15 - 2:57 PM
 *
 * @author Jeroen Meulemeester
 */
public class OrderTest {

  private static final String EXPECTED_VALUE = "test";

  @Test
  public void testSetName() {
    final Order order = new Order();
    order.setName(EXPECTED_VALUE);
    assertEquals(EXPECTED_VALUE, order.getName());
  }

  @Test
  public void testSetContactNumber() {
    final Order order = new Order();
    order.setContactNumber(EXPECTED_VALUE);
    assertEquals(EXPECTED_VALUE, order.getContactNumber());
  }

  @Test
  public void testSetAddress() {
    final Order order = new Order();
    order.setAddress(EXPECTED_VALUE);
    assertEquals(EXPECTED_VALUE, order.getAddress());
  }

  @Test
  public void testSetDepositNumber() {
    final Order order = new Order();
    order.setDepositNumber(EXPECTED_VALUE);
    assertEquals(EXPECTED_VALUE, order.getDepositNumber());
  }

  @Test
  public void testSetOrder() {
    final Order order = new Order();
    order.setOrderItem(EXPECTED_VALUE);
    assertEquals(EXPECTED_VALUE, order.getOrderItem());
  }

}

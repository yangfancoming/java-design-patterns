
package com.iluwatar.price.microservice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for Price Rest Controller
 */
public class PriceControllerTest {
  @Test
  public void testgetPrice() {
    PriceController priceController = new PriceController();

    String price = priceController.getPrice();

    assertEquals("20", price);
  }
}

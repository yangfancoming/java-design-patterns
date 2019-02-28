
package com.iluwatar.image.microservice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for Image Rest Controller
 */
public class ImageControllerTest {
  @Test
  public void testGetImagePath() {
    ImageController imageController = new ImageController();

    String imagePath = imageController.getImagePath();

    assertEquals("/product-image.png", imagePath);
  }
}

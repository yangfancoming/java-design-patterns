
package com.iluwatar.api.gateway;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Test API Gateway Pattern
 */
public class ApiGatewayTest {

  @InjectMocks
  private ApiGateway apiGateway;

  @Mock
  private ImageClient imageClient;

  @Mock
  private PriceClient priceClient;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  /**
   * Tests getting the data for a desktop client
   */
  @Test
  public void testGetProductDesktop() {
    String imagePath = "/product-image.png";
    String price = "20";
    when(imageClient.getImagePath()).thenReturn(imagePath);
    when(priceClient.getPrice()).thenReturn(price);

    DesktopProduct desktopProduct = apiGateway.getProductDesktop();

    assertEquals(price, desktopProduct.getPrice());
    assertEquals(imagePath, desktopProduct.getImagePath());
  }

  /**
   * Tests getting the data for a mobile client
   */
  @Test
  public void testGetProductMobile() {
    String price = "20";
    when(priceClient.getPrice()).thenReturn(price);

    MobileProduct mobileProduct = apiGateway.getProductMobile();

    assertEquals(price, mobileProduct.getPrice());
  }
}

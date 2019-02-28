
package com.iluwatar.layers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * View implementation for displaying cakes
 *
 */
public class CakeViewImpl implements View {

  private static final Logger LOGGER = LoggerFactory.getLogger(CakeViewImpl.class);

  private CakeBakingService cakeBakingService;

  public CakeViewImpl(CakeBakingService cakeBakingService) {
    this.cakeBakingService = cakeBakingService;
  }

  public void render() {
    cakeBakingService.getAllCakes().forEach(cake -> LOGGER.info(cake.toString()));
  }
}

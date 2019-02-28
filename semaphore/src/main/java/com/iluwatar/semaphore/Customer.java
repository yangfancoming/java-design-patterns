
package com.iluwatar.semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A Customer attempts to repeatedly take Fruit from the FruitShop by
 * taking Fruit from FruitBowl instances.
 */
public class Customer extends Thread {

  private static final Logger LOGGER = LoggerFactory.getLogger(Customer.class);

  /**
   * Name of the Customer.
   */
  private final String name;
  
  /**
   * The FruitShop he is using.
   */
  private final FruitShop fruitShop;
  
  /**
   * Their bowl of Fruit.
   */
  private final FruitBowl fruitBowl;
  
  /**
   * Customer constructor
   */
  public Customer(String name, FruitShop fruitShop) {
    this.name = name;
    this.fruitShop = fruitShop;
    this.fruitBowl = new FruitBowl();
  }
  
  /**
   * The Customer repeatedly takes Fruit from the FruitShop until no Fruit
   * remains.
   */   
  public void run() {
        
    while (fruitShop.countFruit() > 0) {
      FruitBowl bowl = fruitShop.takeBowl();
      Fruit fruit;
            
      if (bowl != null && (fruit = bowl.take()) != null) {
        LOGGER.info("{} took an {}", name, fruit);
        fruitBowl.put(fruit);
        fruitShop.returnBowl(bowl);
      }
    }

    LOGGER.info("{} took {}", name, fruitBowl);
        
  }
    
}

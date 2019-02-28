
package com.iluwatar.hexagonal.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 
 * Unit tests for {@link LotteryNumbers}
 *
 */
class LotteryNumbersTest {
  
  @Test
  void testGivenNumbers() {
    LotteryNumbers numbers = LotteryNumbers.create(
            new HashSet<>(Arrays.asList(1, 2, 3, 4)));
    assertEquals(numbers.getNumbers().size(), 4);
    assertTrue(numbers.getNumbers().contains(1));
    assertTrue(numbers.getNumbers().contains(2));
    assertTrue(numbers.getNumbers().contains(3));
    assertTrue(numbers.getNumbers().contains(4));
  }
  
  @Test
  void testNumbersCantBeModified() {
    LotteryNumbers numbers = LotteryNumbers.create(
            new HashSet<>(Arrays.asList(1, 2, 3, 4)));
    assertThrows(UnsupportedOperationException.class, () -> numbers.getNumbers().add(5));
  }
  
  @Test
  void testRandomNumbers() {
    LotteryNumbers numbers = LotteryNumbers.createRandom();
    assertEquals(numbers.getNumbers().size(), LotteryNumbers.NUM_NUMBERS);
  }
  
  @Test
  void testEquals() {
    LotteryNumbers numbers1 = LotteryNumbers.create(
            new HashSet<>(Arrays.asList(1, 2, 3, 4)));
    LotteryNumbers numbers2 = LotteryNumbers.create(
            new HashSet<>(Arrays.asList(1, 2, 3, 4)));
    assertEquals(numbers1, numbers2);
    LotteryNumbers numbers3 = LotteryNumbers.create(
            new HashSet<>(Arrays.asList(11, 12, 13, 14)));
    assertNotEquals(numbers1, numbers3);
  }
}

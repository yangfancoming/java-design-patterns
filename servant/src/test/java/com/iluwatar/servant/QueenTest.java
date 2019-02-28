
package com.iluwatar.servant;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Date: 12/28/15 - 9:52 PM
 *
 * @author Jeroen Meulemeester
 */
public class QueenTest {

  @Test
  public void testNotFlirtyUncomplemented() {
    final Queen queen = new Queen();
    queen.setFlirtiness(false);
    queen.changeMood();
    assertFalse(queen.getMood());
  }
  
  @Test
  public void testNotFlirtyComplemented() {
    final Queen queen = new Queen();
    queen.setFlirtiness(false);
    queen.receiveCompliments();
    queen.changeMood();
    assertFalse(queen.getMood());
  }
  
  @Test
  public void testFlirtyUncomplemented() {
    final Queen queen = new Queen();
    queen.changeMood();
    assertFalse(queen.getMood());
  }
  
  @Test
  public void testFlirtyComplemented() {
    final Queen queen = new Queen();
    queen.receiveCompliments();
    queen.changeMood();
    assertTrue(queen.getMood());
  }
  
}

package com.iluwatar.nullobject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * Date: 12/26/15 - 11:47 PM
 *
 * @author Jeroen Meulemeester
 */
public class NullNodeTest {

  /**
   * Verify if {@link NullNode#getInstance()} actually returns the same object instance
   */
  @Test
  public void testGetInstance() {
    final NullNode instance = NullNode.getInstance();
    assertNotNull(instance);
    assertSame(instance, NullNode.getInstance());
  }

  @Test
  public void testFields() {
    final NullNode node = NullNode.getInstance();
    assertEquals(0, node.getTreeSize());
    assertNull(node.getName());
    assertNull(node.getLeft());
    assertNull(node.getRight());
  }

  @Test
  public void testWalk() {
    NullNode.getInstance().walk();
  }

}

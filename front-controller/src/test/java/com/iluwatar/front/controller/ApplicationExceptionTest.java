
package com.iluwatar.front.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * Date: 12/13/15 - 1:35 PM
 *
 * @author Jeroen Meulemeester
 */
public class ApplicationExceptionTest {

  @Test
  public void testCause() {
    final Exception cause = new Exception();
    assertSame(cause, new ApplicationException(cause).getCause());
  }

}
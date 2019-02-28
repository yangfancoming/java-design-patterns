
package com.iluwatar.callback;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Add a field as a counter. Every time the callback method is called increment this field. Unit
 * test checks that the field is being incremented.
 *
 * Could be done with mock objects as well where the call method call is verified.
 */
public class CallbackTest {

  private Integer callingCount = 0;

  @Test
  public void test() {
    Callback callback = () -> callingCount++;

    Task task = new SimpleTask();

    assertEquals(new Integer(0), callingCount, "Initial calling count of 0");

    task.executeWith(callback);

    assertEquals(new Integer(1), callingCount, "Callback called once");

    task.executeWith(callback);

    assertEquals(new Integer(2), callingCount, "Callback called twice");

  }
}

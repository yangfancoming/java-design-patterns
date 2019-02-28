
package com.iluwatar.eda.event;

import com.iluwatar.eda.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * {@link UserCreatedEventTest} tests and verifies {@link AbstractEvent} behaviour.
 */
public class UserCreatedEventTest {

  /**
   * This unit test should correctly return the {@link AbstractEvent} class type when calling the
   * {@link AbstractEvent#getType() getType} method.
   */
  @Test
  public void testGetEventType() {
    User user = new User("iluwatar");
    UserCreatedEvent userCreatedEvent = new UserCreatedEvent(user);
    assertEquals(UserCreatedEvent.class, userCreatedEvent.getType());
  }
}

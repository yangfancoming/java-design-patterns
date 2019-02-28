
package com.iluwatar.eda.framework;

import com.iluwatar.eda.event.UserCreatedEvent;
import com.iluwatar.eda.event.UserUpdatedEvent;
import com.iluwatar.eda.handler.UserCreatedEventHandler;
import com.iluwatar.eda.handler.UserUpdatedEventHandler;
import com.iluwatar.eda.model.User;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

/**
 * Event Dispatcher unit tests to assert and verify correct event dispatcher behaviour
 */
public class EventDispatcherTest {

  /**
   * This unit test should register events and event handlers correctly with the event dispatcher
   * and events should be dispatched accordingly.
   */
  @Test
  public void testEventDriverPattern() {

    EventDispatcher dispatcher = spy(new EventDispatcher());
    UserCreatedEventHandler userCreatedEventHandler = spy(new UserCreatedEventHandler());
    UserUpdatedEventHandler userUpdatedEventHandler = spy(new UserUpdatedEventHandler());
    dispatcher.registerHandler(UserCreatedEvent.class, userCreatedEventHandler);
    dispatcher.registerHandler(UserUpdatedEvent.class, userUpdatedEventHandler);

    User user = new User("iluwatar");

    UserCreatedEvent userCreatedEvent = new UserCreatedEvent(user);
    UserUpdatedEvent userUpdatedEvent = new UserUpdatedEvent(user);

    //fire a userCreatedEvent and verify that userCreatedEventHandler has been invoked.
    dispatcher.dispatch(userCreatedEvent);
    verify(userCreatedEventHandler).onEvent(userCreatedEvent);
    verify(dispatcher).dispatch(userCreatedEvent);

    //fire a userCreatedEvent and verify that userUpdatedEventHandler has been invoked.
    dispatcher.dispatch(userUpdatedEvent);
    verify(userUpdatedEventHandler).onEvent(userUpdatedEvent);
    verify(dispatcher).dispatch(userUpdatedEvent);
  }

}


package com.iluwatar.front.controller;

import com.iluwatar.front.controller.utils.InMemoryAppender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Date: 12/13/15 - 1:39 PM
 *
 * @author Jeroen Meulemeester
 */
public class FrontControllerTest {

  private InMemoryAppender appender;

  @BeforeEach
  public void setUp() {
    appender = new InMemoryAppender();
  }

  @AfterEach
  public void tearDown() {
    appender.stop();
  }

  static List<Object[]> dataProvider() {
    final List<Object[]> parameters = new ArrayList<>();
    parameters.add(new Object[]{new ArcherCommand(), "Displaying archers"});
    parameters.add(new Object[]{new CatapultCommand(), "Displaying catapults"});
    parameters.add(new Object[]{new UnknownCommand(), "Error 500"});
    return parameters;
  }

  /**
   * @param command        The command that's been tested
   * @param displayMessage The expected display message
   */
  @ParameterizedTest
  @MethodSource("dataProvider")
  public void testDisplay(Command command, String displayMessage) {
    assertEquals(0, appender.getLogSize());
    command.process();
    assertEquals(displayMessage, appender.getLastMessage());
    assertEquals(1, appender.getLogSize());
  }

}

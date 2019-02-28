
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
public class ViewTest {

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
    parameters.add(new Object[]{new ArcherView(), "Displaying archers"});
    parameters.add(new Object[]{new CatapultView(), "Displaying catapults"});
    parameters.add(new Object[]{new ErrorView(), "Error 500"});
    return parameters;
  }

  /**
   * @param view           The view that's been tested
   * @param displayMessage The expected display message
   */
  @ParameterizedTest
  @MethodSource("dataProvider")
  public void testDisplay(View view, String displayMessage) {
    assertEquals(0, appender.getLogSize());
    view.display();
    assertEquals(displayMessage, appender.getLastMessage());
    assertEquals(1, appender.getLogSize());
  }

}


package com.iluwatar.visitor;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Date: 12/30/15 - 18:59 PM
 * Test case for Visitor Pattern
 * @param <V> Type of UnitVisitor
 * @author Jeroen Meulemeester
 */
public abstract class VisitorTest<V extends UnitVisitor> {

  private InMemoryAppender appender;

  @BeforeEach
  public void setUp() {
    appender = new InMemoryAppender();
  }

  @AfterEach
  public void tearDown() {
    appender.stop();
  }

  /**
   * The tested visitor instance
   */
  private final V visitor;

  /**
   * The optional expected response when being visited by a commander
   */
  private final Optional<String> commanderResponse;

  /**
   * The optional expected response when being visited by a sergeant
   */
  private final Optional<String> sergeantResponse;

  /**
   * The optional expected response when being visited by a soldier
   */
  private final Optional<String> soldierResponse;

  /**
   * Create a new test instance for the given visitor
   *
   * @param commanderResponse The optional expected response when being visited by a commander
   * @param sergeantResponse  The optional expected response when being visited by a sergeant
   * @param soldierResponse   The optional expected response when being visited by a soldier
   */
  public VisitorTest(final V visitor, final Optional<String> commanderResponse,
                     final Optional<String> sergeantResponse, final Optional<String> soldierResponse) {

    this.visitor = visitor;
    this.commanderResponse = commanderResponse;
    this.sergeantResponse = sergeantResponse;
    this.soldierResponse = soldierResponse;
  }

  @Test
  public void testVisitCommander() {
    this.visitor.visitCommander(new Commander());
    if (this.commanderResponse.isPresent()) {
      assertEquals(this.commanderResponse.get(), appender.getLastMessage());
      assertEquals(1, appender.getLogSize());
    }
  }

  @Test
  public void testVisitSergeant() {
    this.visitor.visitSergeant(new Sergeant());
    if (this.sergeantResponse.isPresent()) {
      assertEquals(this.sergeantResponse.get(), appender.getLastMessage());
      assertEquals(1, appender.getLogSize());
    }
  }

  @Test
  public void testVisitSoldier() {
    this.visitor.visitSoldier(new Soldier());
    if (this.soldierResponse.isPresent()) {
      assertEquals(this.soldierResponse.get(), appender.getLastMessage());
      assertEquals(1, appender.getLogSize());
    }
  }

  private class InMemoryAppender extends AppenderBase<ILoggingEvent> {
    private List<ILoggingEvent> log = new LinkedList<>();

    public InMemoryAppender() {
      ((Logger) LoggerFactory.getLogger("root")).addAppender(this);
      start();
    }

    @Override
    protected void append(ILoggingEvent eventObject) {
      log.add(eventObject);
    }

    public int getLogSize() {
      return log.size();
    }

    public String getLastMessage() {
      return log.get(log.size() - 1).getFormattedMessage();
    }
  }
}


package com.iluwatar.front.controller.utils;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * InMemory Log Appender Util.
 */
public class InMemoryAppender extends AppenderBase<ILoggingEvent> {

  private List<ILoggingEvent> log = new LinkedList<>();

  public InMemoryAppender() {
    ((Logger) LoggerFactory.getLogger("root")).addAppender(this);
    start();
  }

  @Override
  protected void append(ILoggingEvent eventObject) {
    log.add(eventObject);
  }

  public String getLastMessage() {
    return log.get(log.size() - 1).getFormattedMessage();
  }

  public int getLogSize() {
    return log.size();
  }
}

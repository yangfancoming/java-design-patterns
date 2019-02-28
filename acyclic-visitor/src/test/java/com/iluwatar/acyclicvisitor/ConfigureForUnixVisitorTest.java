
package com.iluwatar.acyclicvisitor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;
import static uk.org.lidalia.slf4jext.Level.INFO;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import uk.org.lidalia.slf4jtest.TestLogger;
import uk.org.lidalia.slf4jtest.TestLoggerFactory;

/**
 * ConfigureForUnixVisitor test class
 */
public class ConfigureForUnixVisitorTest {
  
  private static final TestLogger LOGGER = TestLoggerFactory.getTestLogger(ConfigureForUnixVisitor.class);
  
  @AfterEach
  public void clearLoggers() {
    TestLoggerFactory.clear();
  }
  
  @Test
  public void testVisitForZoom() {
    ConfigureForUnixVisitor conUnix = new ConfigureForUnixVisitor();
    Zoom zoom = new Zoom();
    
    conUnix.visit(zoom);
    
    assertThat(LOGGER.getLoggingEvents()).extracting("level", "message").contains(
        tuple(INFO, zoom + " used with Unix configurator."));
  }
}

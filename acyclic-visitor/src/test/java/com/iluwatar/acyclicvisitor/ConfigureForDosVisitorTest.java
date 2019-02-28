
package com.iluwatar.acyclicvisitor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;
import static org.mockito.Mockito.mock;
import static uk.org.lidalia.slf4jext.Level.INFO;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.iluwatar.acyclicvisitor.ConfigureForDosVisitor;
import com.iluwatar.acyclicvisitor.Hayes;
import com.iluwatar.acyclicvisitor.HayesVisitor;
import com.iluwatar.acyclicvisitor.Zoom;
import com.iluwatar.acyclicvisitor.ZoomVisitor;

import uk.org.lidalia.slf4jtest.TestLogger;
import uk.org.lidalia.slf4jtest.TestLoggerFactory;

/**
 * ConfigureForDosVisitor test class
 */
public class ConfigureForDosVisitorTest {

  TestLogger logger = TestLoggerFactory.getTestLogger(ConfigureForDosVisitor.class);
  
  @Test
  public void testVisitForZoom() {    
    ConfigureForDosVisitor conDos = new ConfigureForDosVisitor();
    Zoom zoom = new Zoom();
    
    conDos.visit(zoom);
    
    assertThat(logger.getLoggingEvents()).extracting("level", "message").contains(
        tuple(INFO, zoom + " used with Dos configurator."));
  }
  
  @Test
  public void testVisitForHayes() {
    ConfigureForDosVisitor conDos = new ConfigureForDosVisitor();
    Hayes hayes = new Hayes();
    
    conDos.visit(hayes);
    
    assertThat(logger.getLoggingEvents()).extracting("level", "message").contains(
        tuple(INFO, hayes + " used with Dos configurator."));
  }
  
  @AfterEach
  public void clearLoggers() {
    TestLoggerFactory.clear();
  }
}

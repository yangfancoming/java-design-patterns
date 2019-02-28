
package com.iluwatar.acyclicvisitor;


import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import com.iluwatar.acyclicvisitor.ConfigureForDosVisitor;
import com.iluwatar.acyclicvisitor.ConfigureForUnixVisitor;
import com.iluwatar.acyclicvisitor.Zoom;
import com.iluwatar.acyclicvisitor.ZoomVisitor;

/**
 * Zoom test class
 */
public class ZoomTest {
  
  @Test
  public void testAcceptForDos() {  
    Zoom zoom = new Zoom();
    ConfigureForDosVisitor mockVisitor = mock(ConfigureForDosVisitor.class);
    
    zoom.accept(mockVisitor);
    verify((ZoomVisitor)mockVisitor).visit(eq(zoom));
  }
  
  @Test
  public void testAcceptForUnix() {
    Zoom zoom = new Zoom();
    ConfigureForUnixVisitor mockVisitor = mock(ConfigureForUnixVisitor.class);
    
    zoom.accept(mockVisitor);
    verify((ZoomVisitor)mockVisitor).visit(eq(zoom));
  }
}

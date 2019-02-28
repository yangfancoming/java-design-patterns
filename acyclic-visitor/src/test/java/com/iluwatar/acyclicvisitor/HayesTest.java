
package com.iluwatar.acyclicvisitor;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

import org.junit.jupiter.api.Test;

import com.iluwatar.acyclicvisitor.ConfigureForDosVisitor;
import com.iluwatar.acyclicvisitor.ConfigureForUnixVisitor;
import com.iluwatar.acyclicvisitor.Hayes;
import com.iluwatar.acyclicvisitor.HayesVisitor;

/**
 * Hayes test class
 */
public class HayesTest {

  @Test
  public void testAcceptForDos() {  
    Hayes hayes = new Hayes();
    ConfigureForDosVisitor mockVisitor = mock(ConfigureForDosVisitor.class);
    
    hayes.accept(mockVisitor);
    verify((HayesVisitor)mockVisitor).visit(eq(hayes));
  }
  
  @Test
  public void testAcceptForUnix() {    
    Hayes hayes = new Hayes();
    ConfigureForUnixVisitor mockVisitor = mock(ConfigureForUnixVisitor.class);
    
    hayes.accept(mockVisitor);
    
    verifyZeroInteractions(mockVisitor);
  }
}

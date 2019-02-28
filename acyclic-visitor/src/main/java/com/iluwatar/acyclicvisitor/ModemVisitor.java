
package com.iluwatar.acyclicvisitor;

/**
 * ModemVisitor interface does not contain any visit methods so that it does not
 * depend on the visited hierarchy. Each derivative's visit method is declared in 
 * its own visitor interface
 */
public interface ModemVisitor {
  // Visitor is a degenerate base class for all visitors.
}

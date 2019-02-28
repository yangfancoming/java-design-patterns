
package com.iluwatar.callback;

/**
 * Template-method class for callback hook execution
 */
public abstract class Task {

  /**
   * Execute with callback
   */
  public final void executeWith(Callback callback) {
      execute();
      callback.call();
  }

  public abstract void execute();
}

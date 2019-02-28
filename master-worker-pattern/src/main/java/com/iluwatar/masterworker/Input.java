

package com.iluwatar.masterworker;

import java.util.ArrayList;

/**
 *The abstract Input class, having 1 public field which contains input data,
 *and abstract method divideData.
 * @param <T> T will be type of data.
 */

public abstract class Input<T> {
  
  public final T data;
  
  public Input(T data) {
    this.data = data;
  }
  
  public abstract ArrayList<Input> divideData(int num);
}

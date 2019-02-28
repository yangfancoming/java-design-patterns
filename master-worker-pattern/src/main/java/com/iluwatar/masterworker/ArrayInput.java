

package com.iluwatar.masterworker;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *Class ArrayInput extends abstract class {@link Input} and contains data
 *of type int[][].
 */

public class ArrayInput extends Input<int[][]> {

  public ArrayInput(int[][] data) {
    super(data);
  }
  
  static int[] makeDivisions(int[][] data, int num) {
    int initialDivision = data.length / num; //equally dividing
    int[] divisions = new int[num];
    Arrays.fill(divisions, initialDivision);
    if (initialDivision * num != data.length) {
      int extra = data.length - initialDivision * num;
      int l = 0;
      //equally dividing extra among all parts
      while (extra > 0) {
        divisions[l] = divisions[l] + 1;
        extra--;
        if (l == num - 1) {
          l = 0;
        } else {
          l++;
        }
      }
    }
    return divisions;
  }

  @Override
  public ArrayList<Input> divideData(int num) {
    if (this.data == null) {
      return null;
    } else {
      int[] divisions = makeDivisions(this.data, num);
      ArrayList<Input> result = new ArrayList<Input>(num);
      int rowsDone = 0; //number of rows divided so far
      for (int i = 0; i < num; i++) {
        int rows = divisions[i];
        if (rows != 0) {
          int[][] divided = new int[rows][this.data[0].length];
          for (int j = 0; j < rows; j++) {
            divided[j] = this.data[rowsDone + j];
          }
          rowsDone += rows;
          ArrayInput dividedInput = new ArrayInput(divided);
          result.add(dividedInput);
        } else {
          break; //rest of divisions will also be 0
        }
      }
      return result;
    }    
  } 
}

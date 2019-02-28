

package com.iluwatar.masterworker.system;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.iluwatar.masterworker.ArrayUtilityMethods;
import com.iluwatar.masterworker.ArrayInput;
import com.iluwatar.masterworker.ArrayResult;

/**
* Testing getResult method in {@link ArrayTransposeMasterWorker} class.
*/

class ArrayTransposeMasterWorkerTest {

  @Test
  void getResultTest() {
    ArrayTransposeMasterWorker atmw = new ArrayTransposeMasterWorker();
    int[][] matrix = new int[][] {{1,2,3,4,5}, {1,2,3,4,5}, {1,2,3,4,5}, {1,2,3,4,5}, {1,2,3,4,5}};
    int[][] matrixTranspose = new int[][] {{1,1,1,1,1}, {2,2,2,2,2}, {3,3,3,3,3}, {4,4,4,4,4}, {5,5,5,5,5}};
    ArrayInput i = new ArrayInput(matrix);
    ArrayResult r = (ArrayResult) atmw.getResult(i);
    assertTrue(ArrayUtilityMethods.matricesSame(r.data, matrixTranspose));
  } 
}

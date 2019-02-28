

package com.iluwatar.masterworker.system.systemworkers;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.iluwatar.masterworker.ArrayUtilityMethods;
import com.iluwatar.masterworker.ArrayInput;
import com.iluwatar.masterworker.ArrayResult;
import com.iluwatar.masterworker.system.systemmaster.ArrayTransposeMaster;

/**
* Testing executeOperation method in {@link ArrayTransposeWorker} class.
*/

class ArrayTransposeWorkerTest {

  @Test
  void executeOperationTest() {
    ArrayTransposeMaster atm = new ArrayTransposeMaster(1);
    ArrayTransposeWorker atw = new ArrayTransposeWorker(atm, 1);
    int[][] matrix = new int[][] {{2,4}, {3,5}};
    int[][] matrixTranspose = new int[][] {{2,3}, {4,5}};
    ArrayInput i = new ArrayInput(matrix);
    atw.setReceivedData(atm, i);
    ArrayResult r = atw.executeOperation();
    assertTrue(ArrayUtilityMethods.matricesSame(r.data, matrixTranspose));
  }
  
}

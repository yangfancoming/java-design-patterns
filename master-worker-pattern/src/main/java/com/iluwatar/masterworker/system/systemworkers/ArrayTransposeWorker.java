

package com.iluwatar.masterworker.system.systemworkers;

import com.iluwatar.masterworker.ArrayInput;
import com.iluwatar.masterworker.ArrayResult;
import com.iluwatar.masterworker.system.systemmaster.Master;

/**
 *Class ArrayTransposeWorker extends abstract class {@link Worker} and defines method
 *executeOperation(), to be performed on data received from master.
 */

public class ArrayTransposeWorker extends Worker {

  public ArrayTransposeWorker(Master master, int id) {
    super(master, id);
  }

  @Override
  ArrayResult executeOperation() {
    //number of rows in result matrix is equal to number of columns in input matrix and vice versa
    int[][] resultData = new int[((ArrayInput) this.getReceivedData()).data[0].length]
      [((ArrayInput) this.getReceivedData()).data.length];
    for (int i = 0; i < ((ArrayInput) this.getReceivedData()).data.length; i++) {
      for (int j = 0; j < ((ArrayInput) this.getReceivedData()).data[0].length; j++) {
        //flipping element positions along diagonal
        resultData[j][i] = ((ArrayInput) this.getReceivedData()).data[i][j]; 
      }
    }
    return new ArrayResult(resultData);
  }
}

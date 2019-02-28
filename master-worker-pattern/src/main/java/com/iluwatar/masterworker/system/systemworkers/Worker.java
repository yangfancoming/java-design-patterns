

package com.iluwatar.masterworker.system.systemworkers;

import com.iluwatar.masterworker.Input;
import com.iluwatar.masterworker.Result;
import com.iluwatar.masterworker.system.systemmaster.Master;

/**
 *The abstract Worker class which extends Thread class to enable parallel
 *processing. Contains fields master(holding reference to master), workerId
 *(unique id) and receivedData(from master).
 */

public abstract class Worker extends Thread {
  private final Master master;
  private final int workerId;
  private Input receivedData;

  Worker(Master master, int id) {
    this.master = master;
    this.workerId = id;
    this.receivedData = null;
  }

  public int getWorkerId() {
    return this.workerId;
  }

  Input getReceivedData() {
    return this.receivedData;
  }

  public void setReceivedData(Master m, Input i) {
    //check if ready to receive..if yes:
    this.receivedData = i;
  }

  abstract Result executeOperation();

  private void sendToMaster(Result data) {
    this.master.receiveData(data, this);
  } 

  public void run() { //from Thread class
    Result work = executeOperation();
    sendToMaster(work);
  }
}

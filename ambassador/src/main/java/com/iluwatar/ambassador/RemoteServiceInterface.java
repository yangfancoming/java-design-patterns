
package com.iluwatar.ambassador;

/**
 * Interface shared by ({@link RemoteService}) and ({@link ServiceAmbassador}).
 */
interface RemoteServiceInterface {
  int FAILURE = -1;

  long doRemoteFunction(int value) throws Exception;
}

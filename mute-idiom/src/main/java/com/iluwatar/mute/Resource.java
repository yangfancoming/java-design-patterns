

package com.iluwatar.mute;

import java.io.Closeable;

/**
 * Represents any resource that the application might acquire and that must be closed
 * after it is utilized. Example of such resources can be a database connection, open
 * files, sockets. 
 */
public interface Resource extends Closeable {

}

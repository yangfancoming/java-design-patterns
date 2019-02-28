
package com.iluwatar.execute.around;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * SimpleFileWriter handles opening and closing file for the user. The user only has to specify what
 * to do with the file resource through {@link FileWriterAction} parameter.
 *
 */
public class SimpleFileWriter {

  /**
   * Constructor
   */
  public SimpleFileWriter(String filename, FileWriterAction action) throws IOException {
    try (FileWriter writer = new FileWriter(filename)) {
      action.writeFile(writer);
    }
  }
}

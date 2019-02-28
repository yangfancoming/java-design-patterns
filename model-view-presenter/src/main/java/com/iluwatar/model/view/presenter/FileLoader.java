
package com.iluwatar.model.view.presenter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Every instance of this class represents the Model component in the Model-View-Presenter
 * architectural pattern.
 * <p>
 * It is responsible for reading and loading the contents of a given file.
 */
public class FileLoader implements Serializable {

  /**
   * Generated serial version UID
   */
  private static final long serialVersionUID = -4745803872902019069L;
  
  private static final Logger LOGGER = LoggerFactory.getLogger(FileLoader.class);

  /**
   * Indicates if the file is loaded or not.
   */
  private boolean loaded;

  /**
   * The name of the file that we want to load.
   */
  private String fileName;

  /**
   * Loads the data of the file specified.
   */
  public String loadData() {
    String dataFileName = this.fileName;
    try (BufferedReader br = new BufferedReader(new FileReader(new File(dataFileName)))) {
      StringBuilder sb = new StringBuilder();
      String line;

      while ((line = br.readLine()) != null) {
        sb.append(line).append('\n');
      }

      this.loaded = true;

      return sb.toString();
    } catch (Exception e) {
      LOGGER.error("File {} does not exist", dataFileName);
    }

    return null;
  }

  /**
   * Sets the path of the file to be loaded, to the given value.
   * 
   * @param fileName The path of the file to be loaded.
   */
  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  /**
   * @return fileName The path of the file to be loaded.
   */
  public String getFileName() {
    return this.fileName;
  }

  /**
   * @return True, if the file given exists, false otherwise.
   */
  public boolean fileExists() {
    return new File(this.fileName).exists();
  }

  /**
   * @return True, if the file is loaded, false otherwise.
   */
  public boolean isLoaded() {
    return this.loaded;
  }
}

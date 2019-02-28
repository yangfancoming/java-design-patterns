
package com.iluwatar.model.view.presenter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Date: 12/21/15 - 12:12 PM
 *
 * @author Jeroen Meulemeester
 */
public class FileLoaderTest {

  @Test
  public void testLoadData() throws Exception {
    final FileLoader fileLoader = new FileLoader();
    fileLoader.setFileName("non-existing-file");
    assertNull(fileLoader.loadData());
  }

}
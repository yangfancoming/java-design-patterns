
package com.iluwatar.execute.around;

import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Date: 12/12/15 - 3:21 PM
 *
 * @author Jeroen Meulemeester
 */
@EnableRuleMigrationSupport
public class SimpleFileWriterTest {

  @Rule
  public final TemporaryFolder testFolder = new TemporaryFolder();

  @Test
  public void testWriterNotNull() throws Exception {
    final File temporaryFile = this.testFolder.newFile();
    new SimpleFileWriter(temporaryFile.getPath(), Assertions::assertNotNull);
  }

  @Test
  public void testCreatesNonExistentFile() throws Exception {
    final File nonExistingFile = new File(this.testFolder.getRoot(), "non-existing-file");
    assertFalse(nonExistingFile.exists());

    new SimpleFileWriter(nonExistingFile.getPath(), Assertions::assertNotNull);
    assertTrue(nonExistingFile.exists());
  }

  @Test
  public void testContentsAreWrittenToFile() throws Exception {
    final String testMessage = "Test message";

    final File temporaryFile = this.testFolder.newFile();
    assertTrue(temporaryFile.exists());

    new SimpleFileWriter(temporaryFile.getPath(), writer -> writer.write(testMessage));
    assertTrue(Files.lines(temporaryFile.toPath()).allMatch(testMessage::equals));
  }

  @Test
  public void testRipplesIoExceptionOccurredWhileWriting() {
    String message = "Some error";
    assertThrows(IOException.class, () -> {
      final File temporaryFile = this.testFolder.newFile();
      new SimpleFileWriter(temporaryFile.getPath(), writer -> {
        throw new IOException(message);
      });
    }, message);
  }

}

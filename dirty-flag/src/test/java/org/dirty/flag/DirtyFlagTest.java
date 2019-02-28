
package org.dirty.flag;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.iluwatar.dirtyflag.DataFetcher;

/**
 *
 * Application test
 *
 */
public class DirtyFlagTest {

  @Test
  public void testIsDirty() {
    DataFetcher df = new DataFetcher();
    List<String> countries = df.fetch();
    assertFalse(countries.isEmpty());
  }

  @Test
  public void testIsNotDirty() {
    DataFetcher df = new DataFetcher();
    df.fetch();
    List<String> countries = df.fetch();
    assertTrue(countries.isEmpty());
  }
}

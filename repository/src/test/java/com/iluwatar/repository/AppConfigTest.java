
package com.iluwatar.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * This case is Just for test the Annotation Based configuration
 * 
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { AppConfig.class }, loader = AnnotationConfigContextLoader.class)
public class AppConfigTest {

  @Autowired
  DataSource dataSource;

  /**
   * Test for bean instance
   */
  @Test
  public void testDataSource() {
    assertNotNull(dataSource);
  }

  /**
   * Test for correct query execution
   */
  @Test
  @Transactional
  public void testQuery() throws SQLException {
    ResultSet resultSet = dataSource.getConnection().createStatement().executeQuery("SELECT 1");
    String result = null;
    String expected = "1";
    while (resultSet.next()) {
      result = resultSet.getString(1);

    }
    assertEquals(expected, result);
  }

}

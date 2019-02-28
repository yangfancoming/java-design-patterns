
package com.iluwatar.servicelayer.app;

import com.iluwatar.servicelayer.hibernate.HibernateUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * Application test
 *
 */
public class AppTest {

  @Test
  public void test() {
    String[] args = {};
    App.main(args);
  }

  @AfterEach
  public void tearDown() {
    HibernateUtil.dropSession();
  }

}

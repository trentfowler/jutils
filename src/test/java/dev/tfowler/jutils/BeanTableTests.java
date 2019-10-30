package dev.tfowler.jutils;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Collections;

public class BeanTableTests {
  private static Logger LOGGER = LoggerFactory.getLogger(BeanTableTests.class);

  @Test
  public void testRenderNullTable() {
    String ascii = BeanTable.asciiRender(null);
    LOGGER.info(ascii);
  }

  @Test
  public void testRenderEmptyTable() {
    String ascii = BeanTable.asciiRender(Collections.emptyList());
    LOGGER.info(ascii);
  }
}

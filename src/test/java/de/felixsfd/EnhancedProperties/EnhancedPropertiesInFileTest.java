package de.felixsfd.EnhancedProperties;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class EnhancedPropertiesInFileTest extends EnhancedPropertiesTest {
  private static final String PATH = "src/test/resources/test.properties";

  @Before
  public void initProperties() throws IOException {
    testProperties = new EnhancedPropertiesInFile(PATH) {};
  }


  @Override
  @Test
  public void getString() {
    super.getString();
  }


  @Override
  @Test
  public void getShort() {
    super.getShort();
  }


  @Override
  @Test
  public void getInt() {
    super.getInt();
  }


  @Override
  @Test
  public void getLong() {
    super.getLong();
  }


  @Override
  @Test
  public void getFloat() {
    super.getFloat();
  }


  @Override
  @Test
  public void getDouble() {
    super.getDouble();
  }


  @Test
  public void getPath() {
    String path = ((EnhancedPropertiesInFile)testProperties).getPath();
    Assert.assertEquals(PATH, path);
  }
}

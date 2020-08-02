package de.felixsfd.EnhancedProperties;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class EnhancedPropertiesInResourcesTest extends EnhancedPropertiesTest {
  private static final String PATH = "test.properties";

  @Before
  public void initProperties() throws IOException {
    testProperties = new EnhancedPropertiesInResources(PATH) {};
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
    String path = ((EnhancedPropertiesInResources)testProperties).getResourcesPath();
    Assert.assertEquals(PATH, path);
  }
}

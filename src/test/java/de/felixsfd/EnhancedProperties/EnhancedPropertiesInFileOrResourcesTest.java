package de.felixsfd.EnhancedProperties;

import de.felixsfd.EnhancedProperties.testProperties.TestPropertiesFileFirst;
import de.felixsfd.EnhancedProperties.testProperties.TestPropertiesResourcesFirst;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class EnhancedPropertiesInFileOrResourcesTest {
  public static final String FILE_PATH = "src/test/resources/test.properties";
  public static final String RESOURCES_PATH = "test2.properties";


  @Test
  public void getStringFileFirst() throws IOException {
    TestPropertiesFileFirst properties = new TestPropertiesFileFirst();

    String hello = properties.getString("hello");
    Assert.assertEquals("Hello, World!", hello);

    int integer = properties.getInt("integer");
    Assert.assertEquals(2344442, integer);

    integer = properties.getInt("integer_absent", 0);
    Assert.assertEquals(0, integer);
  }


  @Test
  public void getStringResourcesFirst() throws IOException {
    TestPropertiesResourcesFirst properties = new TestPropertiesResourcesFirst();

    String hello = properties.getString("hello");
    Assert.assertEquals("Bye!", hello);

    int integer = properties.getInt("integer");
    Assert.assertEquals(-1337, integer);

    integer = properties.getInt("integer_absent", 0);
    Assert.assertEquals(0, integer);
  }
}
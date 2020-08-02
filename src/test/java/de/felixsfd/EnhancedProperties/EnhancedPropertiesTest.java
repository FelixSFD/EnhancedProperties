package de.felixsfd.EnhancedProperties;

import org.junit.Assert;

import java.io.IOException;

import static org.junit.Assert.*;

public class EnhancedPropertiesTest {
  public EnhancedProperties testProperties = null;

  public void getString() {
    String value = testProperties.getString("hello");
    Assert.assertEquals("Wrong value for key 'hello'!", "Hello, World!", value);

    value = testProperties.getString("absent");
    Assert.assertNull(value);

    value = testProperties.getString("absent", "default");
    Assert.assertEquals("Wrong defaultValue for key 'absent'!", "default", value);
  }


  public void getShort() {
    short value = testProperties.getShort("short");
    Assert.assertEquals("Wrong value for key 'short'", (short)128, value);

    value = testProperties.getShort("absent", (short)1);
    Assert.assertEquals("Wrong defaultValue for key 'absent'", (short)1, value);

    value = testProperties.getShort("double", (short)1);
    Assert.assertEquals("Wrong defaultValue for key 'double'", (short)1, value);

    value = testProperties.getShort("hello", (short)1);
    Assert.assertEquals("Wrong defaultValue for key 'hello'", (short)1, value);
  }


  public void getInt() {
    int value = testProperties.getInt("short");
    Assert.assertEquals("Wrong value for key 'short'", 128, value);

    value = testProperties.getInt("integer");
    Assert.assertEquals("Wrong value for key 'integer'", 2344442, value);

    value = testProperties.getInt("absent", 1337);
    Assert.assertEquals("Wrong defaultValue for key 'absent'", 1337, value);

    value = testProperties.getInt("double", 1337);
    Assert.assertEquals("Wrong defaultValue for key 'double'", 1337, value);

    value = testProperties.getInt("hello", 1337);
    Assert.assertEquals("Wrong defaultValue for key 'hello'", 1337, value);
  }


  public void getLong() {
    long value = testProperties.getLong("short");
    Assert.assertEquals("Wrong value for key 'short'", 128, value);

    value = testProperties.getLong("long");
    Assert.assertEquals("Wrong value for key 'long'", 111992929299999L, value);

    value = testProperties.getLong("absent", 1337L);
    Assert.assertEquals("Wrong defaultValue for key 'absent'", 1337L, value);

    value = testProperties.getLong("double", 1337L);
    Assert.assertEquals("Wrong defaultValue for key 'double'", 1337L, value);

    value = testProperties.getLong("hello", 1337L);
    Assert.assertEquals("Wrong defaultValue for key 'hello'", 1337L, value);
  }


  public void getFloat() {
    float value = testProperties.getFloat("float");
    Assert.assertEquals("Wrong value for key 'float'", 1.234, value, 0.000001);

    value = testProperties.getFloat("absent", 13.37f);
    Assert.assertEquals("Wrong defaultValue for key 'absent'", 13.37f, value, 0.000001);

    value = testProperties.getFloat("double", 13.37f);
    Assert.assertEquals("Wrong defaultValue for key 'double'", 13.37f, value, 0.000001);

    value = testProperties.getFloat("hello", 13.37f);
    Assert.assertEquals("Wrong defaultValue for key 'hello'", 13.37f, value, 0.000001);
  }


  public void getDouble() {
    double value = testProperties.getDouble("doubleValue");
    Assert.assertEquals("Wrong value for key 'doubleValue'", 14353.337998282777, value, 0.0000000000001);

    value = testProperties.getDouble("float");
    Assert.assertEquals("Wrong value for key 'float'", 1.234, value, 0.0000000000001);

    value = testProperties.getDouble("absent", 13.37f);
    Assert.assertEquals("Wrong defaultValue for key 'absent'", 13.37f, value, 0.0000000000001);

    value = testProperties.getDouble("double", 13.37f);
    Assert.assertEquals("Wrong defaultValue for key 'double'", 13.37f, value, 0.0000000000001);

    value = testProperties.getDouble("hello", 13.37f);
    Assert.assertEquals("Wrong defaultValue for key 'hello'", 13.37f, value, 0.0000000000001);
  }
}
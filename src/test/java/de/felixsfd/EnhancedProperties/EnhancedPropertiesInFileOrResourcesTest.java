/*
 * Copyright (c) 2020 FelixSFD
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package de.felixsfd.EnhancedProperties;

import de.felixsfd.EnhancedProperties.exceptions.EPSetPropertyException;
import de.felixsfd.EnhancedProperties.testProperties.TestPropertiesFileFirst;
import de.felixsfd.EnhancedProperties.testProperties.TestPropertiesResourcesFirst;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EnhancedPropertiesInFileOrResourcesTest extends EnhancedWriteablePropertiesTest {
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


  @Test
  public void setValues() throws EPSetPropertyException {
    try {
      writeableProperties = new TestPropertiesResourcesFirst();
    } catch (IOException e) {
      e.printStackTrace();
      Assert.fail();
    }
    super.setValues();
  }


  @Test
  public void fileInFileSystemDoesNotExist() throws IOException {
    System.out.println("Renaming test.properties, so the application will not find it");
    Files.move(Paths.get(FILE_PATH), Paths.get(FILE_PATH + ".gone"));

    try {
      writeableProperties = new TestPropertiesFileFirst();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      Assert.fail("The file was not found, but the @ReadRule is preferredLocation = FILE");
    } finally {
      System.out.println("Move file back");
      Files.move(Paths.get(FILE_PATH + ".gone"), Paths.get(FILE_PATH));
    }
  }


  @Test
  public void fileInFileSystemDoesNotExist2() throws IOException {
    System.out.println("Renaming test.properties, so the application will not find it");
    Files.move(Paths.get(FILE_PATH), Paths.get(FILE_PATH + ".gone"));

    try {
      writeableProperties = new TestPropertiesResourcesFirst();

      Assert.fail("No exception was thrown, although the @ReadRule is preferredLocation = RESOURCES" +
        " and the file in file-system does not exist.");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } finally {
      System.out.println("Move file back");
      Files.move(Paths.get(FILE_PATH + ".gone"), Paths.get(FILE_PATH));
    }
  }
}
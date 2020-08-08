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


  @Override
  @Test
  public void getBoolean() {
    super.getBoolean();
  }


  @Test
  public void getPath() {
    String path = ((EnhancedPropertiesInFile)testProperties).getPath();
    Assert.assertEquals(PATH, path);
  }
}

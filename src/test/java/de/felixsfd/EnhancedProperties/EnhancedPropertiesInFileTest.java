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

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EnhancedPropertiesInFileTest extends EnhancedWriteablePropertiesTest {
  private static final String PATH = "src/test/resources/test.properties";
  private static final String WRITE_PATH = "src/test/resources/test_written.properties";
  private static final String EXPECTED_PATH = "src/test/resources/test_expected.properties";

  @Before
  public void initProperties() throws IOException {
    testProperties = new EnhancedPropertiesInFile(PATH) {};
    writeableProperties = new EnhancedPropertiesInFile(PATH) {};

    System.out.println("Delete existing output file " + WRITE_PATH);
    Files.deleteIfExists(Paths.get(WRITE_PATH));
  }


  @After
  public void deleteWrittenFile() throws IOException {
    System.out.println("Delete existing output file " + WRITE_PATH);
    Files.deleteIfExists(Paths.get(WRITE_PATH));
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


  @Test
  public void testWriteable() throws IOException {
    super.setValues();
    super.writeTo(WRITE_PATH);

    File expectedOutputFile = new File(EXPECTED_PATH);
    File writtenFile = new File(WRITE_PATH);
    assertFileEqualsWithoutComments(expectedOutputFile, writtenFile);
  }


  private void assertFileEqualsWithoutComments(File expectedFile, File writtenFile) throws IOException {
    String expectedContent = FileUtils.readFileToString(expectedFile, Charset.defaultCharset());
    String writtenContent = FileUtils.readFileToString(writtenFile, Charset.defaultCharset());

    Pattern excludeCommentsPattern = Pattern.compile("^(#.*|)?$\\n", Pattern.MULTILINE);
    Matcher matcher1 = excludeCommentsPattern.matcher(expectedContent);
    Matcher matcher2 = excludeCommentsPattern.matcher(writtenContent);
    expectedContent = matcher1.replaceAll("");
    writtenContent = matcher2.replaceAll("");

    Assert.assertEquals("Written file differs from expected output", expectedContent, writtenContent);
  }
}

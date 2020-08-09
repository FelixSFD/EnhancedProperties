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

import java.io.IOException;

public class EnhancedWriteablePropertiesTest extends EnhancedPropertiesTest {
  public EnhancedWriteableProperties writeableProperties = null;

  public void setValues() {
    writeableProperties.setString("test", "value");
    writeableProperties.setBoolean("setBool", false);
    writeableProperties.setBoolean("setBool2", true);
    writeableProperties.setShort("setShort", (short)-123);
    writeableProperties.setInt("setInt", 1337);
    writeableProperties.setLong("setLong", 993489234822222L);
    writeableProperties.setFloat("setFloat", 13.37f);
    writeableProperties.setDouble("setDouble", 13.33333337);
  }


  public void writeTo(String path) throws IOException {
    writeableProperties.save(path);
  }
}

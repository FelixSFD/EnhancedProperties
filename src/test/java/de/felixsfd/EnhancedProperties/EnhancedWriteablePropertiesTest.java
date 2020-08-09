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
import de.felixsfd.EnhancedProperties.exceptions.EPTypeNotSupportedException;
import org.junit.Assert;

import java.io.IOException;
import java.util.ArrayList;

public class EnhancedWriteablePropertiesTest extends EnhancedPropertiesTest {
  public EnhancedWriteableProperties writeableProperties = null;

  private boolean listenerCalled = false;

  public void setValues() throws EPSetPropertyException {
    listenerCalled = false;
    writeableProperties.addChangedPropertyListener(changedPropertyEvent -> {
      System.out.println("Listener called for " + changedPropertyEvent.getKey() + ": "
        + changedPropertyEvent.getOriginalValue() + " => " + changedPropertyEvent.getNewValue());
      listenerCalled = true;
    });

    writeableProperties.setString("test", "value");
    Assert.assertTrue("Property change listener not called!", listenerCalled);
    listenerCalled = false;

    writeableProperties.setBoolean("setBool", false);
    Assert.assertTrue("Property change listener not called!", listenerCalled);
    listenerCalled = false;

    writeableProperties.setBoolean("setBool2", true);
    Assert.assertTrue("Property change listener not called!", listenerCalled);
    listenerCalled = false;

    writeableProperties.setShort("setShort", (short)-123);
    Assert.assertTrue("Property change listener not called!", listenerCalled);
    listenerCalled = false;

    writeableProperties.setInt("setInt", 1337);
    Assert.assertTrue("Property change listener not called!", listenerCalled);
    listenerCalled = false;

    writeableProperties.setLong("setLong", 993489234822222L);
    Assert.assertTrue("Property change listener not called!", listenerCalled);
    listenerCalled = false;

    writeableProperties.setFloat("setFloat", 13.37f);
    Assert.assertTrue("Property change listener not called!", listenerCalled);
    listenerCalled = false;

    writeableProperties.setDouble("setDouble", 13.33333337);
    Assert.assertTrue("Property change listener not called!", listenerCalled);
    listenerCalled = false;

    //Expect exception!
    if (writeableProperties instanceof EnhancedWriteablePropertiesImpl) {
      System.out.println("Testing unsupported type in EnhancedWriteablePropertiesImpl");
      try {
        EnhancedWriteablePropertiesImpl enhancedWriteableProperties = (EnhancedWriteablePropertiesImpl) writeableProperties;
        enhancedWriteableProperties.setValue("error", new ArrayList<String>());

        Assert.fail("EPTypeNotSupportedException not thrown!");
      } catch (EPTypeNotSupportedException e) {
        System.out.println("Exception thrown as expected:");
        System.out.println("Type: " + e.getType().getName());
        e.printStackTrace();
      }
    } else {
      System.out.println("Skipping test for unsupported types in setValue");
    }
  }


  public void writeTo(String path) throws IOException {
    writeableProperties.save(path);
  }
}

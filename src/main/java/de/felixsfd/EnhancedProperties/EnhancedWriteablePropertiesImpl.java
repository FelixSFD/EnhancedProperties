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

public abstract class EnhancedWriteablePropertiesImpl extends EnhancedPropertiesImpl implements EnhancedWriteableProperties {
  /**
   * Sets a given property.
   * <br>
   * Since the properties are always stored as strings, {@link String#valueOf(int)} )} will be used.
   *
   * @param key   Name of the property
   * @param value new Value
   */
  @Override
  public final void setShort(String key, short value) {
    setString(key, String.valueOf(value));
  }


  /**
   * Sets a given property.
   * <br>
   * Since the properties are always stored as strings, {@link String#valueOf(int)} will be used.
   *
   * @param key   Name of the property
   * @param value new Value
   */
  @Override
  public final void setInt(String key, int value) {
    setString(key, String.valueOf(value));
  }


  /**
   * Sets a given property.
   * <br>
   * Since the properties are always stored as strings, {@link String#valueOf(long)} will be used.
   *
   * @param key   Name of the property
   * @param value new Value
   */
  @Override
  public final void setLong(String key, long value) {
    setString(key, String.valueOf(value));
  }


  /**
   * Sets a given property.
   * <br>
   * Since the properties are always stored as strings, {@link String#valueOf(float)} will be used.
   *
   * @param key   Name of the property
   * @param value new Value
   */
  @Override
  public final void setFloat(String key, float value) {
    setString(key, String.valueOf(value));
  }


  /**
   * Sets a given property.
   * <br>
   * Since the properties are always stored as strings, {@link String#valueOf(double)} will be used.
   *
   * @param key   Name of the property
   * @param value new Value
   */
  @Override
  public final void setDouble(String key, double value) {
    setString(key, String.valueOf(value));
  }


  /**
   * Sets a given property.
   * <br>
   * Since the properties are always stored as strings, {@link String#valueOf(boolean)} will be used.
   *
   * @param key   Name of the property
   * @param value new Value
   */
  @Override
  public final void setBoolean(String key, boolean value) {
    setString(key, String.valueOf(value));
  }
}

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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

/**
 * Interface for a <b>writeable</b> properties-wrapper. Do not implement this interface.
 * <br>
 * Use one of these classes instead:
 * <ul>
 *   <li>{@link EnhancedPropertiesInFile}</li>
 *   <li>{@link EnhancedPropertiesInFileOrResources}</li>
 * </ul>
 *
 * @since 1.1.0
 */
public interface EnhancedWriteableProperties extends EnhancedProperties {
  /**
   * Sets a given property
   * @param key Name of the property
   * @param value new Value
   */
  void setString(@NotNull String key, @Nullable String value) throws EPSetPropertyException;

  /**
   * Sets a given property.
   * <br>
   * Since the properties are always stored as strings, {@link String#valueOf(int)} )} will be used.
   * @param key Name of the property
   * @param value new Value
   */
  void setShort(@NotNull String key, short value) throws EPSetPropertyException;

  /**
   * Sets a given property.
   * <br>
   * Since the properties are always stored as strings, {@link String#valueOf(int)} will be used.
   * @param key Name of the property
   * @param value new Value
   */
  void setInt(@NotNull String key, int value) throws EPSetPropertyException;

  /**
   * Sets a given property.
   * <br>
   * Since the properties are always stored as strings, {@link String#valueOf(long)} will be used.
   * @param key Name of the property
   * @param value new Value
   */
  void setLong(@NotNull String key, long value) throws EPSetPropertyException;

  /**
   * Sets a given property.
   * <br>
   * Since the properties are always stored as strings, {@link String#valueOf(float)} will be used.
   * @param key Name of the property
   * @param value new Value
   */
  void setFloat(@NotNull String key, float value) throws EPSetPropertyException;

  /**
   * Sets a given property.
   * <br>
   * Since the properties are always stored as strings, {@link String#valueOf(double)} will be used.
   * @param key Name of the property
   * @param value new Value
   */
  void setDouble(@NotNull String key, double value) throws EPSetPropertyException;

  /**
   * Sets a given property.
   * <br>
   * Since the properties are always stored as strings, {@link String#valueOf(boolean)} will be used.
   * @param key Name of the property
   * @param value new Value
   */
  void setBoolean(@NotNull String key, boolean value) throws EPSetPropertyException;

  /**
   * Writes the properties to the file
   */
  void save() throws IOException;

  /**
   * Writes the properties to a different file
   * @param filePath Path of the file to write
   */
  void save(@NotNull String filePath) throws IOException;

  @NotNull Iterable<ChangedPropertyListener> getChangedPropertyListeners();

  void addChangedPropertyListener(@NotNull ChangedPropertyListener changedPropertyListener);
}

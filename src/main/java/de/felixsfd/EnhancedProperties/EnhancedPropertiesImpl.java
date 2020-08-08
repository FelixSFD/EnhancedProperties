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

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * Abstract base class for the properties-wrapper. Do not implement this class.
 * <br>
 * Use one of these instead:
 * <ul>
 *   <li>{@link EnhancedPropertiesInFile}</li>
 *   <li>{@link EnhancedPropertiesInResources}</li>
 *   <li>{@link EnhancedPropertiesInFileOrResources}</li>
 * </ul>
 */
abstract class EnhancedPropertiesImpl implements EnhancedProperties {
  /**
   * Empty default constructor
   */
  protected EnhancedPropertiesImpl() {
  }


  /**
   * Returns the content of the key as short
   * <br>
   * Any exceptions while parsing will be thrown
   * @param key Key in the Properties-File
   * @return Values as Short
   */
  @Override
  public final short getShort(@NotNull String key) throws NumberFormatException, NullPointerException {
    String valueStr = getString(key);
    return Short.parseShort(Objects.requireNonNull(valueStr));
  } // getShort


  /**
   * Returns the content of the key as short
   * @param key Key in the Properties-File
   * @param defaultValue Value, if the Key is null or not a number
   * @return Values as Short
   */
  @Override
  public final short getShort(@NotNull String key, short defaultValue) {
    String valueStr = getString(key);

    if (valueStr == null) {
      return defaultValue;
    }

    try {
      return Short.parseShort(valueStr);
    } catch (NumberFormatException e) {
      return defaultValue;
    } // try-catch
  } // getShort


  /**
   * Returns the content of the key as int
   * <br>
   * Any exceptions while parsing will be thrown
   * @param key Key in the Properties-File
   * @return Values as Integer
   */
  @Override
  public final int getInt(@NotNull String key) throws NumberFormatException, NullPointerException {
    String valueStr = getString(key);
    return Integer.parseInt(Objects.requireNonNull(valueStr));
  } // getInt


  /**
   * Returns the content of the key as int
   * @param key Key in the Properties-File
   * @param defaultValue Value, if the Key is null or not a number
   * @return Values as Integer
   */
  @Override
  public final int getInt(@NotNull String key, int defaultValue) {
    String valueStr = getString(key);

    if (valueStr == null) {
      return defaultValue;
    }

    try {
      return Integer.parseInt(valueStr);
    } catch (NumberFormatException e) {
      return defaultValue;
    } // try-catch
  } // getInt


  /**
   * Returns the content of the key as long
   * <br>
   * Any exceptions while parsing will be thrown
   * @param key Key in the Properties-File
   * @return Values as Long
   */
  @Override
  public final long getLong(@NotNull String key) throws NumberFormatException, NullPointerException {
    String valueStr = getString(key);
    return Long.parseLong(Objects.requireNonNull(valueStr));
  } // getLong


  /**
   * Returns the content of the key as int
   * @param key Key in the Properties-File
   * @param defaultValue Value, if the Key is null or not a number
   * @return Values as Integer
   */
  @Override
  public final long getLong(@NotNull String key, long defaultValue) {
    String valueStr = getString(key);

    if (valueStr == null) {
      return defaultValue;
    }

    try {
      return Long.parseLong(valueStr);
    } catch (NumberFormatException e) {
      return defaultValue;
    } // try-catch
  } // getLong


  /**
   * Returns the content of the key as float
   * <br>
   * Any exceptions while parsing will be thrown
   * @param key Key in the Properties-File
   * @return Values as Float
   */
  @Override
  public final float getFloat(@NotNull String key) throws NumberFormatException, NullPointerException {
    String valueStr = getString(key);
    return Float.parseFloat(Objects.requireNonNull(valueStr));
  } // getFloat


  /**
   * Returns the content of the key as float
   * @param key Key in the Properties-File
   * @param defaultValue Value, if the Key is null or not a number
   * @return Values as Float
   */
  @Override
  public final float getFloat(@NotNull String key, float defaultValue) {
    String valueStr = getString(key);

    if (valueStr == null) {
      return defaultValue;
    }

    try {
      return Float.parseFloat(valueStr);
    } catch (NumberFormatException e) {
      return defaultValue;
    } // try-catch
  } // getFloat


  /**
   * Returns the content of the key as double
   * <br>
   * Any exceptions while parsing will be thrown
   * @param key Key in the Properties-File
   * @return Values as Double
   */
  @Override
  public final double getDouble(@NotNull String key) throws NumberFormatException, NullPointerException {
    String valueStr = getString(key);
    return Double.parseDouble(Objects.requireNonNull(valueStr));
  } // getDouble


  /**
   * Returns the content of the key as double
   * @param key Key in the Properties-File
   * @param defaultValue Value, if the Key is null or not a number
   * @return Values as Double
   */
  @Override
  public final double getDouble(@NotNull String key, double defaultValue) {
    String valueStr = getString(key);

    if (valueStr == null) {
      return defaultValue;
    }

    try {
      return Double.parseDouble(valueStr);
    } catch (NumberFormatException e) {
      return defaultValue;
    } // try-catch
  } // getDouble
} // EnhancedProperties

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

package de.felixsfd.EnhancedProperties.utils;

import org.jetbrains.annotations.NotNull;

/**
 * Various Utility functions for strings
 */
public class EPStringUtils {
  /**
   * Converts the first letter of a {@link String} to uppercase.
   * The rest of the string will not be affected.
   * <br>
   * Example:<br>
   * <code>
   *   "hello" -> "Hello"
   *
   *   "testString" -> "TestString"
   * </code>
   * @param input Input string
   * @return String with first letter as uppercase
   * @since 1.1.0
   */
  @NotNull
  public static String firstLetterUppercase(@NotNull String input) {
    return input.substring(0, 1).toUpperCase() + input.substring(1);
  }
}

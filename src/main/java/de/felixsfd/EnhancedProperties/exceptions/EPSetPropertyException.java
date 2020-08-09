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

package de.felixsfd.EnhancedProperties.exceptions;

import de.felixsfd.EnhancedProperties.EnhancedProperties;

/**
 * Exception for errors while setting a property in {@link de.felixsfd.EnhancedProperties.EnhancedWriteableProperties}
 *
 * @since 1.1.0
 */
public class EPSetPropertyException extends EnhancedPropertiesException {
  /**
   * Constructor with message, properties-instance and nested exception
   * @param properties Instance of the affected {@link EnhancedProperties}
   * @param message Message describing the error
   * @param exception nested exception if available
   */
  public EPSetPropertyException(EnhancedProperties properties, String message, Throwable exception) {
    super(properties, message, exception);
  }
}

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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


/**
 * Base class for exceptions thrown by EnhancedProperties
 * @since 1.1.0
 */
public class EnhancedPropertiesException extends Exception {
  /**
   * Instance of the affected {@link EnhancedProperties}
   */
  private final @Nullable EnhancedProperties properties;


  /**
   * Constructor with message, properties-instance and nested exception
   * @param properties Instance of the affected {@link EnhancedProperties}
   * @param message Message describing the error
   * @param exception nested exception if available
   */
  public EnhancedPropertiesException(@Nullable EnhancedProperties properties, @NotNull String message, @Nullable Throwable exception) {
    super(message, exception);
    this.properties = properties;
  }


  /**
   * Instance of the affected {@link EnhancedProperties}
   * @return instance
   */
  @Nullable
  public EnhancedProperties getProperties() {
    return properties;
  }
}

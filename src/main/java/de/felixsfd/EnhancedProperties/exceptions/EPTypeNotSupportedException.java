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
 * Exception that is thrown, if a datatype was used that is not compatible
 * with {@link EnhancedProperties} (yet).
 *
 * @since 1.1.0
 */
public class EPTypeNotSupportedException extends EnhancedPropertiesException {
  /**
   * Type that is not supported
   */
  private final @NotNull Class<?> type;


  /**
   * Constructor with instance of the {@link EnhancedProperties}, the requested type and nested exception.
   * @param properties Instance of the {@link EnhancedProperties}
   * @param type Type that is not supported
   * @param exception Nested exception is available
   */
  public EPTypeNotSupportedException(@Nullable EnhancedProperties properties, @NotNull Class<?> type, @Nullable Throwable exception) {
    super(properties, "The type " + type.getName() + " is not supported!", exception);
    this.type = type;
  }


  /**
   * Type that is not supported
   * @return Type
   */
  @NotNull
  public Class<?> getType() {
    return type;
  }
}

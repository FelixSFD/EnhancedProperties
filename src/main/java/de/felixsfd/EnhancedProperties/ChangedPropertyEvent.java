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
import org.jetbrains.annotations.Nullable;

/**
 * Contains information about a key in {@link EnhancedWriteableProperties}
 * that has been modified.
 *
 * @param <T> Type of the changed property
 *
 * @since 1.1.0
 */
public class ChangedPropertyEvent<T> {
  /**
   * Properties object that has been modified
   */
  private final @NotNull EnhancedWriteableProperties changedProperties;

  /**
   * Key that has been modified
   */
  private final @NotNull String key;

  /**
   * Value of the {@link #key} before the change
   */
  private final @Nullable T originalValue;

  /**
   * New value of the {@link #key}
   */
  private final @Nullable T newValue;

  public ChangedPropertyEvent(@NotNull EnhancedWriteableProperties changedProperties, @NotNull String key, @Nullable T originalValue, @Nullable T newValue) {
    this.changedProperties = changedProperties;
    this.key = key;

    this.originalValue = originalValue;
    this.newValue = newValue;
  }


  /**
   * Properties object that has been modified
   * @return Properties object that has been modified
   */
  @NotNull
  public EnhancedWriteableProperties getChangedProperties() {
    return changedProperties;
  }


  /**
   * Key that has been modified
   * @return Key that has been modified
   */
  @NotNull
  public String getKey() {
    return key;
  }


  /**
   * Value of the {@link #key} before the change
   * @return Value of the {@link #key} before the change
   */
  @Nullable
  public T getOriginalValue() {
    return originalValue;
  }


  /**
   * New value of the {@link #key}
   * @return New value of the {@link #key}
   */
  @Nullable
  public T getNewValue() {
    return newValue;
  }
}

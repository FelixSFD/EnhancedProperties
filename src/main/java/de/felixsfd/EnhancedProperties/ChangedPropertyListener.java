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

/**
 * Listener for changed properties in {@link EnhancedWriteableProperties}
 * <br>
 * You can add new listeners via {@link EnhancedWriteableProperties#addChangedPropertyListener(ChangedPropertyListener)}
 * @since 1.1.0
 */
@FunctionalInterface
public interface ChangedPropertyListener {
  /**
   * Whenever a property was changed via a setter,
   * this method will be called to inform all listeners
   * @param changedPropertyEvent Information about the change including
   *                             new value, old value and type
   *
   * @since 1.1.0
   */
  void propertyChanged(ChangedPropertyEvent<?> changedPropertyEvent);
}

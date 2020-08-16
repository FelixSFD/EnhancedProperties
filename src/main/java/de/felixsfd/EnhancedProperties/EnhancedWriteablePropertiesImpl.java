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
import de.felixsfd.EnhancedProperties.utils.EPStringUtils;
import org.apache.commons.lang3.ClassUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;


/**
 * Abstract base class for a writeable properties-wrapper. Do not implement this class.
 * <br>
 * Use one of these instead:
 * <ul>
 *   <li>{@link EnhancedPropertiesInFile}</li>
 *   <li>{@link EnhancedPropertiesInFileOrResources}</li>
 * </ul>
 *
 * @since 1.1.0
 */
public abstract class EnhancedWriteablePropertiesImpl extends EnhancedPropertiesImpl implements EnhancedWriteableProperties {
  /**
   * Collection of {@link ChangedPropertyListener}s
   */
  private @Nullable Set<ChangedPropertyListener> changedPropertyListeners = null;

  /**
   * Sets a given property
   * @param key Name of the property
   * @param value new Value
   * @throws EPSetPropertyException if the property could not be set
   * @throws EPTypeNotSupportedException if the type of the value is not supported
   */
  protected void setValue(@NotNull String key, @Nullable Object value) throws EPTypeNotSupportedException, EPSetPropertyException {
    Object originalValue = getValue(key, value != null ? value.getClass() : String.class);
    setString(key, String.valueOf(value));
    propertyChanged(key, originalValue, value);
  }


  /**
   * Internal method to set any property. This will wrap any exception in {@link EPSetPropertyException
   * @param key Name of the property
   * @param value new Value
   * @throws EPSetPropertyException Wraps any exceptions that occur while setting the property
   */
  private void setValueInternal(@NotNull String key, @Nullable Object value) throws EPSetPropertyException {
    try {
      setValue(key, value);
    } catch (EPTypeNotSupportedException e) {
      throw new EPSetPropertyException(this, "The property " + key + " could not be set: " + e.getMessage(), e);
    }
  }


  /**
   * Reads a value from properties as a given type
   * @param key Name of the property
   * @param type Type of the property
   * @return Value
   * @throws EPTypeNotSupportedException If EnhancedProperties does not support this type
   */
  protected Object getValue(String key, Class<?> type) throws EPTypeNotSupportedException {
    String getterName = getGetterName(type);
    try {
      Method getter = EnhancedProperties.class.getDeclaredMethod(getterName, String.class);
      return getter.invoke(this, key);
    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
      Throwable cause = e.getCause();
      if (e instanceof InvocationTargetException && cause instanceof NullPointerException) {
        return null;
      }

      throw new EPTypeNotSupportedException(this, type, e);
    }
  }


  /**
   * Returns the name of the getter for a given type. For wrapper-classes,
   * the primitive types will be used, since we always try to use primitive types
   * in the getters and setters of {@link EnhancedProperties}.
   * <br>
   * This method does NOT check, if the getter exists!
   * @param type Name of the type for the getter
   * @return name of the getter (example: Integer -> getInt)
   */
  @NotNull
  private String getGetterName(@NotNull Class<?> type) {
    Class<?> classOrPrimitive = ClassUtils.wrapperToPrimitive(type);
    classOrPrimitive = classOrPrimitive == null ? type : classOrPrimitive;
    String typeName = classOrPrimitive.getSimpleName().toLowerCase();
    return "get" + EPStringUtils.firstLetterUppercase(typeName);
  }


  /**
   * Sets a given property.
   * <br>
   * Since the properties are always stored as strings, {@link String#valueOf(int)} )} will be used.
   *
   * @param key   Name of the property
   * @param value new Value
   * @throws EPSetPropertyException if the property could not be set
   */
  @Override
  public final void setShort(@NotNull String key, short value) throws EPSetPropertyException {
    setValueInternal(key, value);
  }


  /**
   * Sets a given property.
   * <br>
   * Since the properties are always stored as strings, {@link String#valueOf(int)} will be used.
   *
   * @param key   Name of the property
   * @param value new Value
   * @throws EPSetPropertyException if the property could not be set
   */
  @Override
  public final void setInt(@NotNull String key, int value) throws EPSetPropertyException {
    setValueInternal(key, value);
  }


  /**
   * Sets a given property.
   * <br>
   * Since the properties are always stored as strings, {@link String#valueOf(long)} will be used.
   *
   * @param key   Name of the property
   * @param value new Value
   * @throws EPSetPropertyException if the property could not be set
   */
  @Override
  public final void setLong(@NotNull String key, long value) throws EPSetPropertyException {
    setValueInternal(key, value);
  }


  /**
   * Sets a given property.
   * <br>
   * Since the properties are always stored as strings, {@link String#valueOf(float)} will be used.
   *
   * @param key   Name of the property
   * @param value new Value
   * @throws EPSetPropertyException if the property could not be set
   */
  @Override
  public final void setFloat(@NotNull String key, float value) throws EPSetPropertyException {
    setValueInternal(key, value);
  }


  /**
   * Sets a given property.
   * <br>
   * Since the properties are always stored as strings, {@link String#valueOf(double)} will be used.
   *
   * @param key   Name of the property
   * @param value new Value
   * @throws EPSetPropertyException if the property could not be set
   */
  @Override
  public final void setDouble(@NotNull String key, double value) throws EPSetPropertyException {
    setValueInternal(key, value);
  }


  /**
   * Sets a given property.
   * <br>
   * Since the properties are always stored as strings, {@link String#valueOf(boolean)} will be used.
   *
   * @param key   Name of the property
   * @param value new Value
   * @throws EPSetPropertyException if the property could not be set
   */
  @Override
  public final void setBoolean(@NotNull String key, boolean value) throws EPSetPropertyException {
    setValueInternal(key, value);
  }


  /**
   * Calls the {@link ChangedPropertyListener}s of this instance.
   * @param event Event with information about the changed property
   *
   * @since 1.1.0
   */
  protected final void callChangedPropertyListeners(@NotNull ChangedPropertyEvent<?> event) {
    Iterable<ChangedPropertyListener> changedPropertyListeners = getChangedPropertyListeners();
    changedPropertyListeners.forEach(listener -> listener.propertyChanged(event));
  }


  /**
   * Creates a {@link ChangedPropertyEvent} and calls the {@link ChangedPropertyListener}s
   * @param key Changed key
   * @param originalValue value before the change
   * @param newValue new value
   *
   * @since 1.1.0
   */
  protected final void propertyChanged(String key, Object originalValue, Object newValue) {
    ChangedPropertyEvent<?> event = new ChangedPropertyEvent<>(this, key, originalValue, newValue);

    callChangedPropertyListeners(event);
  }


  /**
   * @return All listeners for changed properties
   * @see ChangedPropertyListener
   */
  @Override
  public @NotNull Set<ChangedPropertyListener> getChangedPropertyListeners() {
    if (changedPropertyListeners == null) {
      changedPropertyListeners = new HashSet<>();
    }

    return changedPropertyListeners;
  }


  /**
   * Adds a new {@link ChangedPropertyListener}
   * @param changedPropertyListener new listener
   * @see #getChangedPropertyListeners()
   */
  @Override
  public void addChangedPropertyListener(@NotNull ChangedPropertyListener changedPropertyListener) {
    getChangedPropertyListeners().add(changedPropertyListener);
  }
}

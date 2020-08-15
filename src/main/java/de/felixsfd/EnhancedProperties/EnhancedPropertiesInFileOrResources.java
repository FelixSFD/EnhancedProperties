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

import de.felixsfd.EnhancedProperties.annotations.ReadRule;
import de.felixsfd.EnhancedProperties.core.SortedProperties;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;


/**
 * Abstract base-class for enhanced properties that are either stored in the application's resources or the file-system.
 * <br>
 * The keys in both files can override each other. To specify, which file will be used first, you can use the
 * {@link ReadRule} annotation.
 */
public abstract class EnhancedPropertiesInFileOrResources extends EnhancedWriteablePropertiesImpl {
  @NotNull private final String filePath;
  @NotNull private final String resourcesPath;
  @NotNull private final SortedProperties propertiesFile;
  @NotNull private final Properties propertiesResources;


  /**
   * <p>
   *   Constructor with paths to both files.
   * </p>
   * <p>
   *   <b>Note:</b> Only if the preferred location is
   *   {@link de.felixsfd.EnhancedProperties.annotations.ReadRule.Location#FILE},
   *   the file does not need to exist.<br>
   *   If the preferred location is {@link de.felixsfd.EnhancedProperties.annotations.ReadRule.Location#RESOURCES},
   *   the file has to exists because it would contain the default values.
   * </p>
   * @param filePath Path to properties file in file-system
   * @param resourcesPath Path to properties file in resources
   * @throws IOException if one of the files can't be read.
   */
  protected EnhancedPropertiesInFileOrResources(@NotNull String filePath, @NotNull String resourcesPath) throws IOException {
    this.filePath = filePath;
    this.resourcesPath = resourcesPath;

    SortedProperties newFileProperties;
    try {
       newFileProperties = EnhancedPropertiesInFile.readFromFiles(filePath);
    } catch (FileNotFoundException e) {
      //File not found, but if the preferred location is FILE, the application can still fall back to resources
      if (getReadRule() != ReadRule.Location.FILE) {
        throw e;
      }

      newFileProperties = new SortedProperties();
    }
    propertiesFile = newFileProperties;

    propertiesResources = EnhancedPropertiesInResources.readFromResources(resourcesPath);
  } // EnhancedPropertiesInFileOrResources


  @Override
  public @Nullable String getString(@NotNull String key) {
    return getString(key, null);
  }


  @Override
  public @Nullable String getString(@NotNull String key, @Nullable String defaultValue) {
    String resourcesValue;
    String fileValue;

    ReadRule.Location rule = getReadRule();
    switch (rule) {
      case FILE:
        fileValue = propertiesFile.getProperty(key);
        if (fileValue == null) {
          return propertiesResources.getProperty(key, defaultValue);
        } else {
          return fileValue;
        }
      case RESOURCES:
        resourcesValue = propertiesResources.getProperty(key);
        if (resourcesValue == null) {
          return propertiesFile.getProperty(key, defaultValue);
        } else {
          return resourcesValue;
        }
      default:
        return defaultValue;
    }
  }


  /**
   * Sets the value of a key in the properties file.
   * <br><br>
   * <b>Note:</b><br>
   * If you are using {@link ReadRule.Location#RESOURCES}, the changes will NOT be used.
   * The changes will be written to the file-system when {@link #save()} is called,
   * but your class will still use the value from your application's resources.
   * @param key Name of the property
   * @param value new Value
   */
  @Override
  public void setString(@NotNull String key, @Nullable String value) {
    String originalStr = getString(key, null);
    propertiesFile.put(key, value);
    propertyChanged(key, originalStr, value);
  }


  /**
   * Reads the {@link ReadRule} annotation from the class.
   * @return Value or {@link ReadRule#DEFAULT_LOCATION}, if no annotation is present
   */
  private ReadRule.Location getReadRule() {
    if (getClass().isAnnotationPresent(ReadRule.class)) {
      return getClass().getAnnotation(ReadRule.class).preferredLocation();
    } else {
      return ReadRule.DEFAULT_LOCATION;
    }
  }


  /**
   * @return Path to the properties file in the application's properties
   */
  @NotNull
  public String getResourcesPath() {
    return resourcesPath;
  }


  /**
   * @return Path to the properties file in the file-system
   */
  @NotNull
  public String getFilePath() {
    return filePath;
  }


  /**
   * Writes the properties to the file
   */
  @Override
  public void save() throws IOException {
    save(getFilePath());
  }


  /**
   * Writes the properties to a different file
   *
   * @param filePath Path of the file to write
   */
  @Override
  public void save(@NotNull String filePath) throws IOException {
    try (FileOutputStream fos = new FileOutputStream(filePath)) {
      propertiesFile.store(fos, "Generated by de.felixsfd.EnhancedProperties");
    }
  }
} // EnhancedPropertiesInFileOrResources

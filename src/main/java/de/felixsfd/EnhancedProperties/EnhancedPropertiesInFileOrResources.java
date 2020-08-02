package de.felixsfd.EnhancedProperties;

import de.felixsfd.EnhancedProperties.annotations.ReadRule;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.Properties;


/**
 * Abstract base-class for enhanced properties that are either stored in the application's resources or the file-system.
 * <br />
 * The keys in both files can override each other. To specify, which file will be used first, you can use the
 * {@link ReadRule} annotation.
 */
public abstract class EnhancedPropertiesInFileOrResources extends EnhancedProperties {
  @NotNull private final String filePath;
  @NotNull private final String resourcesPath;
  @NotNull private final Properties propertiesFile;
  @NotNull private final Properties propertiesResources;


  /**
   * Constructor with paths to both files
   * @param filePath Path to properties file in file-system
   * @param resourcesPath Path to properties file in resources
   * @throws IOException if one of the files can't be read.
   */
  protected EnhancedPropertiesInFileOrResources(@NotNull String filePath, @NotNull String resourcesPath) throws IOException {
    this.filePath = filePath;
    this.resourcesPath = resourcesPath;

    propertiesFile = EnhancedPropertiesInFile.readFromFiles(filePath);
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
  public String getResourcesPath() {
    return resourcesPath;
  }


  /**
   * @return Path to the properties file in the file-system
   */
  public String getFilePath() {
    return filePath;
  }
} // EnhancedPropertiesInFileOrResources

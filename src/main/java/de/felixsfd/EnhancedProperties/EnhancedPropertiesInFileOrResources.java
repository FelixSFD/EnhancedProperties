package de.felixsfd.EnhancedProperties;

import de.felixsfd.EnhancedProperties.annotations.ReadRule;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.Properties;

public abstract class EnhancedPropertiesInFileOrResources extends EnhancedProperties {
  @NotNull private final String filePath;
  @NotNull private final String resourcesPath;
  @NotNull private final Properties propertiesFile;
  @NotNull private final Properties propertiesResources;

  protected EnhancedPropertiesInFileOrResources(@NotNull String filePath, @NotNull String resourcesPath) throws IOException {
    this.filePath = filePath;
    this.resourcesPath = resourcesPath;

    propertiesFile = EnhancedPropertiesInFile.readFromFiles(filePath);
    propertiesResources = EnhancedPropertiesInResources.readFromResources(resourcesPath);
  }


  @Override
  public @Nullable String getString(@NotNull String key) {
    return getString(key, null);
  }


  @Override
  public @Nullable String getString(@NotNull String key, @Nullable String defaultValue) {
    String resourcesValue;
    String fileValue;

    ReadRule.Preference rule = getReadRule();
    switch (rule) {
      case FILE_FIRST:
        fileValue = propertiesFile.getProperty(key);
        if (fileValue == null) {
          return propertiesResources.getProperty(key, defaultValue);
        } else {
          return fileValue;
        }
      case RESOURCES_FIRST:
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
   * @return Value or {@link ReadRule#DEFAULT_VALUE}, if no annotation is present
   */
  private ReadRule.Preference getReadRule() {
    if (getClass().isAnnotationPresent(ReadRule.class)) {
      return getClass().getAnnotation(ReadRule.class).value();
    } else {
      return ReadRule.DEFAULT_VALUE;
    }
  }
}

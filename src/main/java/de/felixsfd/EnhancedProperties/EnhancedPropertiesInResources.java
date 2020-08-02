package de.felixsfd.EnhancedProperties;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Abstract base-class for enhanced properties that are stored in the application's resources.
 * <br />
 * If the file is stored in the file-system, please use {@link EnhancedPropertiesInFile}.
 * <br />
 * If you want to use the properties from a file in the file-system and in the resources at the same time
 * (overwriting each other), you can use {@link EnhancedPropertiesInFileOrResources}.
 */
public abstract class EnhancedPropertiesInResources extends EnhancedProperties {
  @NotNull private final String resourcesPath;
  @NotNull private Properties propertiesInResources;

  protected EnhancedPropertiesInResources(@NotNull String resourcesPath) throws IOException {
    super();

    this.resourcesPath = resourcesPath;
    propertiesInResources = readFromResources(resourcesPath);
  } // EnhancedPropertiesInResources


  /**
   * Constructs a {@link Properties} object from a file in resources.
   * @param path Path in resources
   * @return {@link Properties} object
   * @throws IOException on read error
   */
  @NotNull
  static Properties readFromResources(@NotNull String path) throws IOException {
    Properties prop = new Properties();

    try (InputStream fis = EnhancedPropertiesInResources.class.getClassLoader().getResourceAsStream(path)) {
      prop.load(fis);
    }

    return prop;
  } // readFromResources


  @Override
  @Nullable
  public String getString(@NotNull String key) {
    return getString(key, null);
  }


  @Override
  @Nullable
  public String getString(@NotNull String key, @Nullable String defaultValue) {
    return propertiesInResources.getProperty(key, defaultValue);
  }


  /**
   * Return the path to the properties-file. This value is null, if the properties are only read from file-system.
   * @return Path to the properties-file
   */
  @NotNull
  public String getResourcesPath() {
    return resourcesPath;
  } // getResourcesPath
}

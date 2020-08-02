package de.felixsfd.EnhancedProperties;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Abstract base-class for enhanced properties that are stored in the file-system.
 * <br />
 * If the file is stored in the application's resources, please use {@link EnhancedPropertiesInResources}.
 * <br />
 * If you want to use the properties from a file in the file-system and in the resources at the same time
 * (overwriting each other), you can use {@link EnhancedPropertiesInFileOrResources}.
 */
public abstract class EnhancedPropertiesInFile extends EnhancedProperties {
  @NotNull private final String path;
  @NotNull private Properties propertiesInFile;


  /**
   * Constructor with file path
   * @param path Path to the properties-file
   * @throws IOException If the file can't be read
   */
  protected EnhancedPropertiesInFile(@NotNull String path) throws IOException {
    super();
    this.path = path;
    propertiesInFile = readFromFiles(path);
  } // EnhancedPropertiesInFile


  /**
   * Constructs a {@link Properties} object from a file in the file-system.
   * @param path Path in file-system either absolute or relative to the application
   * @return {@link Properties} object
   * @throws IOException on read error
   */
  @NotNull
  static Properties readFromFiles(@NotNull String path) throws IOException {
    Properties prop = new Properties();

    try (FileInputStream fis = new FileInputStream(new File(path))) {
      prop.load(fis);
    }

    return prop;
  } // readFromFiles


  @Override
  @Nullable
  public String getString(@NotNull String key) {
    return getString(key, null);
  }


  @Override
  @Nullable
  public String getString(@NotNull String key, @Nullable String defaultValue) {
    return propertiesInFile.getProperty(key, defaultValue);
  }


  /**
   * Return the path to the properties-file. This value is null, if the properties are only read from resources.
   * @return Path to the properties-file
   */
  @NotNull
  public String getPath() {
    return path;
  } // getPath
} // EnhancedPropertiesInFile

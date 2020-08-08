package de.felixsfd.EnhancedProperties;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


/**
 * Interface for the properties-wrapper. Do not implement this interface.
 * <br>
 * Use one of these classes instead:
 * <ul>
 *   <li>{@link EnhancedPropertiesInFile}</li>
 *   <li>{@link EnhancedPropertiesInResources}</li>
 *   <li>{@link EnhancedPropertiesInFileOrResources}</li>
 * </ul>
 */
public interface EnhancedProperties {
  /**
   * Returns the string-value of a key in the properties file.
   * <br>
   * When implementing this method, make sure to read the {@link java.util.Properties} correctly.
   * @param key Key in the properties-file
   * @return Value es string
   */
  @Nullable String getString(@NotNull String key);

  /**
   * Returns the string-value of a key in the properties file.
   * <br>
   * When implementing this method, make sure to read the {@link java.util.Properties} correctly.
   * @param key Key in the properties-file
   * @param defaultValue Default value, if the value was null
   * @return Value es string
   */
  @Nullable String getString(@NotNull String key, @Nullable String defaultValue);

  /**
   * Returns the content of the key as short
   * <br>
   * Any exceptions while parsing will be thrown
   * @param key Key in the Properties-File
   * @return Values as Short
   */
  short getShort(@NotNull String key) throws NumberFormatException, NullPointerException;

  /**
   * Returns the content of the key as short
   * @param key Key in the Properties-File
   * @param defaultValue Value, if the Key is null or not a number
   * @return Values as Short
   */
  short getShort(@NotNull String key, short defaultValue);

  /**
   * Returns the content of the key as int
   * <br>
   * Any exceptions while parsing will be thrown
   * @param key Key in the Properties-File
   * @return Values as Integer
   */
  int getInt(@NotNull String key) throws NumberFormatException, NullPointerException;

  /**
   * Returns the content of the key as int
   * @param key Key in the Properties-File
   * @param defaultValue Value, if the Key is null or not a number
   * @return Values as Integer
   */
  int getInt(@NotNull String key, int defaultValue);

  /**
   * Returns the content of the key as long
   * <br>
   * Any exceptions while parsing will be thrown
   * @param key Key in the Properties-File
   * @return Values as Long
   */
  long getLong(@NotNull String key) throws NumberFormatException, NullPointerException;

  /**
   * Returns the content of the key as int
   * @param key Key in the Properties-File
   * @param defaultValue Value, if the Key is null or not a number
   * @return Values as Integer
   */
  long getLong(@NotNull String key, long defaultValue);

  /**
   * Returns the content of the key as float
   * <br>
   * Any exceptions while parsing will be thrown
   * @param key Key in the Properties-File
   * @return Values as Float
   */
  float getFloat(@NotNull String key) throws NumberFormatException, NullPointerException;

  /**
   * Returns the content of the key as float
   * @param key Key in the Properties-File
   * @param defaultValue Value, if the Key is null or not a number
   * @return Values as Float
   */
  float getFloat(@NotNull String key, float defaultValue);

  /**
   * Returns the content of the key as double
   * <br>
   * Any exceptions while parsing will be thrown
   * @param key Key in the Properties-File
   * @return Values as Double
   */
  double getDouble(@NotNull String key) throws NumberFormatException, NullPointerException;

  /**
   * Returns the content of the key as double
   * @param key Key in the Properties-File
   * @param defaultValue Value, if the Key is null or not a number
   * @return Values as Double
   */
  double getDouble(@NotNull String key, double defaultValue);
}

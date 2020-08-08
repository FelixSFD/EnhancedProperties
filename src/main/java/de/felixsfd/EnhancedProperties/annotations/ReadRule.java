package de.felixsfd.EnhancedProperties.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Rules on how to read a properties file.
 * <br>
 * This is mainly used by {@link de.felixsfd.EnhancedProperties.EnhancedPropertiesInFileOrResources} to specify,
 * which location to check first.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ReadRule {
  /**
   * Default location
   */
  Location DEFAULT_LOCATION = Location.FILE;


  /**
   * Location of a value (file or resources)
   */
  enum Location {
    FILE, RESOURCES
  } // enum


  /**
   * Location that will be checked first. This location will be checked first.
   * If a key does not exist there, the other location will be used to retrieve the data.
   * @return The preferred location
   */
  Location preferredLocation() default Location.FILE;
}

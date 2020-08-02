package de.felixsfd.EnhancedProperties.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ReadRule {
  Preference DEFAULT_VALUE = Preference.FILE_FIRST;

  enum Preference {
    FILE_FIRST, RESOURCES_FIRST
  }


  Preference value() default Preference.FILE_FIRST;
}

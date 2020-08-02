package de.felixsfd.EnhancedProperties;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  EnhancedPropertiesInFileTest.class
  , EnhancedPropertiesInResourcesTest.class
  , EnhancedPropertiesInFileOrResourcesTest.class
})
public class EnhancedPropertiesTestSuite {
}

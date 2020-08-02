package de.felixsfd.EnhancedProperties.testProperties;

import de.felixsfd.EnhancedProperties.EnhancedPropertiesInFileOrResources;
import de.felixsfd.EnhancedProperties.EnhancedPropertiesInFileOrResourcesTest;
import de.felixsfd.EnhancedProperties.annotations.ReadRule;

import java.io.IOException;


@ReadRule(value = ReadRule.Preference.FILE_FIRST)
public class TestPropertiesFileFirst extends EnhancedPropertiesInFileOrResources {
  public TestPropertiesFileFirst() throws IOException {
    super(EnhancedPropertiesInFileOrResourcesTest.FILE_PATH, EnhancedPropertiesInFileOrResourcesTest.RESOURCES_PATH);
  }
}

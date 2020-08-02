package de.felixsfd.EnhancedProperties.testProperties;

import de.felixsfd.EnhancedProperties.EnhancedPropertiesInFileOrResources;
import de.felixsfd.EnhancedProperties.EnhancedPropertiesInFileOrResourcesTest;
import de.felixsfd.EnhancedProperties.annotations.ReadRule;

import java.io.IOException;

@ReadRule(preferredLocation = ReadRule.Location.RESOURCES)
public class TestPropertiesResourcesFirst extends EnhancedPropertiesInFileOrResources {
  public TestPropertiesResourcesFirst() throws IOException {
    super(EnhancedPropertiesInFileOrResourcesTest.FILE_PATH, EnhancedPropertiesInFileOrResourcesTest.RESOURCES_PATH);
  }
}

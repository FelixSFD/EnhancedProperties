package de.felixsfd.EnhancedProperties.testProperties;

import de.felixsfd.EnhancedProperties.EnhancedPropertiesInFileOrResources;
import de.felixsfd.EnhancedProperties.EnhancedPropertiesInFileOrResourcesTest;
import de.felixsfd.EnhancedProperties.annotations.ReadRule;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

@ReadRule(value = ReadRule.Preference.RESOURCES_FIRST)
public class TestPropertiesResourcesFirst extends EnhancedPropertiesInFileOrResources {
  public TestPropertiesResourcesFirst() throws IOException {
    super(EnhancedPropertiesInFileOrResourcesTest.FILE_PATH, EnhancedPropertiesInFileOrResourcesTest.RESOURCES_PATH);
  }
}

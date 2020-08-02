# EnhancedProperties
_EnhancedProperties_ is an improved way to read `*.properties`-files in Java. It handles reading (and soon writing) files for you, so you don't need to worry about your Input/Output-Streams, closing files etc. There are even methods to parse the data into the most common datatypes.
This library is especially useful, if you have a large amount of properties.

# Basic example
## The old way

For reading a double value from a local properties file, you'd do something like this:

```java
Properties properties = new Properties();
try (FileInputStream fis = new FileInputStream(new File("my.properties"))) {
  properties.load(fis);
}

String strValue = properties.getProperty("someNumber", "0.0");
double doubleValue;
try {
  doubleValue = Double.parseDouble(strValue);
} catch (NumberFormatException e) {
  doubleValue = 0.0;
}
```

This might be nice an quick in some cases, but if you have lots of properties and read them very often, this can be quite annoying.

## Quick and dirty

If you don't have many different keys in you file, you can create an anonymous class of `EnhancedPropertiesInFile`, `EnhancedPropertiesInResources` or `EnhancedPropertiesInFileOrResources`.
**This is not the recommended way, but it should work, too.**

```java
EnhancedPropertiesInFile propertiesInFile = new EnhancedPropertiesInFile("my.properties") {};
double doubleValue = propertiesInFile.getDouble("someNumber", 0.0);
```

## The beautiful way

**This is the recommended way of using _EnhancedProperties_.**

### Create your Properties-Class

To read the properties for your application, you'll need to create a subclass of `EnhancedPropertiesInFile`, `EnhancedPropertiesInResources` or `EnhancedPropertiesInFileOrResources`.
In this example, we need `EnhancedPropertiesInFile`.

```java
public class MyProperties extends EnhancedPropertiesInFile {
  protected MyProperties() throws IOException {
    super("my.properties");
  }

  public double getDoubleValue(double defaultValue) {
    return super.getDouble("doubleValue", defaultValue);
  }
}
```

### Access the property

Since the `MyProperties`-class contains the file-path and handles parsing the double as well, we can now access the value like this:

```java
MyProperties myProperties = new MyProperties();
double doubleValue = myProperties.getDoubleValue(0.0);
```


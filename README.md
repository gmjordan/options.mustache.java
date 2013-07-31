options.mustache.java
=====================

Steps to include:

- include the [mustache.java](https://github.com/spullara/mustache.java) project in your app

Maven dependency information (ie. for most common cases you will just need the `compiler` module):

```xml

<dependency>
  <groupId>com.github.spullara.mustache.java</groupId>
  <artifactId>compiler</artifactId>
  <version>0.8.12</version>
</dependency>

```

- Download the [mustache-java-options.jar](https://github.com/gmjordan/options.mustache.java/raw/master/target/mustache-java-options-1.1.0.jar) and add to your project.

Usage:




```java
// mark as transient
@Transient
// options:
// 
@MustacheOption(markupValue = " checked ", mustacheOptionKVs = {
		@MustacheOptionKV(option = "male", optionDisplay = "Male"),
		@MustacheOptionKV(option = "female", optionDisplay = "Female")
})
private List<Option> genderOptions;
```
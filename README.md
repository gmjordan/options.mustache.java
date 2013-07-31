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

// add the property you are going to persist.
private String gender;

// mark the option list as transient
@Transient
@MustacheOption(markupValue = " checked ", mustacheOptionKVs = {
		@MustacheOptionKV(option = "male", optionDisplay = "Male"),
		@MustacheOptionKV(option = "female", optionDisplay = "Female")
})
private List<Option> Options;
```

- @MustacheOption options: 
 - splitOn -  the character with which the storedOptionValOrVals (e.g. gender property) is split. In most cases, you're going to be storing a single value
	but if you've got a string stored as a csv string, then you could store multiple vals.  This would work with a select list that allows multiple or for checkboxes
  - markupValue - the string value of the markup you want displayed when true, e.g. selected="selected" OR checked
   - mustacheOptionKVs - a list of key/value. 

To generate the list for display:

```java
OptionList optionList = new OptionList();
// the "getOptionList" method take the user.getGender() string val and compare it against the  
// map options set in the mustacheOptionKVs, which is supplied with DeclaredField arugment. 
// the final argument (the boolean) will sort mustacheOptionKVs by the optionDisplay 
// using a comparator, if true. otherwise, order is not guaranteed.
user.setGenderOptions(optionList.getOptionList(
	user.getGender(), 
	User.class.getDeclaredField("genderOptions"), 
	true))
```

some other methods to generate the OptionList

```java
// using annotations
public List<Option> getOptionList(Map<String, String> optionsToReturn, boolean sortByOptionDisplay)


```

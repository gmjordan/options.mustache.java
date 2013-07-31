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
@MustacheOption(markupValue = " checked=\"checked\" ", mustacheOptionKVs = {
		@MustacheOptionKV(option = "male", optionDisplay = "Male"),
		@MustacheOptionKV(option = "female", optionDisplay = "Female")
})
private List<Option> Options;
```

- @MustacheOption options: 
 - splitOn -  the character with which the storedOptionValOrVals (e.g. gender property) is split. In most cases, you're going to be storing a single value
	but if you've got a string stored as a csv string, then you could store multiple vals.  This would work with a select list that allows multiple or for checkboxes
  - markupValue - the string value of the markup you want displayed when true, e.g. selected="selected" OR checked
   - mustacheOptionKVs - array of key/value pairs. 

To generate the list for display:

```java
OptionList optionList = new OptionList();
// the "getOptionList" method takes the user.getGender() string val and compares it against the  
// map options set in the mustacheOptionKVs, which is created using
// reflection using the DeclaredField arugment. 
// the final argument (the boolean) will sort mustacheOptionKVs by the optionDisplay 
// using a comparator, if true. otherwise, order is not guaranteed.
user.setGenderOptions(optionList.getOptionList(
	user.getGender(), 
	User.class.getDeclaredField("genderOptions"), 
	true))
```

Another method to generate the OptionList

```java

// providing your own Map, split character, markupvalue. 
public List<Option> getOptionList(String storedOptionValOrVals, Map<String, String> optionsToEval, String splitOn, String markupValue, boolean sortByOptionDisplay)
```

There are few more, which you can see when using code insight in your editor.

The markup and mustache look like this:

```html
<label for="gender">Gender</label>
{{#user.genderOptions}}
	<label class="pro-label" for="gender-{{option}}">
	<input type="radio" id="gender-{{option}}" name="profile.gender" value="{{option}}"  {{markupValue}}/> 
	{{optionDisplay}}
	</label>
{{/user.genderOptions}}
```
you could also do the following if you aren't using the markupValue param

```html
<label for="gender">Gender</label>
{{#user.genderOptions}}
	<label class="pro-label" for="gender-{{option}}">
	<input type="radio" id="gender-{{option}}" name="profile.gender" value="{{option}}"  {{#optionSelected}} checked="checked"  {{/optionSelected}}  /> 
	{{optionDisplay}}
	</label>
{{/user.genderOptions}}
```
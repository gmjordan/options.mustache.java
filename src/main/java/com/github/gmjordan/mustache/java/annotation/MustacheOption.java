package com.github.gmjordan.mustache.java.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The Interface MustacheOption.
 */
@Documented
@Target({ ElementType.FIELD, ElementType.TYPE, ElementType.METHOD })
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MustacheOption {

	/**
	 * Markup value. the string value of the markup you want displayed when true, e.g. selected="selected" OR checked
	 * 
	 * @return the string
	 */
	String markupValue() default "";

	/**
	 * Split on. the character with which the storedOptionValOrVals is split
	 * 
	 * @return the string
	 */
	String splitOn() default "";

	/**
	 * Mustache option k vs.
	 * 
	 * @return the mustache option k v[]
	 */
	MustacheOptionKV[] mustacheOptionKVs() default {};
}

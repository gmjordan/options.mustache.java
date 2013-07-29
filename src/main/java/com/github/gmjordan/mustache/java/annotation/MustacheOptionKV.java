package com.github.gmjordan.mustache.java.annotation;

/**
 * The Interface MustacheOptionKV.
 */
public @interface MustacheOptionKV {

	/**
	 * Option - equivalent to the key
	 * 
	 * @return the string
	 */
	public String option();

	/**
	 * Option for display - equivalent to the value
	 * 
	 * @return the string
	 */
	public String optionDisplay();
}

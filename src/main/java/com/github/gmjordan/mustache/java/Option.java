package com.github.gmjordan.mustache.java;

import java.io.Serializable;

/**
 * The Class Option.
 */
public class Option implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The option. */
	private String option;

	/** The option display. */
	private String optionDisplay;

	/** The markup value. */
	private String markupValue;

	/** The option selected. */
	private boolean optionSelected;

	/**
	 * The Constructor.
	 */
	public Option() {
	}

	/**
	 * The Constructor.
	 * 
	 * @param option the option
	 */
	public Option(String option) {
		super();
		this.option = option;
	}

	/**
	 * The Constructor.
	 * 
	 * @param option the option
	 * @param optionDisplay the option display
	 */
	public Option(String option, String optionDisplay) {
		super();
		this.option = option;
		this.optionDisplay = optionDisplay;
	}

	/**
	 * The Constructor.
	 * 
	 * @param option the option
	 * @param optionSelected the option selected
	 */
	public Option(String option, boolean optionSelected) {
		super();
		this.option = option;
		this.optionSelected = optionSelected;
	}

	/**
	 * The Constructor.
	 * 
	 * @param option the option
	 * @param optionDisplay the option display
	 * @param optionSelected the option selected
	 */
	public Option(String option, String optionDisplay, boolean optionSelected) {
		super();
		this.option = option;
		this.optionDisplay = optionDisplay;
		this.optionSelected = optionSelected;
	}

	/**
	 * The Constructor.
	 * 
	 * @param option the option
	 * @param optionDisplay the option display
	 * @param optionSelected the option selected
	 * @param markupValue the markup value
	 */
	public Option(String option, String optionDisplay, boolean optionSelected, String markupValue) {
		super();
		this.option = option;
		this.optionDisplay = optionDisplay;
		this.markupValue = markupValue;
		this.optionSelected = optionSelected;
	}

	/**
	 * Gets the option.
	 * 
	 * @return the option
	 */
	public String getOption() {
		return option;
	}

	/**
	 * Sets the option.
	 * 
	 * @param option the option
	 */
	public void setOption(String option) {
		this.option = option;
	}

	/**
	 * Gets the option display.
	 * 
	 * @return the option display
	 */
	public String getOptionDisplay() {
		return optionDisplay;
	}

	/**
	 * Sets the option display.
	 * 
	 * @param optionDisplay the option display
	 */
	public void setOptionDisplay(String optionDisplay) {
		this.optionDisplay = optionDisplay;
	}

	/**
	 * Gets the option selected.
	 * 
	 * @return the option selected
	 */
	public boolean getOptionSelected() {
		return optionSelected;
	}

	/**
	 * Sets the option selected.
	 * 
	 * @param optionSelected the option selected
	 */
	public void setOptionSelected(boolean optionSelected) {
		this.optionSelected = optionSelected;
	}

	/**
	 * Gets the markup value.
	 * 
	 * @return the markup value
	 */
	public String getMarkupValue() {
		return markupValue;
	}

	/**
	 * Sets the markup value.
	 * 
	 * @param markupValue the markup value
	 */
	public void setMarkupValue(String markupValue) {
		this.markupValue = markupValue;
	}

}

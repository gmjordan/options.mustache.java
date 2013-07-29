package com.github.gmjordan.mustache.java;

import java.io.Serializable;

public class Option implements Serializable {

	private static final long serialVersionUID = 1L;

	private String option;

	private String optionDisplay;

	private String markupValue;

	private boolean optionSelected;

	public Option() {
	}

	public Option(String option) {
		super();
		this.option = option;
	}

	public Option(String option, String optionDisplay) {
		super();
		this.option = option;
		this.optionDisplay = optionDisplay;
	}

	public Option(String option, boolean optionSelected) {
		super();
		this.option = option;
		this.optionSelected = optionSelected;
	}

	public Option(String option, String optionDisplay, boolean optionSelected) {
		super();
		this.option = option;
		this.optionDisplay = optionDisplay;
		this.optionSelected = optionSelected;
	}

	public Option(String option, String optionDisplay, boolean optionSelected, String markupValue) {
		super();
		this.option = option;
		this.optionDisplay = optionDisplay;
		this.markupValue = markupValue;
		this.optionSelected = optionSelected;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getOptionDisplay() {
		return optionDisplay;
	}

	public void setOptionDisplay(String optionDisplay) {
		this.optionDisplay = optionDisplay;
	}

	public boolean getOptionSelected() {
		return optionSelected;
	}

	public void setOptionSelected(boolean optionSelected) {
		this.optionSelected = optionSelected;
	}

	public String getMarkupValue() {
		return markupValue;
	}

	public void setMarkupValue(String markupValue) {
		this.markupValue = markupValue;
	}

}

package com.github.gmjordan.mustache.java;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.github.gmjordan.mustache.java.annotation.MustacheOption;
import com.github.gmjordan.mustache.java.annotation.MustacheOptionKV;

public class OptionList implements Serializable {

	private static final long serialVersionUID = 1L;

	private ArrayList<Option> options = null;

	public List<Option> getOptionList(String storedOptionValOrVals, Map<String, String> optionsToEval, String splitOn) throws Exception {

		return getOptionList(storedOptionValOrVals, optionsToEval, splitOn, null);
	}

	public List<Option> getOptionList(String storedOptionValOrVals, Map<String, String> optionsToEval, String splitOn, String markupValue) throws Exception {

		options = new ArrayList<Option>();

		if ((splitOn == null) || splitOn.isEmpty()) {
			splitOn = ",";
		}

		// stored list = this, other
		List<String> soList = Arrays.asList(storedOptionValOrVals.split(splitOn));

		boolean selected = false;

		if (soList.size() == 1) {
			storedOptionValOrVals = soList.get(0);

			for (Entry<String, String> entry : optionsToEval.entrySet())
			{
				selected = storedOptionValOrVals.equals(entry.getKey());

				if ((markupValue != null) && !markupValue.isEmpty()) {
					options.add(new Option(entry.getKey(), entry.getValue(), selected, selected ? markupValue : null));
				} else {
					options.add(new Option(entry.getKey(), entry.getValue(), selected));
				}

			}

		} else {
			// main list = this, that, other
			for (Entry<String, String> entry : optionsToEval.entrySet())
			{
				selected = soList.contains(entry.getKey());

				if ((markupValue != null) && !markupValue.isEmpty()) {
					options.add(new Option(entry.getKey(), entry.getValue(), selected, selected ? markupValue : null));
				} else {
					options.add(new Option(entry.getKey(), entry.getValue(), selected));
				}

			}
		}

		return options;
	}

	public List<Option> getOptionList(String storedOptionValOrVals, Map<String, String> optionsToEval, Field field) throws Exception {
		String splitOn = ",";
		String markupValue = null;

		Field f = field;

		Annotation annotation = f.getAnnotation(MustacheOption.class);

		MustacheOption mustacheOption;

		if (annotation instanceof MustacheOption) {
			mustacheOption = (MustacheOption) annotation;

			if ((mustacheOption.markupValue() != null) && !mustacheOption.markupValue().isEmpty()) {
				markupValue = mustacheOption.markupValue();
			}

			if ((mustacheOption.splitOn() != null) && !mustacheOption.splitOn().isEmpty()) {
				splitOn = mustacheOption.markupValue();
			}
		}

		return getOptionList(storedOptionValOrVals, optionsToEval, splitOn, markupValue);
	}

	public List<Option> getOptionList(String storedOptionValOrVals, Field field) throws Exception {
		String splitOn = ",";
		String markupValue = null;
		Map<String, String> optionsToEval = null;

		Field f = field;

		Annotation annotation = f.getAnnotation(MustacheOption.class);

		MustacheOption mustacheOption;

		if (annotation instanceof MustacheOption) {
			mustacheOption = (MustacheOption) annotation;

			if ((mustacheOption.markupValue() != null) && !mustacheOption.markupValue().isEmpty()) {
				markupValue = mustacheOption.markupValue();
			}

			if ((mustacheOption.splitOn() != null) && !mustacheOption.splitOn().isEmpty()) {
				splitOn = mustacheOption.markupValue();
			}

			if ((mustacheOption.mustacheOptionKVs() != null) && (mustacheOption.mustacheOptionKVs().length > 0)) {
				optionsToEval = new HashMap<String, String>();
				for (MustacheOptionKV kv : mustacheOption.mustacheOptionKVs()) {
					optionsToEval.put(kv.option(), kv.optionDisplay());
				}
			}
		}

		return getOptionList(storedOptionValOrVals, optionsToEval, splitOn, markupValue);
	}
}

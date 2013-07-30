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

/**
 * The Class OptionList.
 */
public class OptionList implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The options. */
	private ArrayList<Option> options = null;

	/**
	 * Gets the option list.
	 * 
	 * @param storedOptionValOrVals The string or string array of stored values, e.g. female from optionsToEval map
	 * @param optionsToEval the options to eval, e.g. a map like {"male": Male, "female": Female}
	 * @param splitOn the split on. the character with which the storedOptionValOrVals is split
	 * @return the option list
	 * @throws Exception the exception
	 */
	public List<Option> getOptionList(String storedOptionValOrVals, Map<String, String> optionsToEval, String splitOn) throws Exception {

		return getOptionList(storedOptionValOrVals, optionsToEval, splitOn, null);
	}

	/**
	 * Gets the option list.
	 * 
	 * @param storedOptionValOrVals The string or string array of stored values, e.g. female from optionsToEval map
	 * @param optionsToEval the options to eval, e.g. a map like {"male": Male, "female": Female}
	 * @param splitOn the split on. the character with which the storedOptionValOrVals is split
	 * @param markupValue the markup value - the markup you want displayed when true, e.g. selected="selected" OR checked
	 * @return the option list
	 * @throws Exception the exception
	 */
	public List<Option> getOptionList(String storedOptionValOrVals, Map<String, String> optionsToEval, String splitOn, String markupValue) throws Exception {

		options = new ArrayList<Option>();
		
		// the storedOptionValOrVals have to have some value to compare against 
		if ((storedOptionValOrVals != null) && !storedOptionValOrVals.isEmpty()) {
			
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
		// otherwise just return the list with nothing selected
		}else{
			for (Entry<String, String> entry : optionsToEval.entrySet()){
				options.add(new Option(entry.getKey(), entry.getValue(), false));
			}
				
		}

		

		return options;
	}

	/**
	 * Gets the option list.
	 * 
	 * @param storedOptionValOrVals The string or string array of stored values, e.g. female from optionsToEval map
	 * @param optionsToEval the options to eval, e.g. a map like {"male": Male, "female": Female}
	 * @param field the field
	 * @return the option list
	 * @throws Exception the exception
	 */
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

	/**
	 * Gets the option list.
	 * 
	 * @param storedOptionValOrVals The string or string array of stored values, e.g. female from optionsToEval map
	 * @param field the field - the field annotated with @MustacheOption
	 * @return the option list
	 * @throws Exception the exception
	 */
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

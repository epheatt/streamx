package com.qubole.streamx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

/**
 * The Class RegexHelper to support string replacement based on configured
 * pattern and replacement string.
 */
public class RegexHelper {

	/** The regex pattern to match. */
	private Pattern regexPattern;
	
	/** The replacement string. */
	private String replacement;

	/**
	 * Instantiates a new regex helper.
	 *
	 * @param regex the regex
	 * @param replacement the replacement
	 */
	public RegexHelper(String regex, String replacement) {
		if (StringUtils.isNotEmpty(regex) && StringUtils.isNotEmpty(replacement)) {
			regexPattern = Pattern.compile(regex);
			this.replacement = replacement;
		}
	}

	/**
	 * Regex replace.
	 *
	 * @param topic the topic
	 * @return the string
	 */
	public String regexReplace(String topic) {
		if (regexPattern != null) {
			final Matcher matcher = regexPattern.matcher(topic);
			if (matcher.matches()) {
				return matcher.replaceFirst(replacement);
			}
		}
		return topic;
	}
}

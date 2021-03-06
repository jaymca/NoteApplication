/**
 * 
 */
package com.note.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author jay.prakash
 *
 */
public class CustomValidator {
	private static Pattern pattern;
	private static Matcher matcher;
	
	private static final String EMAIL_PATTERN =
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public CustomValidator() {
		pattern = Pattern.compile(EMAIL_PATTERN);
	}
	public static boolean validateEmail(final String hex) {
		matcher = pattern.matcher(hex);
		return matcher.matches();

	}

}

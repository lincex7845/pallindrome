/**
 * 
 */
package com.mera.palindrome.api.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @author DavidCamilo
 *
 * <p>A set of utilities to validate string inputs.
 * This class wraps some functionalities of {@link StringUtils} class</p>
 */
public final class StringsUtil {

	/**
	 * Constructor by default.
	 */
	private StringsUtil() {
		// empty
	}

	/**
	 * A method to verify if the given string is a palindrome <br/>
	 * Examples:
	 * <ul>
	 * <li><i>eye</i> is a palindrome</li>
	 * <li><i>ana</i> is a palindrome</li>
	 * </ul>
	 * 
	 * @param anyString
	 *            The string to be verified
	 * @return True if the given string is palindrome. Otherwise, false.
	 * 
	 */
	public static boolean isPalindrome(String anyString) {
		if (anyString != null) {
			StringBuilder sb = new StringBuilder(anyString);
			return anyString.equalsIgnoreCase(sb.reverse().toString());
		} else {
			return false;
		}
	}

	/**
	 * This method verifies if the given string is blank. It means, if is a
	 * whitespace, empty or null. Examples:
	 * <ul>
	 * <li>StringUtils.isBlank(null) = true</li>
	 * <li>StringUtils.isBlank("") = true</li>
	 * <li>StringUtils.isBlank(" ") = true</li>
	 * <li>StringUtils.isBlank("bob") = false</li>
	 * </ul>
	 * 
	 * @param anyString
	 *            The string to be checked
	 * @return True if the given string is null, empty or whitespace. Otherwise,
	 *         false.
	 */
	public static boolean isBlankString(String anyString) {
		return StringUtils.isBlank(anyString);
	}
	
	/**
	 * This method verifies if the given string represents an integer number.
	 * Examples:
	 * <ul>
	 * 	<li><i>"123"</i> represents an integer number</li>
	 * 	<li><i>"12.3"</i> does not represent an integer number</li>
	 * 	<li><i>"12 3"</i> does not represent an integer number</li>
	 * </ul>
	 * @param anyString The string to be verified
	 * @return True if the string represents an integer number. Otherwise, false.
	 */
	public static boolean isAnIntegerNumber (String anyString){
			return StringUtils.isNumeric(anyString);
	}
}
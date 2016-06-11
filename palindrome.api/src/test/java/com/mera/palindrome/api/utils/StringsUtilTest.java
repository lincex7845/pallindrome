/**
 * 
 */
package com.mera.palindrome.api.utils;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mera.palindrome.api.utils.StringsUtil;

/**
 * @author DavidCamilo
 *
 * Test case for {@link StringsUtil}
 */
public class StringsUtilTest {

	/**
	 * Test method for {@link com.mera.palindrome.api.utils.StringsUtil#isPalindrome(java.lang.String)}.
	 */
	@Test
	public void testIsPalindrome() {
		assertTrue(StringsUtil.isPalindrome("ana"));
		assertTrue(StringsUtil.isPalindrome("1001001001"));
		assertFalse(StringsUtil.isPalindrome("mera"));
	}

	/**
	 * Test method for {@link com.mera.palindrome.api.utils.StringsUtil#isBlankString(java.lang.String)}.
	 */
	@Test
	public void testIsBlankString() {
		assertTrue(StringsUtil.isBlankString(null));
		assertTrue(StringsUtil.isBlankString("  "));
		assertFalse(StringsUtil.isBlankString("palindrome"));
	}

	/**
	 * Test method for {@link com.mera.palindrome.api.utils.StringsUtil#isAnIntegerNumber(java.lang.String)}.
	 */
	@Test
	public void testIsAnIntegerNumber() {
		assertTrue(StringsUtil.isAnIntegerNumber("1001001001"));
		assertFalse(StringsUtil.isAnIntegerNumber("mera"));
	}

}

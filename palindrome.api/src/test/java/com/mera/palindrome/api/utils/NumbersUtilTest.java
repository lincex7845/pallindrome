/**
 * 
 */
package com.mera.palindrome.api.utils;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

import com.mera.palindrome.api.utils.NumbersUtil;

/**
 * @author DavidCamilo
 *
 * Test case for {@link NumbersUtil}
 */
public class NumbersUtilTest {

	/**
	 * Test method for {@link com.mera.palindrome.api.utils.NumbersUtil#getBinaryNumberInString(java.lang.Integer)}.
	 */
	@Test
	public void testGetBinaryNumberInStringInteger() {
		String expectedString = "1001001001";
		Integer number = 585;
		assertEquals(expectedString, NumbersUtil.getBinaryNumberInString(number));
	}

	/**
	 * Test method for {@link com.mera.palindrome.api.utils.NumbersUtil#getBinaryNumberInString(java.math.BigInteger)}.
	 */
	@Test
	public void testGetBinaryNumberInStringBigInteger() {
		String expectedString = "1001001001";
		BigInteger number = new BigInteger("585");
		assertEquals(expectedString, NumbersUtil.getBinaryNumberInString(number));
	}

	/**
	 * Test method for {@link com.mera.palindrome.api.utils.NumbersUtil#getRadixNumberInString(java.lang.Integer, int)}.
	 */
	@Test
	public void testGetRadixNumberInStringIntegerInt() {
		String expectedString = "1001001001";
		assertEquals(expectedString, NumbersUtil.getRadixNumberInString(585, 2));
	}

	/**
	 * Test method for {@link com.mera.palindrome.api.utils.NumbersUtil#getRadixNumberInString(java.math.BigInteger, int)}.
	 */
	@Test
	public void testGetRadixNumberInStringBigIntegerInt() {
		String expectedString = "1001001001";
		assertEquals(expectedString, NumbersUtil.getRadixNumberInString(new BigInteger("585"), 2));
	}

}

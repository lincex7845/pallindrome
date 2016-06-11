/**
 * 
 */
package com.mera.palindrome.api.utils;

import java.math.BigInteger;

/**
 * @author DavidCamilo
 *
 * <p>A set of utilities to handle integer numbers.
 * This class wraps some functionalities of {@link Integer} class</p>
 */
public final class NumbersUtil {
	
	/**
	 * A constant to represent the base/radix 2
	 */
	private final static int BINARY_RADIX = 2;

	/**
	 * Constructor by default
	 */
	private NumbersUtil(){
		// empty
	}
	
	/**
	 * This method gets the binary representation of any integer number.<br/>
	 * The binary representation is returned in String format
	 * @param integerNumber A integer number between {@link Integer#MIN_VALUE} and {@link Integer#MAX_VALUE}
	 * @return The binary number in string format
	 */
	public static String getBinaryNumberInString(Integer integerNumber){
		return Integer.toBinaryString(integerNumber);
	}
	
	/**
	 * This method gets the binary representation of any integer number.<br/>
	 * The binary representation is returned in String format
	 * @param integerNumber A integer number
	 * @return The binary number in string format
	 */
	public static String getBinaryNumberInString(BigInteger integerNumber){
		return integerNumber.toString(BINARY_RADIX);
	}
	
	/**
	 * This method gets the required representation of any number according to the
	 * given radix or base.
	 * @param integerNumber A integer number between {@link Integer#MIN_VALUE} and {@link Integer#MAX_VALUE}
	 * @param radix The radix or base to be used in the string representation
	 * @return The number representation in the specified radix
	 */
	public static String getRadixNumberInString(Integer integerNumber, int radix){
		return Integer.toString(integerNumber, radix);
	}
	
	/**
	 * This method gets the required representation of any number according to the
	 * given radix or base.
	 * @param integerNumber A integer number
	 * @param radix The radix or base to be used in the string representation
	 * @return The number representation in the specified radix
	 */
	public static String getRadixNumberInString(BigInteger integerNumber, int radix){
		return integerNumber.toString(radix);
	}
}

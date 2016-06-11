/**
 * 
 */
package com.mera.palindrome.api.utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import com.mera.palindrome.api.dto.PalindromeDTO;

/**
 * @author DavidCamilo
 *
 */
public class PalindromeHelper {

	/**
	 * The logger instance
	 */
	private static final Logger LOGGER = Logger
			.getLogger(PalindromeHelper.class);
	
	private final static String COMPLEXITY_MESSAGE = 
			"The algorithm complexity in Big O Notation is: "
			+ " O(N) + O(log N) = %s"
			+ "\n Where N = %s is all integer numbers to scan";

	/**
	 * Constructor
	 */
	private PalindromeHelper() {
		// empty
	}

	public static PalindromeDTO getPalindromeResponse(BigInteger minValue,
			BigInteger maxValue) {
		List<BigInteger> numbers = getNumbersBetweenRange(minValue, maxValue); // O(N)
		PalindromeDTO response = new PalindromeDTO(); //O(3)
		numbers.parallelStream()
				.filter(number -> filterPalindromeNumber(number, response))
				.peek(number -> printPalindrome(response, number))
				.collect(Collectors.toList());
		BigDecimal complexity = BigDecimal.valueOf(maxValue.doubleValue() + 
				(Math.log(maxValue.doubleValue()) / Math.log(2)));
		response.setBigOComplexity(String.format(COMPLEXITY_MESSAGE, complexity.toString(),  maxValue.toString()));
		return response;
	}

	/**
	 * This method generates all integer numbers between the given range
	 * 
	 * @param minValue
	 *            The minimum value of the range
	 * @param maxValue
	 *            The maximum value of the range
	 * @return A list which contains all numbers between the range
	 */
	public static List<BigInteger> getNumbersBetweenRange(BigInteger minValue,
			BigInteger maxValue) {
		List<BigInteger> numbers;
		if (maxValue.intValue() > Integer.MAX_VALUE) {
			numbers = new LinkedList<>();
		} else {
			numbers = new ArrayList<>();
		}
		BigInteger auxiliarNumber = minValue;
		for (; auxiliarNumber.compareTo(maxValue) < 1; auxiliarNumber = auxiliarNumber
				.add(BigInteger.ONE)) {
			numbers.add(auxiliarNumber);
		}
		return numbers;
	}

	/**
	 * 
	 * @param response
	 * @param number
	 */
	private static void printPalindrome(PalindromeDTO response,
			BigInteger number) {
		LOGGER.info(String.format("The number %s and the binary number %s are palindromes",
				number,
				response.getPalindromeStrings().get(number)));
	}

	/**
	 * 
	 * @param number
	 * @param response
	 * @return
	 */
	private static synchronized boolean filterPalindromeNumber(
			BigInteger number, PalindromeDTO response) {
		String integerNumber = number.toString();
		String binaryNumber = NumbersUtil.getBinaryNumberInString(number);
		boolean isPalindrome = StringsUtil.isPalindrome(integerNumber)
				&& StringsUtil.isPalindrome(binaryNumber);
		if (isPalindrome) {
			response.addPalindromeString(number, binaryNumber);
		}
		response.addIteration();
		return isPalindrome;
	}
}
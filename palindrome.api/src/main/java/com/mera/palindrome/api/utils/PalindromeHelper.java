/**
 * 
 */
package com.mera.palindrome.api.utils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

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

	private static final String COMPLEXITY_MESSAGE_V1 = "The algorithm complexity in Big O Notation is: "
			+ " O(N), where N = %s is the maximum integer number to be checked";
	
	private static final String COMPLEXITY_MESSAGE_V2 = "The algorithm complexity in Big O Notation is: "
			+ " O(log N), where N = %s is the maximum integer number to be checked";

	/**
	 * Constructor
	 */
	private PalindromeHelper() {
		// empty
	}

	/**
	 * This method gets all palindrome numbers; integer and binary form, into
	 * the range
	 * 
	 * @param minValue
	 *            The minimum value of the range
	 * @param maxValue
	 *            The maximum value of the range
	 * @return This object holds the palindrome numbers into the range, the
	 *         iterations and the complexity in Big O notation
	 * @deprecated It is too complex (O(n))
	 * @see
	 */
	public static PalindromeDTO getPalindromeResponse(BigInteger minValue,
			BigInteger maxValue) {
		List<BigInteger> numbers = getNumbersBetweenRange(minValue, maxValue); // O(N)
		PalindromeDTO response = new PalindromeDTO(); // O(3)
		numbers.parallelStream()
				.filter(number -> filterPalindromeNumber(number, response))
				.peek(number -> printPalindrome(response, number))
				.collect(Collectors.toList());
		response.setBigOComplexity(String.format(COMPLEXITY_MESSAGE_V1,
				maxValue.toString()));
		return response;
	}

	/**
	 * This method gets all palindrome numbers; integer and binary form, in
	 * parallel, into the range
	 * 
	 * @param minValue
	 *            The minimum value of the range
	 * @param maxValue
	 *            The maximum value of the range
	 * @return This object holds the palindrome numbers into the range, the
	 *         iterations and the complexity in Big O notation
	 */
	public static PalindromeDTO getPalindromeNumberInParallel(
			BigInteger minValue, BigInteger maxValue) {
		PalindromeDTO response = new PalindromeDTO();
		LongStream range = LongStream.range(minValue.longValue(),
				maxValue.longValue() + 1);
		range.parallel()
				.filter(number -> filterPalindromeNumber(BigInteger.valueOf(number), response))
				.forEach(number -> printPalindrome(response, BigInteger.valueOf(number)));
		range.close();
		response.setBigOComplexity(String.format(COMPLEXITY_MESSAGE_V2,
				maxValue.toString()));
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
	private static List<BigInteger> getNumbersBetweenRange(BigInteger minValue,
			BigInteger maxValue) {
		List<BigInteger> numbers;
		if (maxValue.longValue() > Integer.MAX_VALUE) {
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
	 * This method logs the palindrome numbers, in its integer and binary forms.
	 * 
	 * @param response
	 *            The object which stores the palindrome numbers
	 * @param number
	 *            The number which is used as key in the response object.
	 */
	private static void printPalindrome(PalindromeDTO response, BigInteger number) {
		LOGGER.info(String.format(
				"The number %s and the binary number %s are palindromes",
				number, response.getPalindromeStrings().get(number)));
	}

	/**
	 * This method returns if a number is palindrome number in its integer and
	 * binary form
	 * 
	 * @param number
	 *            The integer number to be checked
	 * @param response
	 *            A instance of {@link PalindromeDTO} to store the result
	 * @return True if the number is a palindrome string in its integer and
	 *         binary form. Otherwise, false.
	 */
	private static boolean filterPalindromeNumber(BigInteger number,
			PalindromeDTO response) {
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